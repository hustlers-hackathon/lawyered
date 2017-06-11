package com.mit.law.controller.adapter;

/**
 * Created by Ahmed on 6/10/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import com.mit.law.controller.firebase.SeeNotificationController;
import com.mit.law.controller.firebase.ThirdPartyController;
import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.controller.interfaces.OnResponseThirdParties;
import com.mit.law.model.Notification;
import com.mit.law.model.ThirdParties;
import com.mit.law.view.activity.Lawyer_clicks_on_notification;
import com.mit.law.view.activity.LocationRulesActivity;
import com.mit.law.view.activity.ProfileDetailsActivity;
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
        final Notification noti = notificationList.get(position);
        int type=0;
        if(noti.getType().equalsIgnoreCase("caseRequest")){
            type=1;
        }else if(noti.getType().equalsIgnoreCase("caseAccept")){
            type =2;
        }else if(noti.getType().equalsIgnoreCase("location")){
            type = 3;
        }

        switch (type){
            case 1://caseRequest
                holder.item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       new SeeNotificationController(noti);//here put the new reponder and rest of the code into the if condition

                        Intent intent = new Intent(getContext(), Lawyer_clicks_on_notification.class);
                        Bundle extra = new Bundle();
                        extra.putParcelable("noti",noti);
                        intent.putExtras(extra);
                        getContext().startActivity(intent);
                    }
                });
                break;
            case 2://caseAccept
                holder.item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new SeeNotificationController(noti);
                        String lawyerID = noti.getLawyerID();
                        new ThirdPartyController(new OnResponse() {
                            @Override
                            public void responded(Object obj) {
                                ThirdParties lawyer = (ThirdParties)obj;
                                Intent intent = new Intent(getContext(), ProfileDetailsActivity.class);
                                Bundle extra = new Bundle();
                                extra.putParcelable("Lawyer",lawyer);
                                intent.putExtras(extra);
                                getContext().startActivity(intent);
                            }
                        },lawyerID);
                    }
                });
                break;

            case 3://location
                holder.item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //new SeeNotificationController(noti);
                        Intent intent = new Intent(getContext(), LocationRulesActivity.class);
                        Bundle extras = new Bundle();
                        extras.putParcelable("noti",noti);
                        intent.putExtras(extras);
                        getContext().startActivity(intent);
                    }
                });
                break;
        }


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
        View item;
        public ViewHolder(View itemView) {
            super(itemView);
            item = itemView;
            title = (TextView) itemView.findViewById(R.id.tvNotTitle);
            desc = (TextView) itemView.findViewById(R.id.tvNotDescription);
            imgIcon = (ImageView)itemView.findViewById(R.id.imgNotIcon);
        }
    }
}