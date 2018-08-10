package com.example.grigor.fivefriendsmile.doctorpage;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.grigor.fivefriendsmile.R;
import com.example.grigor.fivefriendsmile.dantiststypeexpandablelist.TypesOfDantists;
import com.example.grigor.fivefriendsmile.login.LoginActivity;


import java.util.Calendar;

public class Doctor extends AppCompatActivity implements View.OnClickListener{

  private ImageButton calendarButton;
  private Calendar calendar;
  private int day;
  private int month;
  private int year;
  EditText editText;
  RadioGroup radioGroup;
  ImageButton callButton;
  Spinner spinner;
  ArrayAdapter<CharSequence> adapter;

  private RadioButton nine, ten, twelve, one, tree, four, six;
  private Button confirmButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        spinner = (Spinner) findViewById(R.id.spinner);
//        adapter = ArrayAdapter.createFromResource(this, R.array.about_doctor, android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_doctor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Name Surname");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doctor.this.finish();
                Intent intent = new Intent(Doctor.this, TypesOfDantists.class);
                startActivity(intent);
            }
        });

        confirmButton = (Button) findViewById(R.id.confirm_button);
        callButton = (ImageButton) findViewById(R.id.call_button);
        callButton.setOnClickListener(this);
        confirmButton.setOnClickListener(this);
        nine = (RadioButton) findViewById(R.id.nine);
        ten = (RadioButton) findViewById(R.id.ten);
        twelve= (RadioButton) findViewById(R.id.twelve);
        one = (RadioButton) findViewById(R.id.one);
        tree = (RadioButton) findViewById(R.id.tree);
        four = (RadioButton) findViewById(R.id.four);
        six = (RadioButton) findViewById(R.id.six);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        initCalendar();

      }






    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm_button:
                 int ischechked = radioGroup.getCheckedRadioButtonId();
                 switch (ischechked){
                    case R.id.nine:
                        nine.setBackgroundColor(Color.RED);
                        Toast.makeText(Doctor.this, "your reserve to 09 : 00 - 10 : 30", Toast.LENGTH_SHORT).show();
                        view.setClickable(false);
                        break;
                    case R.id.ten:
                        ten.setBackgroundColor(Color.RED);
                        Toast.makeText(Doctor.this, "your reserve to 10 : 45 - 12 : 00", Toast.LENGTH_SHORT).show();
                        view.setClickable(false);
                        break;
                    case R.id.twelve:
                        twelve.setBackgroundColor(Color.RED);
                        Toast.makeText(Doctor.this, "your reserve to 12 : 15 - 13 : 30", Toast.LENGTH_SHORT).show();
                        view.setClickable(false);
                        break;
                    case R.id.one:
                        one.setBackgroundColor(Color.RED);
                        Toast.makeText(Doctor.this, "your reserve to 13 : 45 - 15 : 00", Toast.LENGTH_SHORT).show();
                        view.setClickable(false);
                        break;
                    case R.id.tree:
                        tree.setBackgroundColor(Color.RED);
                        Toast.makeText(Doctor.this, "your reserve to 15 : 15 - 16 : 30", Toast.LENGTH_SHORT).show();
                        view.setClickable(false);
                        break;
                    case R.id.four:
                        four.setBackgroundColor(Color.RED);
                        Toast.makeText(Doctor.this, "your reserve to 16 : 45 - 18 : 00", Toast.LENGTH_SHORT).show();
                        view.setClickable(false);
                        break;
                    case R.id.six:
                        six.setBackgroundColor(Color.RED);
                        Toast.makeText(Doctor.this, "your reserve to 18 : 15 - 19 : 45", Toast.LENGTH_SHORT).show();
                        view.setClickable(false);
                        break;

                }
                 break;
            case R.id.calendar_button:
                showDialog(0);
                 break;
            case R.id.call_button:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:077109692"));
                startActivity(intent);
                break;
        }
    }



    private void initCalendar() {

        calendarButton = (ImageButton) findViewById(R.id.calendar_button);
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        editText = (EditText) findViewById(R.id.editText);
        calendarButton.setOnClickListener(this);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            editText.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };


    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

}

