package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result=findViewById(R.id.orderresult);
        CheckBox addbutton=findViewById(R.id.addcheck);
        CheckBox nobutton=findViewById(R.id.nocheck);
        Button pay=findViewById(R.id.orderbutton);
        RadioButton americano=findViewById(R.id.AmericanoRadio);
        RadioButton latte=findViewById(R.id.LatteRadio);
        RadioButton cafuchino=findViewById(R.id.CafuchinoRadio);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checked="";
                if(americano.isChecked()){
                    checked=americano.getText().toString();
                }
                if(latte.isChecked()){
                    checked=latte.getText().toString();
                }
                if(cafuchino.isChecked()){
                    checked=cafuchino.getText().toString();
                }
                if((addbutton.isChecked()&&nobutton.isChecked())||(!addbutton.isChecked()&&!nobutton.isChecked())) {
                    Log.e("error",checked);//logcat 에 빨간색으로 표기된다
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();//잠시나오는 메시지

                }
                else{
                    if (addbutton.isChecked()) {
                        checked += addbutton.getText().toString();
                        result.setText(checked);

                    } else if (nobutton.isChecked()) {
                        checked += nobutton.getText().toString();
                        result.setText(checked);

                    }
                }
            }
        });
    }
}