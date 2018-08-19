package com.example.saurav.delenstask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurav.delenstask.model.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {


    private static final String TAG =OrderAdapter.class.getName() ;
    private Context context;
    private ArrayList<Entity> l;

    public OrderAdapter(Context ct, ArrayList<Entity> l) {
        this.context = ct;
        this.l = l;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new OrderHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        if (l != null) {
            Entity e = l.get(position);
            holder.TVdeliveredDate.setText(""+e.getDelivered_date());
//            holder.TVdeliveredDate.setText("--");
            holder.TVStatus.setText(""+e.getStatus());
            holder.TVID.setText(""+e.getId());
            holder.TVTotalAmount.setText(""+e.getRate());
            holder.TVJobType.setText(""+e.getJob_type());
        }else
            Log.i(TAG, "onBindViewHolder: + Data is null Error in Binding Data");
    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView TVdeliveredDate;
        TextView TVStatus;
        TextView TVID;
        TextView TVTotalAmount;
        TextView TVJobType;

        public OrderHolder(View itemView) {
            super(itemView);
            TVdeliveredDate=(TextView)itemView.findViewById(R.id.TVdeliveredDate);
             TVStatus=(TextView)itemView.findViewById(R.id.TVStatus);
             TVID=(TextView)itemView.findViewById(R.id.TVID);
             TVTotalAmount=(TextView)itemView.findViewById(R.id.TVTotalAmount);
             TVJobType=(TextView)itemView.findViewById(R.id.TVJobType);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Entity e =l.get(getAdapterPosition());
            Intent intent = new Intent(context, OrderDetailsActivity.class);
            intent.putExtra("Entity", e);
            context.startActivity(intent);

        }
    }
}
