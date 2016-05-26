package com.programandoando.hamp.dbandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAMP on 25/05/2016.
 */
public class ListAdapter
        extends
        RecyclerView.Adapter<ListAdapter.ListViewHolder>{

    Context context;
    List<UserData> dataList=new ArrayList<>();
    LayoutInflater inflater;
    Listener listener;

    public ListAdapter(Context context, List<UserData> dataList1) {
        this.context=context;
        this.dataList=dataList1;
        inflater=LayoutInflater.from(context);
        this.listener=(Listener)context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cV=inflater.inflate(R.layout.row,
                parent,false);
        ListViewHolder viewHolder=
                new ListViewHolder(cV);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.iv_delete.setTag(position);
        holder.tv_name.setText(dataList.get(position).getNombre());

        holder.iv_delete.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        listener.nameToChange(
                                dataList.get((Integer)
                                        v.getTag())
                                        .getNombre());
                    }
                });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        ImageView iv_delete;

        public ListViewHolder(View itemView) {
            super(itemView);
            tv_name=(TextView) itemView.
                    findViewById(R.id.tv_name);
            iv_delete=(ImageView)itemView.
                    findViewById(R.id.iv_delete);
        }
    }
}
