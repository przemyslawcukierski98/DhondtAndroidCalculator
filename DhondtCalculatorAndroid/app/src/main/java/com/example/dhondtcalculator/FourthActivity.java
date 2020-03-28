package com.example.dhondtcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class FourthActivity extends AppCompatActivity {

    TextView firstPartyTextView;
    TextView secondPartyTextView;
    TextView thirdPartyTextView;
    TextView fourthPartyTextView;
    TextView fifthPartyTextView;
    TextView sixthPartyTextView;

    TextView numberOfMandatsFirstPartyTextView;
    TextView numberOfMandatsSecondPartyTextView;
    TextView numberOfMandatsThirdPartyTextView;
    TextView numberOfMandatsFourthPartyTextView;
    TextView numberOfMandatsFifthPartyTextView;
    TextView numberOfMandatsSixthPartyTextView;

    String firstNameOfParty;
    String secondNameOfParty;
    String thirdNameOfParty;
    String fourthNameOfParty;
    String fifthNameOfParty;
    String sixthNameOfParty;

    String numberOfVotesFirstParty;
    String numberOfVotesSecondParty;
    String numberOfVotesThirdParty;
    String numberOfVotesFourthParty;
    String numberOfVotesFifthParty;
    String numberOfVotesSixthParty;
    String numberOfAllMandats;

    int numberOFMandatsFirst = 0;
    int numberOfMandatsSecond = 0;
    int numberOfMandatsThird = 0;
    int numberOfMandatsFourth = 0;
    int numberOfMandatsFifth = 0;
    int numberOfMandatsSixth = 0;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent loadInfo = getIntent();
        findIdForComponents();

        firstNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("first");
        secondNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("second");
        thirdNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("third");
        fourthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fourth");
        fifthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fifth");
        sixthNameOfParty = Objects.requireNonNull(loadInfo.getExtras()).getString("sixth");

        numberOfVotesFirstParty = Objects.requireNonNull(loadInfo.getExtras()).getString("firstInteger");
        numberOfVotesSecondParty = Objects.requireNonNull(loadInfo.getExtras()).getString("secondInteger");
        numberOfVotesThirdParty = Objects.requireNonNull(loadInfo.getExtras()).getString("thirdInteger");
        numberOfVotesFourthParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fourthInteger");
        numberOfVotesFifthParty = Objects.requireNonNull(loadInfo.getExtras()).getString("fifthInteger");
        numberOfVotesSixthParty = Objects.requireNonNull(loadInfo.getExtras()).getString("sixthInteger");

        numberOfAllMandats = Objects.requireNonNull(loadInfo.getExtras().getString("mandats"));

        setTextOnPartyTextView();
        dhondtAlgorithm();
        setNumberOfMandats();

        // TODO
    }

    public void setTextOnPartyTextView() {
        firstPartyTextView.setText(firstNameOfParty);
        secondPartyTextView.setText(secondNameOfParty);
        thirdPartyTextView.setText(thirdNameOfParty);
        fourthPartyTextView.setText(fourthNameOfParty);
        fifthPartyTextView.setText(fifthNameOfParty);
        sixthPartyTextView.setText(sixthNameOfParty);
    }

    public void dhondtAlgorithm() {

        Integer firstVotes = Integer.valueOf(numberOfVotesFirstParty);
        Integer secondVotes = Integer.valueOf(numberOfVotesSecondParty);
        Integer thirdVotes = Integer.valueOf(numberOfVotesThirdParty);
        Integer fourthVotes = Integer.valueOf(numberOfVotesFourthParty);
        Integer fifthVotes = Integer.valueOf(numberOfVotesFifthParty);
        Integer sixthVotes = Integer.valueOf(numberOfVotesSixthParty);

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        List<Integer> thirdList = new ArrayList<>();
        List<Integer> fourthList = new ArrayList<>();
        List<Integer> fifthList = new ArrayList<>();
        List<Integer> sixthList = new ArrayList<>();

        Set<Integer> allList = new TreeSet<>();

        // add elements to separately list
        for (int i = 1; i < Integer.valueOf(numberOfAllMandats); i++) {
            firstList.add(firstVotes / i);
            secondList.add(secondVotes / i);
            thirdList.add(thirdVotes / i);
            fourthList.add(fourthVotes / i);
            fifthList.add(fifthVotes / i);
            sixthList.add(sixthVotes / i);
        }

        allList.addAll(firstList);
        allList.addAll(secondList);
        allList.addAll(thirdList);
        allList.addAll(fourthList);
        allList.addAll(fifthList);
        allList.addAll(sixthList);

        List<Integer> allListConverted = new ArrayList<>(allList);
        Collections.reverse(allListConverted);

        // find elements on all list
        for (int number = 0; number < allList.size(); number++) {
            if(counter<=Integer.valueOf(numberOfAllMandats)){
                if (firstList.contains(allListConverted.get(number))){
                    numberOFMandatsFirst++;
                    counter++;
                }
                if (secondList.contains(allListConverted.get(number))) {
                    numberOfMandatsSecond++;
                    counter++;
                }
                if (thirdList.contains(allListConverted.get(number))) {
                    numberOfMandatsThird++;
                    counter++;
                }
                if (fourthList.contains(allListConverted.get(number))) {
                    numberOfMandatsFourth++;
                    counter++;
                }
                if (fifthList.contains(allListConverted.get(number))) {
                    numberOfMandatsFifth++;
                    counter++;
                }
                if (sixthList.contains(allListConverted.get(number))) {
                    numberOfMandatsSixth++;
                    counter++;
                }
            }
        }
    }

    public void setNumberOfMandats(){
        numberOfMandatsFirstPartyTextView.setText(String.valueOf(numberOFMandatsFirst));
        numberOfMandatsSecondPartyTextView.setText(String.valueOf(numberOfMandatsSecond));
        numberOfMandatsThirdPartyTextView.setText(String.valueOf(numberOfMandatsThird));
        numberOfMandatsFourthPartyTextView.setText(String.valueOf(numberOfMandatsFourth));
        numberOfMandatsFifthPartyTextView.setText(String.valueOf(numberOfMandatsFifth));
        numberOfMandatsSixthPartyTextView.setText(String.valueOf(numberOfMandatsSixth));
    }

    public void findIdForComponents(){
        firstPartyTextView = findViewById(R.id.firstPartyTextView);
        secondPartyTextView = findViewById(R.id.secondPartyTextView);
        thirdPartyTextView = findViewById(R.id.thirdPartyTextView);
        fourthPartyTextView = findViewById(R.id.fourthPartyTextView);
        fifthPartyTextView = findViewById(R.id.fifthPartyTextView);
        sixthPartyTextView = findViewById(R.id.sixthPartyTextView);

        numberOfMandatsFirstPartyTextView = findViewById(R.id.numberOfMandatsFirst);
        numberOfMandatsSecondPartyTextView = findViewById(R.id.numberOfMandatsSecond);
        numberOfMandatsThirdPartyTextView = findViewById(R.id.numberOfMandatsThird);
        numberOfMandatsFourthPartyTextView = findViewById(R.id.numberOfMandatsFourth);
        numberOfMandatsFifthPartyTextView = findViewById(R.id.numberOfMandatsFifth);
        numberOfMandatsSixthPartyTextView = findViewById(R.id.numberOfMandatsSixth);
    }
}
