package com.mit.law.controller.adapter;

/**
 * Created by Ahmed on 6/10/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mit.law.model.Law;
import com.mit.law.model.Notification;
import com.mit.lawyered.R;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private List<Notification> notificationList;
    private Context context;

    public NotificationAdapter(Context context,List<Notification> notificationList){
        this.notificationList = notificationList;
        this.context = context;
    }

    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = getContext();
        View lawRow = LayoutInflater.from(context).inflate(R.layout.notifications_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(lawRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Notification noti = notificationList.get(position);

        //set data from the law
        holder.title.setText(noti.getType());
        holder.desc.setText(noti.getDesc());

        holder.imgIcon.setImageResource(R.drawable.common_google_signin_btn_icon_light_normal);



    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public void setNotificationList(List<Notification> notificationList){
        this.notificationList = notificationList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgIcon;
        TextView  title;
        TextView desc;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvNotTitle);
            desc = (TextView) itemView.findViewById(R.id.tvNotDescription);
            imgIcon = (ImageView)itemView.findViewById(R.id.imgNotIcon);
        }
    }
}