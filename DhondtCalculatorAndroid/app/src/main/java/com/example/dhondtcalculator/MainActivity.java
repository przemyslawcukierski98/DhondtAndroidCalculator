package com.example.dhondtcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button nextButton;
    EditText firstParty;
    EditText secondParty;
    EditText thirdParty;
    EditText fourthParty;
    EditText fifthParty;
    EditText sixthParty;

    String firstPartyName;
    String secondPartyName;
    String thirdPartyName;
    String fourthPartyName;
    String fifthPartyName;
    String sixthPartyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.nextButton);
        firstParty = findViewById(R.id.firstParty);
        secondParty = findViewById(R.id.secondParty);
        thirdParty = findViewById(R.id.thirdParty);
        fourthParty = findViewById(R.id.fourthParty);
        fifthParty = findViewById(R.id.fifthParty);
        sixthParty = findViewById(R.id.sixthParty);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                firstPartyName = firstParty.getText().toString();
                secondPartyName = secondParty.getText().toString();
                thirdPartyName = thirdParty.getText().toString();
                fourthPartyName = fourthParty.getText().toString();
                fifthPartyName = fifthParty.getText().toString();
                sixthPartyName = sixthParty.getText().toString();

                intent.putExtra("first", firstPartyName);
                intent.putExtra("second", secondPartyName);
                intent.putExtra("third", thirdPartyName);
                intent.putExtra("fourth", fourthPartyName);
                intent.putExtra("fifth", fifthPartyName);
                intent.putExtra("sixth", sixthPartyName);

                startActivity(intent);
            }
        });
    }
}
