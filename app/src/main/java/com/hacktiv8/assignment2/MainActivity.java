package com.hacktiv8.assignment2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.TagLostException;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView scoreTV;
    Button buttonCount;
    EditText nameET;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTV = findViewById(R.id.score_tv);
        buttonCount = findViewById(R.id.button_count);
        nameET = findViewById(R.id.name_et);

        buttonCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String currentScore = scoreTV.getText().toString();
        int currentScoreInt = Integer.valueOf(currentScore);

        score = currentScoreInt + 1;
        scoreTV.setText(String.valueOf(score));

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", String.valueOf(scoreTV.getText()));
    }

    @Override
    public void onRestoreInstanceState(Bundle mySavedState) {
        super.onRestoreInstanceState(mySavedState);
        if (mySavedState != null){
            String count = mySavedState.getString("count");
            if(count != null) scoreTV.setText(count);
        }

    }
}