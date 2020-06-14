package com.example.android.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    TextView mtvDisplay;
    Button btnBack;
    Button btnBackDelete;
    int selectcount=0;
    boolean[] selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        mtvDisplay=(TextView)findViewById(R.id.tv_display);
        btnBack=(Button)findViewById(R.id.btn_back);
        btnBackDelete=(Button)findViewById(R.id.btn_BackDelete);

        Intent intent1 = this.getIntent();
        selectcount=intent1.getIntExtra("selectCount",0);
        selected=intent1.getBooleanArrayExtra("selected");
        if(selectcount!=0){
            mtvDisplay.setText("You've selected "+selectcount+" items!");
        }else{
            mtvDisplay.setText("You've selected 0 items!");
        }
    }

    public void ClickBack(View view){
        Intent intent2=new Intent();
        intent2.setClass(ChildActivity.this,MainActivity.class);
        intent2.putExtra("selectCount",selected);
        startActivity(intent2);
    }

    public void ClickBackDelete(View view){
        Intent intent3=new Intent();
        intent3.setClass(ChildActivity.this,MainActivity.class);
        intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent3);
    }

}
