package com.example.dhondtcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class ThirdActivity extends AppCompatActivity {

    TextView firstPartyTextView;
    TextView secondPartyTextView;
    TextView thirdPartyTextView;
    TextView fourthPartyTextView;
    TextView fifthPartyTextView;
    TextView sixthPartyTextView;

    EditText numberOfVotesFirstEditText;
    EditText numberOfVotesSecondEditText;
    EditText numberOfVotesThirdEditText;
    EditText numberOfVotesFourthEditText;
    EditText numberOfVotesFifthEditText;
    EditText numberOfVotesSixthEditText;

    Button nextButton;

    String firstNameOfParty;
    String secondNameOfParty;
    String thirdNameOfParty;
    String fourthNameOfParty;
    String fifthNameOfParty;
    String sixthNameOfParty;

    String numberOfVotesFirstInteger = "0";
    String numberOfVotesSecondInteger = "0";
    String numberOfVotesThirdInteger = "0";
    String numberOfVotesFourthInteger = "0";
    String numberOfVotesFifthInteger = "0";
    String numberOfVotesSixthInteger = "0";
    String numberOfAllMandats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent loadInfo = getIntent();
        findIdForComponents();

        firstNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("first");
        secondNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("second");
        thirdNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("third");
        fourthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fourth");
        fifthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fifth");
        sixthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("sixth");
        numberOfAllMandats = Objects.requireNonNull(loadInfo.getExtras().getString("mandats"));

        setTextOnPartyTextView();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);

                numberOfVotesFirstInteger = numberOfVotesFirstEditText.getText().toString();
                numberOfVotesSecondInteger = numberOfVotesSecondEditText.getText().toString();
                numberOfVotesThirdInteger = numberOfVotesThirdEditText.getText().toString();
                numberOfVotesFourthInteger = numberOfVotesFourthEditText.getText().toString();
                numberOfVotesFifthInteger = numberOfVotesFifthEditText.getText().toString();
                numberOfVotesSixthInteger = numberOfVotesSixthEditText.getText().toString();

                intent.putExtra("firstInteger", numberOfVotesFirstInteger);
                intent.putExtra("secondInteger", numberOfVotesSecondInteger);
                intent.putExtra("thirdInteger", numberOfVotesThirdInteger);
                intent.putExtra("fourthInteger", numberOfVotesFourthInteger);
                intent.putExtra("fifthInteger", numberOfVotesFifthInteger);
                intent.putExtra("sixthInteger", numberOfVotesSixthInteger);

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

    public void setTextOnPartyTextView() {
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

        numberOfVotesFirstEditText = findViewById(R.id.firstPartyNumberOfVotes);
        numberOfVotesSecondEditText = findViewById(R.id.secondPartyNumberOfVotes);
        numberOfVotesThirdEditText = findViewById(R.id.thirdPartyNumberOfVotes);
        numberOfVotesFourthEditText = findViewById(R.id.fourthPartyNumberOfVotes);
        numberOfVotesFifthEditText = findViewById(R.id.fifthPartyNumberOfVotes);
        numberOfVotesSixthEditText = findViewById(R.id.sixthPartyNumberOfVotes);

        nextButton = findViewById(R.id.nextButton);

    }
}
