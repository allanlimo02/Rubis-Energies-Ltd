package com.moringaschool.rubisenergies.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.rubisenergies.models.Event;
import com.moringaschool.rubisenergies.ui.EventViewFragment;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
   private List<Event> eventListFinal;


    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Event> eventListFinals) {
        super(fm, behavior);
        this.eventListFinal = eventListFinals;
    }

    @NonNull
    @Override
    public int getCount() {
        return eventListFinal.size();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return EventViewFragment.newInstance(eventListFinal.get(position));
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return eventListFinal.get(position).getName();
    }
}
