package com.example.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//Linear layout layout_height속성 주의!!!!!!!!!!!!!
/*
 1.리사이클러뷰.어댑터상속 이 어댑터는 뷰홀더를 받는데 기본 RecyclerView.viewHolder도 있지만 직접 정의하면
 현재클래스.정의한 뷰홀더클래스
 2.어댑터의 생성자로 메인의 데이터 받아옴
 3.뷰홀더 클래스 inner클래스로 정의 recyclerview.viewholder상속받음
 뷰홀더 레이아웃에있는 객체 생성한다
 4. oncreateviewholder에서 새로운 View 하나를 inflate로 만들어 onbindviewholder에게 전달
 5. onbindviewholder에서 position의 데이터를 꺼낸뒤 그 데이터를 oncreate에게 전달받은 뷰홀더 틀에 넣어줌
 6. 리스너는 inner뷰홀더 클래스에 implements하여 onclick메소드 작성onclick메소드에서 getLayoutPosition으로 선택인덱스이용하여
 데이터를 받아올수있고 또한 데이터를 변경할 수도 있다 이렇게 변경을한뒤에 어댑터클래스에게 데이터 변경을 알려주기 위하여 notifydatachanged
 메소드를 사용해야 한다
  */
public class Adapter extends RecyclerView.Adapter<Adapter.MyviewHolder> {
    ArrayList<Item> aitem;
    public Adapter( ArrayList<Item>gitem) {
        this.aitem=gitem;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//parent가 곧 리사이클러뷰이며 이메소드는 틀을만들어 bind메소드에 전달
        //MyviewHolder를 하나만들어서 bind에게 던져줌
        //뷰홀더 하나 던져주기위해선 View객체에 리사이클러뷰를 inflater한걸넣고 그걸 뷰홀더 생성자에 던져주어 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
    //bind는 main에서 전달받은 아이템을 oncreateviewholder에서 받은 뷰홀더 틀에 연결한다
        String one=aitem.get(position).getName();//main에서받은 arraylist중 position값 가져옴
        holder.holdertextview.setText(one);//가져온값 뷰홀더틀에 집어넣기
    }

    @Override
    public int getItemCount() {
        return aitem.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{//itemview layout 구성요소 가져옴 리스너도 여기서 구현
        TextView holdertextview;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            holdertextview=itemView.findViewById(R.id.textholder);
            itemView.setOnClickListener(this);//리스너가 이 클래스에 있음
        }

        @Override
        public void onClick(View view) {
            int select=getLayoutPosition();//리사이클러뷰에서 선택된 인덱스 반환
            String curname=aitem.get(select).getName();
            aitem.get(select).setName(curname+"clicked");
            Adapter.this.notifyDataSetChanged();//어댑터에게 데이터 변경됨을 알려줌
        }
    }


}
