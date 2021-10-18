package com.moringaschool.rubisenergies.ui;

import android.content.Context;
import android.widget.ArrayAdapter;

public class FoodAdapter extends ArrayAdapter {
    private Context content;
    private String[] foods;

    public FoodAdapter(Context content, int resource, String[] foods) {
        super(content,resource);
        this.content = content;
        this.foods = foods;
    }
    @Override
    public Object getItem(int position) {
        String food = foods[position];
        return String.format("%s Has great: %s", "foods");
    }

    @Override
    public int getCount() {
        return foods.length;
    }
}
