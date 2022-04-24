package com.example.countconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count=0;
    TextView txtCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//AppCompatActivity override Bundle 객체는 실행환경
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//AppCompatActivity에있는 메소드 R은 res폴더의 xml문서를 c++의 include처럼 끌고과서 객체로 바꾸는 작업을 진행함
        //위 setcontent로 화면을 띄우고 그다음부터 이벤트처리 메소드를 처리하는 메소드를 작성한다
        txtCount=findViewById(R.id.txtCount);//textview id 객체 가져옴 이 위치가중요하다 이게 save정보 로드로직보다 아래있으면 다시 초기상태를 덮어씌워버린다
        if(savedInstanceState!=null){
            String scount=savedInstanceState.getString("curcount");
            if(txtCount!=null) {
                count=Integer.valueOf(scount);
                txtCount.setText(String.valueOf(count));
            }
        }

        Button clickbutton=findViewById(R.id.btnClick);//button객체 가져옴
        Button resetbutton=findViewById(R.id.resetClick);//reset button
        //button눌려짐에따른 이벤트처리
        clickbutton.setOnClickListener(new View.OnClickListener() {//button에 리스너 등록
            @Override
            public void onClick(View view) {
                ++count;
                txtCount.setText(String.valueOf(count));//txtcount객체의 text변경메소드 추가
            }
        });

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=0;
                txtCount.setText(String.valueOf(count));
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString("curcount",String.valueOf(txtCount.getText()));

    }
    @Override
    protected void onStart() {

        super.onStart();
        Log.e("!!!!!!!!!!!!!!!!!!!!","Onstart called");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
// The activity is between stopped and started.
        Log.e("!!!!!!!!!!!!!!!!!!!!","Onrestart called");

    }
    @Override
    protected void onResume() {//앱 시작시 실행3 백그라운드에서 돌아올때 실행3
        super.onResume();
// The activity has become visible
// it is now "resumed"
        SharedPreferences myPrefs = getSharedPreferences("mySaveStateArea", MainActivity.MODE_PRIVATE);
        if (myPrefs != null && myPrefs.contains("Counter")) {
            String uCount = myPrefs.getString("Counter", "");
            count = Integer.valueOf(uCount);
            txtCount.setText(uCount);
            Log.e("!!!!!!!!!!!!!!!!!!!!", "Onresume called");
        }
    }
    @Override
    protected void onPause() {//앱 백그라운드갈때 실행
        super.onPause();
// Another activity is taking focus
// this activity is about to be "paused"
        SharedPreferences myPrefs = getSharedPreferences("mySaveStateArea", MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();//SharedPreferences의 Editor이용
        editor.putString("Counter", txtCount.getText().toString());//데이터타입에따라 추가
        editor.commit();//commit해야적용
        Log.e("!!!!!!!!!!!!!!!!!!!!","Onpause called");
    }

    @Override
    protected void onStop() {//앱 백그라운드갈때 실행
        super.onStop();
// The activity is no longer visible
// it is now "stopped"
        Log.e("!!!!!!!!!!!!!!!!!!!!","Onstop called");
    }
    @Override
    protected void onDestroy() {//앱 종료될때 실행
        super.onDestroy();
// The activity is about to be destroyed.
        Log.e("!!!!!!!!!!!!!!!!!!!!","Ondestroy called");
    }

}