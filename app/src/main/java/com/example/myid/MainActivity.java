package com.example.myid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaring our view variables
    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect our variables to our activity_main
        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        // set an onClickListener to our button
        tvResults.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = etID.getText().toString().trim();
                //date of birth


                String dob = idNumber.substring(0,6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                //male or female
                String myGender;
                if(gender < 5){
                    myGender = "Female";
                }else{
                    myGender = "Male";
                }
                //nationality
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String myNationality = "";
                if (nationality == 0){
                    myNationality = "SA citizen";
                } else if (nationality ==1) {
                    myNationality = "Permanent Resident";
                }
                String message = "Date of birth: " +dob+ "\n"+"Gender: " +myGender+ "\n"+"nationality: "+ myNationality;
                //render text
                tvResults.setText(message);
                tvResults.setVisibility(View.VISIBLE);
            }
        });

    }


}