package com.moringaschool.rubisenergies.ui;

import android.content.Context;
import android.widget.ArrayAdapter;

public class EventAdapter extends ArrayAdapter {
    private Context content;
    private String[] foods;

    public EventAdapter(Context content, int resource, String[] foods) {
        super(content,resource);
        this.content = content;
        this.foods = foods;
    }
    @Override
    public Object getItem(int position) {
        String food = foods[position];
        return String.format( "Is Happpening");
    }

    @Override
    public int getCount() {
        return foods.length;
    }
}
