package com.moringaschool.rubisenergies.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.annotations.Nullable;
import com.moringaschool.rubisenergies.R;
import com.moringaschool.rubisenergies.models.Event;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link EventViewFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class EventViewFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public EventViewFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment EventViewFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static EventViewFragment newInstance(String param1, String param2) {
//        EventViewFragment fragment = new EventViewFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_event_view, container, false);
//    }

    @BindView(R.id.eventImageView)ImageView eventImageView;
    @BindView(R.id.eventName) TextView eventName;
    @BindView(R.id.date) TextView date;
    @BindView(R.id.category) TextView category;
    @BindView(R.id.url) TextView url;

    private Event mEvents;

    public EventViewFragment() {
        // Required empty public constructor
    }
    public static EventViewFragment newInstance(Event eventListFinal) {
        EventViewFragment eventViewFragment  = new EventViewFragment ();
        Bundle args = new Bundle();
        args.putParcelable("eventListFinal", Parcels.wrap(eventListFinal));
        eventViewFragment.setArguments(args);
        return eventViewFragment;
    }

    //Oncreate Method
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mEvents = Parcels.unwrap(getArguments().getParcelable("eventListFinal"));
    }
    // Override fragment layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_event_view, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mEvents.getImageUrl()).into(eventImageView);

        eventName.setText(mEvents.getName());
        url.setText(mEvents.getTicketsUrl());
        category.setText(mEvents.getCategory());
//        date.setText(mEvents.getTimeStart());

        return view;
    }

}