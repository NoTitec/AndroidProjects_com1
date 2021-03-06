package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resulttxt;
    Spinner spinner;
    Button minus;
    Button plus;
    TextView count;
    CheckBox cockbutton;
    Button order;
    TextView appname;
    TextView myname;
    String resulttemptxt="";
    int counttxt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resulttxt=findViewById(R.id.resultview);
        appname=findViewById(R.id.textView2);
        myname=findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectitem=adapterView.getItemAtPosition(i).toString();
                resulttemptxt=selectitem;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        count=findViewById(R.id.countview);
        minus=findViewById(R.id.minusbutton);
        plus=findViewById(R.id.plusbutton);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --counttxt;
                count.setText(String.valueOf(counttxt));
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++counttxt;
                count.setText(String.valueOf(counttxt));
            }
        });

        cockbutton=findViewById(R.id.checkBox);

        order=findViewById(R.id.orderbutton);//=을 .으로 잘못씀.....ㅠㅠ
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tempvalue=0;
                String getcount=count.getText().toString();
                String finaltemptxt=resulttemptxt;
                if(cockbutton.isChecked()){
                    tempvalue=tempvalue+1000;
                }
                if(finaltemptxt.equals("라면")){
                    tempvalue+=2000*(Integer.parseInt(getcount));
                }
                else if(finaltemptxt.equals("스파게티")){
                    tempvalue+=3000*(Integer.parseInt(getcount));
                }
                else if (finaltemptxt.equals("햄버거")){
                    tempvalue+=4000*(Integer.parseInt(getcount));
                }
                finaltemptxt+=getcount;
                finaltemptxt+="개(";
                finaltemptxt+=cockbutton.getText().toString();
                finaltemptxt+=")를 주문했습니다.\n";
                finaltemptxt+="총액은 ";
                finaltemptxt+=Integer.toString(tempvalue);
                finaltemptxt+="원입니다.";


                resulttxt.setText(finaltemptxt);

            }
        });
    }
}