package com.mit.law.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mit.law.model.ThirdParties;
import com.mit.lawyered.R;

import java.util.List;

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
        ThirdParties thirdParty = thirdParties.get(position);

        //holder.profName.setText(thirdParty.);
        //holder.profRate.setText(thirdParty.);
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
            shortDesc = (TextView) itemView.findViewById(R.id.tvShortDescr);
            btnViewMore = (Button) itemView.findViewById(R.id.btnViewFull);
        }
    }
}
