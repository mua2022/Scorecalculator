package com.example.scorecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Link UI components
        TextView  HeaderTitle= findViewById(R.id.Header_title);
        TextView txtMaths = findViewById(R.id.TxtMaths);
        EditText subject1 = findViewById(R.id.Subject1);
        TextView txtEng = findViewById(R.id.TxtEng);
        EditText subject2 = findViewById(R.id.Subject2);
        TextView txtArt = findViewById(R.id.TxtArt);
        EditText subject3 = findViewById(R.id.Subject3);
        TextView txtSoc = findViewById(R.id.TxtSoc);
        EditText subject4 = findViewById(R.id.Subject4);
        TextView txtComp = findViewById(R.id.TxtComp);
        EditText subject5 = findViewById(R.id.Subject5);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView resultView = findViewById(R.id.resultView);

        // Set button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Get scores from input fields
                    int score1 = Integer.parseInt(subject1.getText().toString());
                    int score2 = Integer.parseInt(subject2.getText().toString());
                    int score3 = Integer.parseInt(subject3.getText().toString());
                    int score4 = Integer.parseInt(subject4.getText().toString());
                    int score5 = Integer.parseInt(subject5.getText().toString());

                    // Calculate total and mean
                    int total = score1 + score2 + score3 + score4 + score5;
                    double mean = total / 5.0;

                    // Determine grade
                    String grade;
                    if (mean > 80) {
                        grade = "A";
                    } else if (mean >= 69) {
                        grade = "B";
                    } else if (mean > 49) {
                        grade = "C";
                    } else if (mean > 39) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }

                    // Display results
                    String result = "Total: " + total + "\nMean: " + mean + "\nGrade: " + grade;
                    resultView.setText(result);

                } catch (NumberFormatException e) {
                    // Handle invalid input
                    resultView.setText("Please enter valid numbers for all subjects.");
                }
            }
        });
    }
}
