package com.example.grigor.fivefriendsmile.dantiststypeexpandablelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.grigor.fivefriendsmile.MainActivity;
import com.example.grigor.fivefriendsmile.R;

public class TypesOfDantists extends AppCompatActivity implements View.OnClickListener {

    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_dantists);

//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TypesOfDantists.this.finish();
//                Intent intent = new Intent(TypesOfDantists.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        String name = (String) getIntent().getSerializableExtra("stomName");
//        toolbar.setTitle(name);
//
//        button_1 = (Button) findViewById(R.id.button_1);
//        button_2 = (Button) findViewById(R.id.button_2);
//        button_3 = (Button) findViewById(R.id.button_3);
//        button_4 = (Button) findViewById(R.id.button_4);
//        button_5 = (Button) findViewById(R.id.button_5);
//        button_6 = (Button) findViewById(R.id.button_6);
//        button_1.setOnClickListener(this);
//        button_2.setOnClickListener(this);
//        button_3.setOnClickListener(this);
//        button_4.setOnClickListener(this);
//        button_5.setOnClickListener(this);
//        button_6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                Intent intent = new Intent(TypesOfDantists.this, Doctors.class);
                startActivity(intent);
                break;
            case R.id.button_2:
                Intent intent_1 = new Intent(TypesOfDantists.this, Doctors.class);
                startActivity(intent_1);
                break;
            case R.id.button_3:
                Intent intent_3 = new Intent(TypesOfDantists.this, Doctors.class);
                startActivity(intent_3);
                break;
//            case R.id.button_4:
//                Intent intent_4 = new Intent(TypesOfDantists.this, Doctors.class);
//                startActivity(intent_4);
//                break;
//            case R.id.button_5:
//                Intent intent_5 = new Intent(TypesOfDantists.this, Doctors.class);
//                startActivity(intent_5);
//                break;
//            case R.id.button_6:
//                Intent intent_6 = new Intent(TypesOfDantists.this, Doctors.class);
//                startActivity(intent_6);
//                break;
        }
    }
}