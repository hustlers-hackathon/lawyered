package com.mit.law.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mit.law.model.ThirdParties;
import com.mit.law.view.activity.ProfileDetailsActivity;
import com.mit.lawyered.R;

import java.util.List;

import static com.mit.lawyered.R.id.btnViewMore;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class ThirdPartyAdapter extends RecyclerView.Adapter<ThirdPartyAdapter.ViewHolder> {
    List<ThirdParties> thirdParties;
    Context context;

    public ThirdPartyAdapter(Context context,List<ThirdParties> thirdParties){
        this.thirdParties = thirdParties;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = getContext();
        View profRow = LayoutInflater.from(context).inflate(R.layout.profiles_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(profRow);
        return viewHolder;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ThirdParties thirdParty = thirdParties.get(position);

        holder.profName.setText(thirdParty.getName());
        holder.profRate.setText(thirdParty.getReviewAvg()+"");
        holder.shortDesc.setText(thirdParty.getDesc());
        holder.btnViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileDetailsActivity.class);
                Bundle extras = new Bundle();
                extras.putParcelable("Lawyer",thirdParty);
                intent.putExtras(extras);
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return thirdParties.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView profName;
        TextView profRate;
        TextView shortDesc;
        Button btnViewMore;

        public ViewHolder(View itemView) {
            super(itemView);

            profName = (TextView) itemView.findViewById(R.id.tvProfName);
            profRate = (TextView) itemView.findViewById(R.id.tvProfRate);
            shortDesc = (TextView) itemView.findViewById(R.id.tvProfShort);
            btnViewMore = (Button) itemView.findViewById(R.id.btnViewFull);
        }
    }
}
