package com.moringaschool.rubisenergies.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.rubisenergies.R;
import com.moringaschool.rubisenergies.models.Event;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.eventViewAdapter>{
    private List<Event> eventList;
    private Context context;

    public ListAdapter( Context context,List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }
    @Override
    public ListAdapter.eventViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item,parent,false);
        eventViewAdapter viewHolder= new eventViewAdapter (view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull eventViewAdapter holder, int position) {
        holder.bindEvent(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
    public class eventViewAdapter extends RecyclerView.ViewHolder{
        @BindView(R.id.eventImageView) ImageView eventImageView;
        @BindView(R.id.eventName) TextView eventName;
        @BindView(R.id.date) TextView date;
        @BindView(R.id.category) TextView category;
        @BindView(R.id.url) TextView url;

        private Context mContext;

        public eventViewAdapter( View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext=itemView.getContext();
        }
        public void bindEvent(Event event) {
            eventName.setText(event.getName());
            date.setText(event.getTimeStart());
            category.setText(event.getCategory());
            url.setText(event.getTicketsUrl());
            Picasso.get().load(event.getImageUrl()).into(eventImageView);


        }

    }

}