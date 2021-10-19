package com.moringaschool.rubisenergies.ui;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class EventAdapter extends ArrayAdapter {
    public EventAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public EventAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public EventAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
    }

    public EventAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public EventAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public EventAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }


//    private Context content;
//    private String[] foods;
//
//    public EventAdapter(Context content, int resource, String[] foods) {
//        super(content,resource);
//        this.content = content;
//        this.foods = foods;
//    }
//    @Override
//    public Object getItem(int position) {
//        String food = foods[position];
//        return String.format( "Is Happpening");
//    }
//
//    @Override
//    public int getCount() {
//        return foods.length;
//    }
}
