package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class PassingIntentsExercise extends AppCompatActivity {

    TextView eFName, eLName, eAge,eAdd,eIDNum,eProg,eBDate,eNum,eMail;
    RadioButton rMale,rFem,rOth,rSingle,rMarried,rDivorced,rWidowed;

    public void onClick(View v){
        eFName = findViewById(R.id.etxtFName);
        eLName = findViewById(R.id.etxtLName);
        eAge = findViewById(R.id.etxtAge);
        eAdd = findViewById(R.id.etxtAddress);
        eIDNum = findViewById(R.id.etxtIDNumber);
        eProg = findViewById(R.id.etxtProgram);
        eBDate = findViewById(R.id.etxtBdate);
        eNum = findViewById(R.id.etxtPhoneNumber);
        eMail = findViewById(R.id.etxtEmailAdd);
        rMale = findViewById(R.id.radMale);
        rFem = findViewById(R.id.radFemale);
        rOth = findViewById(R.id.radOthers);
        rSingle = findViewById(R.id.radSingle);
        rMarried = findViewById(R.id.radMarried);
        rDivorced = findViewById(R.id.radDivorced);
        rWidowed = findViewById(R.id.radWidowed);


        String fName = eFName.getText().toString();
        String lName = eLName.getText().toString();

        String gender;
        if(rMale.isChecked())
            gender = "Male";
        else if (rFem.isChecked())
            gender = "Female";
        else if (rOth.isChecked())
            gender = "Others";
        else
            gender = "Unknown";

        String marital;
        if(rSingle.isChecked())
            marital = "Single";
        else if (rMarried.isChecked())
            marital = "Married";
        else if (rDivorced.isChecked())
            marital = "Divorced";
        else if (rWidowed.isChecked())
            marital = "Widowed";
        else
            marital = "Unknown";

        String age = eAge.getText().toString();
        String add = eAdd.getText().toString();
        String idNum = eIDNum.getText().toString();
        String prog = eProg.getText().toString();
        String bDate = eBDate.getText().toString();
        String pNumber = eNum.getText().toString();
        String emailAdd = eMail.getText().toString();

        Intent intent = new Intent (PassingIntentsExercise.this,PassingIntentsExercise2.class);
        intent.putExtra("fname_key",fName);
        intent.putExtra("lname_key",lName);
        intent.putExtra("gender_key",gender);
        intent.putExtra("marital_key",marital);
        intent.putExtra("pnum_key",pNumber);
        intent.putExtra("bdate_key",bDate);
        intent.putExtra("eadd_key",emailAdd);
        intent.putExtra("age_key",age);
        intent.putExtra("address_key",add);
        intent.putExtra("idNum_key",idNum);
        intent.putExtra("prog_key",prog);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
    }
}