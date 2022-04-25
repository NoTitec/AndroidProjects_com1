package com.example.recycler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;

import java.util.ArrayList;
//Linear layout layout_height속성 주의!!!!!!!!!!!!!
/*1.메인레이아웃,아이템레이아웃작성
    2.메인엑티비티에 사용할 데이터, 리사이클러뷰,어댑터 참조변수 정의
    3.어댑터만들기
*/

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> itemlist = new ArrayList<>();//ArrayList 생성시 반드시 생성자로 생성
    RecyclerView recyclerView;
    Adapter adapter;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private static Bundle mBundleRecyclerViewState;
    private Parcelable mListState = null;
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
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

}