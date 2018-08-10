package com.example.grigor.fivefriendsmile.login;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.grigor.fivefriendsmile.R;

import java.util.Calendar;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameField;
    private EditText surnameField;
    private EditText usernameField;
    private EditText passwordField;
    private ImageButton calendarButton;
    private Calendar calendar;
    private int day;
    private int month;
    private int year;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Register Forme");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        calendarButton = (ImageButton) findViewById(R.id.imageButton1);
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        editText = (EditText) findViewById(R.id.editText);
        calendarButton.setOnClickListener(this);

        nameField = (EditText) findViewById(R.id.name_field);
        surnameField = (EditText) findViewById(R.id.surname_field);
        usernameField = (EditText) findViewById(R.id.username_field);
        passwordField = (EditText) findViewById(R.id.password_field);


    }

    @Override
    public void onClick(View v) {
        showDialog(0);

    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            editText.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };


    public void onRegisterButtonClick(View view) {
        String name = nameField.getText().toString();
        String surname = surnameField.getText().toString();
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        if (name.length() == 0
                || surname.length() == 0
                || username.length() == 0
                || password.length() == 0) {

            Toast.makeText(this, "please enter all fields", Toast.LENGTH_LONG).show();
            return;
        }

        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setUsername(username);
        person.setPassword(password);

        LoginActivity.arrayPerson.add(person);

//        Intent intent = new Intent(this,UserProfileActivity.class);
//        intent.putExtra("k1",name);
//        intent.putExtra("k2",surname);
//        intent.putExtra("k3",username);
//        startActivity(intent);
//        finish();


    }


}
