package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.IDN;

public class PassingIntentsExercise2 extends AppCompatActivity {

    Button btnReturn, btnClear;
    TextView tFname, tGender, tPnum, tLname, tBdate, tEmail, tMaritalStatus,tAge, tAddress,tIDNum, tProg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        init();
        data();

        btnReturn = findViewById(R.id.btnPIReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        PassingIntentsExercise2.this,
                        PassingIntentsExercise.class);
                startActivity(intent);
            }
        });

    }

    public void init(){
        tFname = findViewById(R.id.textView15);
        tLname = findViewById(R.id.textView17);
        tGender = findViewById(R.id.textView19);
        tMaritalStatus = findViewById(R.id.textView21);
        tAge = findViewById(R.id.textView23);
        tAddress = findViewById(R.id.textView25);
        tIDNum = findViewById(R.id.textView27);
        tProg = findViewById(R.id.textView29);
        tBdate = findViewById(R.id.textView31);
        tPnum = findViewById(R.id.textView33);
        tEmail = findViewById(R.id.textView35);
    }

    public void data(){
        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname_key");
        String lname = intent.getStringExtra("lname_key");
        String gender = intent.getStringExtra("gender_key");
        String Marital = intent.getStringExtra("marital_key");
        String age = intent.getStringExtra("age_key");
        String add = intent.getStringExtra("address_key");
        String IDNum = intent.getStringExtra("idNum_key");
        String prog = intent.getStringExtra("prog_key");
        String bDate = intent.getStringExtra("bdate_key");
        String pNum = intent.getStringExtra("pnum_key");
        String eAdd = intent.getStringExtra("eadd_key");

        tFname.setText(fname);
        tLname.setText(lname);
        tGender.setText(gender);
        tMaritalStatus.setText(Marital);
        tAge.setText(age);
        tAddress.setText(add);
        tIDNum.setText(IDNum);
        tProg.setText(prog);
        tBdate.setText(bDate);
        tPnum.setText(pNum);
        tEmail.setText(eAdd);
    }
}