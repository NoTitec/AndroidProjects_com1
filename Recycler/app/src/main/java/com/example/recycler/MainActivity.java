package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
//Linear layout layout_height속성 주의!!!!!!!!!!!!!
/*1.메인레이아웃,아이템레이아웃작성
    2.메인엑티비티에 사용할 데이터, 리사이클러뷰,어댑터 참조변수 정의
    3.어댑터만들기
*/

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> itemlist = new ArrayList<>();
    RecyclerView recyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=1;i<10;i++){
            itemlist.add(new Item(Integer.toString(i)));
        }

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new Adapter( itemlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//리사이클러뷰의 레이아웃설정
    }
}