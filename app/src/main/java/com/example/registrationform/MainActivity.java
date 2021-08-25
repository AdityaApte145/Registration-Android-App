package com.example.registrationform;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    EditText nameText, ageText, emailText, phoneText;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submitButton);
        nameText = findViewById(R.id.nameText);
        ageText = findViewById(R.id.ageText);
        emailText = findViewById(R.id.emailText);
        phoneText = findViewById(R.id.phoneText);

        awesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);
        awesomeValidation.setColor(Color.RED);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awesomeValidation.addValidation(MainActivity.this, R.id.nameText, "[a-zA-Z\\s]+", R.string.nameError);
                awesomeValidation.addValidation(MainActivity.this, R.id.ageText, "^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$", R.string.ageError);
                awesomeValidation.addValidation(MainActivity.this, R.id.emailText, Patterns.EMAIL_ADDRESS, R.string.emailError);
                awesomeValidation.addValidation(MainActivity.this, R.id.phoneText,"^\\d{10}$", R.string.phoneError);

                if (awesomeValidation.validate()) {
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}