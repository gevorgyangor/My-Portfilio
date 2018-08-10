package com.example.grigor.fivefriendsmile.dentiststype;




import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.grigor.fivefriendsmile.MainActivity;
import com.example.grigor.fivefriendsmile.R;


public class TypesOfDantists extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_dantists);
        mFragmentManager = getFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar_type_dentists);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(" Type Of Dentist  ");

        Button button = (Button) findViewById(R.id.preventive_services_button);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TypesOfDantists.this.finish();
                Intent intent = new Intent(TypesOfDantists.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }




    public void typeOfdenyistClick(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        DoctorList doctorList = new DoctorList();
        mFragmentTransaction.replace(R.id.container, doctorList);
        mFragmentTransaction.commit();
          switch (view.getId()){
              case R.id.preventive_services_button:
                  toolbar.setTitle("Preventive Services");
                  break;
              case R.id.restorative_services_button:
                  toolbar.setTitle("Restorative Services");
                  break;
              case R.id.cosmetic_procedures_button:
                  toolbar.setTitle("Cosmetic Procedures");
                  break;
              case R.id.overall_health_concerns_button:
                  toolbar.setTitle("Overall Health Concerns");
                  break;

          }

    }
}
