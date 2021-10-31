package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Parcel;

import com.moringaschool.rubisenergies.Adapters.FragmentAdapter;
import com.moringaschool.rubisenergies.R;
import com.moringaschool.rubisenergies.models.Event;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetail extends AppCompatActivity {
    @BindView(R.id.viewPager)  ViewPager mViewPager;

    private FragmentAdapter fragmentAdapter;
    List<Event> mEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);

        mEvents= Parcels.unwrap(getIntent().getParcelableExtra("eventList"));
        int startingPosition= getIntent().getIntExtra("position", 0);

        fragmentAdapter= new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mEvents);
        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setCurrentItem(startingPosition);
    }
}