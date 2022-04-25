package com.example.recycler1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter> {
    ArrayList<item> mainitem;
    public Adapter(ArrayList<item> items) {
        this.mainitem=items;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {
        String one=mainitem.get(position).getCount();
        holder.onetext.setText(one);
    }

    @Override
    public int getItemCount() {
        return mainitem.size();
    }

    class MyAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView onetext;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            onetext = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int select=getLayoutPosition();//리사이클러뷰에서 선택된 인덱스 반환
            String curname=mainitem.get(select).getCount();
            mainitem.get(select).setCount(curname+"clicked");
            Adapter.this.notifyDataSetChanged();//어댑터에게 데이터 변경됨을 알려줌
        }
    }
}
