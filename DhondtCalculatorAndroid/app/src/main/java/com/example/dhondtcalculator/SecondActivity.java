package com.example.dhondtcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    TextView firstPartyTextView;
    TextView secondPartyTextView;
    TextView thirdPartyTextView;
    TextView fourthPartyTextView;
    TextView fifthPartyTextView;
    TextView sixthPartyTextView;
    EditText numberOfMandatsEditText;
    Button nextButton;

    String firstNameOfParty;
    String secondNameOfParty;
    String thirdNameOfParty;
    String fourthNameOfParty;
    String fifthNameOfParty;
    String sixthNameOfParty;
    String numberOfAllMandats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findIdForComponents();

        Intent loadInfo = getIntent();
        firstNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("first");
        secondNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("second");
        thirdNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("third");
        fourthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fourth");
        fifthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fifth");
        sixthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("sixth");

        setTextOnPartyTextView();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

                numberOfAllMandats = numberOfMandatsEditText.getText().toString();

                intent.putExtra("first", firstNameOfParty);
                intent.putExtra("second", secondNameOfParty);
                intent.putExtra("third", thirdNameOfParty);
                intent.putExtra("fourth", fourthNameOfParty);
                intent.putExtra("fifth", fifthNameOfParty);
                intent.putExtra("sixth", sixthNameOfParty);
                intent.putExtra("mandats", numberOfAllMandats);

                startActivity(intent);
            }
        });
    }

    public void setTextOnPartyTextView(){
        firstPartyTextView.setText(firstNameOfParty);
        secondPartyTextView.setText(secondNameOfParty);
        thirdPartyTextView.setText(thirdNameOfParty);
        fourthPartyTextView.setText(fourthNameOfParty);
        fifthPartyTextView.setText(fifthNameOfParty);
        sixthPartyTextView.setText(sixthNameOfParty);
    }

    public void findIdForComponents(){
        firstPartyTextView = findViewById(R.id.firstPartyTextView);
        secondPartyTextView = findViewById(R.id.secondPartyTextView);
        thirdPartyTextView = findViewById(R.id.thirdPartyTextView);
        fourthPartyTextView = findViewById(R.id.fourthPartyTextView);
        fifthPartyTextView = findViewById(R.id.fifthPartyTextView);
        sixthPartyTextView = findViewById(R.id.sixthPartyTextView);
        numberOfMandatsEditText = findViewById(R.id.numberOfMandatsEditText);
        nextButton = findViewById(R.id.nextButton);
    }
}
