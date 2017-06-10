package com.mit.law.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mit.law.model.Law;
import com.mit.law.view.activity.Clicks_on_law_dialog;
import com.mit.lawyered.R;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class LawsFragmentAdapter extends RecyclerView.Adapter<LawsFragmentAdapter.ViewHolder> {
    private List<Law> lawsList;
    private Context context;

    public LawsFragmentAdapter(Context context,List<Law> lawsList){
        this.lawsList = lawsList;
        this.context = context;
    }

    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = getContext();
        View lawRow = LayoutInflater.from(context).inflate(R.layout.laws_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(lawRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Law law = lawsList.get(position);

        //set data from the law
        holder.title.setText(law.getTitle());
        holder.shortDesc.setText(law.getShortDesc());

        holder.mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to mark the law broken
                Intent intent = new Intent(v.getContext(),Clicks_on_law_dialog.class);
                v.getContext().startActivity(intent);

            }
        });

        holder.viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launch law details activity

            }
        });

    }

    @Override
    public int getItemCount() {
        return lawsList.size();
    }

    public void setLawsList(List<Law> lawsList){
        this.lawsList = lawsList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView shortDesc;

        Button mark;
        Button viewMore;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvLawTitle);
            shortDesc = (TextView) itemView.findViewById(R.id.tvShortDescr);

            mark = (Button) itemView.findViewById(R.id.btnMark);
            viewMore = (Button) itemView.findViewById(R.id.btnView);
        }
    }
}
