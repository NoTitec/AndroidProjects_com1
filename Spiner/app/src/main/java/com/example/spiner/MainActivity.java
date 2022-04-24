package com.example.spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String localDataSet[]={"apple","mango","watermallon","mellon","orange","grape","pineapple"};//스피너 데이터
    TextView txt;
    TextView listtxt;
    Spinner spinner;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.textView);
        listtxt=findViewById(R.id.textView2);
        spinner =(Spinner) findViewById(R.id.spinner);
        listview=(ListView) findViewById(R.id.listview);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);//메소드로 생성 context,데이터,레이아웃
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String select_item=adapterView.getItemAtPosition(i).toString();//setAdapter한 어댑터뷰에서 선택된문자가져옴
                txt.setText(select_item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //구현필요 x
            }
        });
        // 리스너 등록방법 2 클래스에 implements AdapterView.OnItemSelectedListener 후에 spinner.setOnItemSelectedListener(this);
        //한다음 메소드 오버라이딩

        ArrayAdapter<String> Stringadapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,localDataSet);//생성자로 어댑터 생성 context,레이아웃,데이터
        listview.setAdapter(Stringadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listtxt.setText(localDataSet[i]);
            }
        });
    }

    /*@Override//implements 인터페이스 구현 메소드
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {//AdapterView<?> 는 제네릭 뭐가오든 받아들이겠다
        String select_item=adapterView.getItemAtPosition(i).toString();//setAdapter한 어댑터뷰에서 선택된문자가져옴
        txt.setText(select_item);
        //working code
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
}