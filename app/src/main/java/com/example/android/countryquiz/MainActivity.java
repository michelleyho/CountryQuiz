package com.example.android.countryquiz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView question1_header = (TextView) findViewById(R.id.question_1);
        question1_header.setText("Question 1");

        TextView question2_header = (TextView) findViewById(R.id.question_2);
        question2_header.setText("Question 2");

        TextView question3_header = (TextView) findViewById(R.id.question_3);
        question3_header.setText("Question 3");

        TextView question4_header = (TextView) findViewById(R.id.question_4);
        question4_header.setText("Question 4");


        RadioButton flag_country_1 = (RadioButton) findViewById(R.id.flag_country_1);
        flag_country_1.setText(getString(R.string.flag_country_1));
        RadioButton flag_country_2 = (RadioButton) findViewById(R.id.flag_country_2);
        flag_country_2.setText(getString(R.string.flag_country_2));
        RadioButton flag_country_3 = (RadioButton) findViewById(R.id.flag_country_3);
        flag_country_3.setText(getString(R.string.flag_country_3));
        RadioButton flag_country_4 = (RadioButton) findViewById(R.id.flag_country_4);
        flag_country_4.setText(getString(R.string.flag_country_4));

        RadioButton capital_1 = (RadioButton) findViewById(R.id.capital_1);
        capital_1.setText(getString(R.string.capital1));
        RadioButton capital_2 = (RadioButton) findViewById(R.id.capital_2);
        capital_2.setText(getString(R.string.capital2));
        RadioButton capital_3 = (RadioButton) findViewById(R.id.capital_3);
        capital_3.setText(getString(R.string.capital3));
        RadioButton capital_4 = (RadioButton) findViewById(R.id.capital_4);
        capital_4.setText(getString(R.string.capital4));


        CheckBox city_1 = (CheckBox) findViewById(R.id.city_1);
        city_1.setText(getString(R.string.city1));
        CheckBox city_2 = (CheckBox) findViewById(R.id.city_2);
        city_2.setText(getString(R.string.city2));
        CheckBox city_3 = (CheckBox) findViewById(R.id.city_3);
        city_3.setText(getString(R.string.city3));
        CheckBox city_4 = (CheckBox) findViewById(R.id.city_4);
        city_4.setText(getString(R.string.city4));


        ImageView country_flag = findViewById(R.id.country_flag);
        country_flag.setImageResource(R.drawable.portuguese_flag_small);
    }


    public void resetResponses(View view){
        RadioGroup flag_countries = (RadioGroup) findViewById(R.id.flag_countries);
        flag_countries.clearCheck();

        RadioGroup capitals = (RadioGroup) findViewById(R.id.capitals);
        capitals.clearCheck();

        CheckBox city_1 = (CheckBox) findViewById(R.id.city_1);
        city_1.setChecked(false);
        CheckBox city_2 = (CheckBox) findViewById(R.id.city_2);
        city_2.setChecked(false);
        CheckBox city_3 = (CheckBox) findViewById(R.id.city_3);
        city_3.setChecked(false);
        CheckBox city_4 = (CheckBox) findViewById(R.id.city_4);
        city_4.setChecked(false);

        EditText currency = (EditText) findViewById(R.id.currency_input);
        currency.setText(null);

    }

    public void submitAnswers(View view){
        //Answer 1:
        RadioButton country_1 = (RadioButton) findViewById(R.id.flag_country_1);
        RadioButton country_2 = (RadioButton) findViewById(R.id.flag_country_2);
        RadioButton country_3 = (RadioButton) findViewById(R.id.flag_country_3);
        RadioButton country_4 = (RadioButton) findViewById(R.id.flag_country_4);

        //Answer 2:
        RadioButton capital_1 = (RadioButton) findViewById(R.id.capital_1);
        RadioButton capital_2 = (RadioButton) findViewById(R.id.capital_2);
        RadioButton capital_3 = (RadioButton) findViewById(R.id.capital_3);
        RadioButton capital_4 = (RadioButton) findViewById(R.id.capital_4);

        //Answer 3:
        CheckBox city_1 = (CheckBox) findViewById(R.id.city_1);
        CheckBox city_2 = (CheckBox) findViewById(R.id.city_2);
        CheckBox city_3 = (CheckBox) findViewById(R.id.city_3);
        CheckBox city_4 = (CheckBox) findViewById(R.id.city_4);

        //Answer 4:
        EditText currency = (EditText) findViewById(R.id.currency_input);

        int score_1 = checkMultipleChoice(getString(R.string.correct1), country_1, country_2, country_3, country_4);
        int score_2 = checkMultipleChoice(getString(R.string.correct2), capital_1, capital_2, capital_3, capital_4);
        int score_3 = checkBoxes(city_1, city_2, city_3, city_4);
        int score_4 = checkFreeAnswer(getString(R.string.correct4), currency.getText().toString());
        totalScore = score_1 + score_2 + score_3 + score_4;

        //Log.d("MainActivity", "TotalScore is:" + totalScore);
        displayScore();
    }

    private int checkMultipleChoice(String correctAnswer, RadioButton answer1, RadioButton answer2, RadioButton answer3, RadioButton answer4){
        int score = 0;

        if (answer1.isChecked()){
            score = (answer1.getText().toString().equals(correctAnswer)) ? 1 : 0 ;
        }
        else if (answer2.isChecked()){
            score = (answer2.getText().toString().equals(correctAnswer)) ? 1 : 0 ;
        }
        else if (answer3.isChecked()){
            score = (answer3.getText().toString().equals(correctAnswer)) ? 1 : 0 ;
        }
        else if (answer4.isChecked()){
            score = (answer4.getText().toString().equals(correctAnswer)) ? 1 : 0 ;
        }


        return score;
    }

    private int checkBoxes(CheckBox answer1, CheckBox answer2, CheckBox answer3, CheckBox answer4){
        int score = 0;
        String correctAnswer1 = getString(R.string.correct3a);
        String correctAnswer2 = getString(R.string.correct3b);

        if (answer1.isChecked()){
            String answerText = answer1.getText().toString();
            if ((answerText.equals(correctAnswer1)) || (answerText.equals(correctAnswer2))){
                score += 1;
            }
        }
        if (answer2.isChecked()){
            String answerText = answer2.getText().toString();
            if ((answerText.equals(correctAnswer1)) || (answerText.equals(correctAnswer2))){
                score += 1;
            }
        }
        if (answer3.isChecked()){
            String answerText = answer3.getText().toString();
            if ((answerText.equals(correctAnswer1)) || (answerText.equals(correctAnswer2))){
                score += 1;
            }
        }
        if (answer4.isChecked()){
            String answerText = answer4.getText().toString();
            if ((answerText.equals(correctAnswer1)) || (answerText.equals(correctAnswer2))){
                score += 1;
            }
        }

        return score;
    }

    private int checkFreeAnswer(String correctAnswer, String answer){
        Log.d("MainActivity", "Correct answer is:" + correctAnswer);
        Log.d("MainActivity", "Written answer is:" + answer);
        int score = 0;
        if (correctAnswer.equals(answer)){
            Log.d("MainActivity", "Inside loop:" + answer);
            score = 1;
        }
        String scoreMessage = "Free Answer score is : " + score;
        String answerMessage = "Written answer is: " + answer;

        Toast toast = Toast.makeText(getApplicationContext(), scoreMessage,
                Toast.LENGTH_SHORT);
        toast.show();

        toast = Toast.makeText(getApplicationContext(), answerMessage,
                Toast.LENGTH_SHORT);
        toast.show();

        return score;

    }

    private void displayScore() {
        String scoreMessage = "Final score: " + totalScore;
        Toast toast = Toast.makeText(getApplicationContext(), scoreMessage,
                Toast.LENGTH_SHORT);
        toast.show();

        TextView scoreView = (TextView) findViewById(R.id.final_score);
        scoreView.setText(scoreMessage);

    }

}