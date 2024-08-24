package com.example.validation; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText passwordEditText;
    private RadioGroup genderRadioGroup;
    private Switch newMemberSwitch;
    private CheckBox termsCheckBox;
    private Button cancelButton;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        passwordEditText = findViewById(R.id.password);
        genderRadioGroup = findViewById(R.id.genderGroup);
        newMemberSwitch = findViewById(R.id.switch1);
        termsCheckBox = findViewById(R.id.checkBox);
        cancelButton = findViewById(R.id.cancelButton);
        proceedButton = findViewById(R.id.proceedButton);


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cancel button click
                Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle proceed button click
                handleProceedButtonClick();
            }
        });
    }

    private void handleProceedButtonClick() {
        // Get input values
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
        String gender = selectedGenderRadioButton != null ? selectedGenderRadioButton.getText().toString() : "Not selected";

        boolean isNewMember = newMemberSwitch.isChecked();
        boolean isTermsAccepted = termsCheckBox.isChecked();


        if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidPassword(password)) {
            Toast.makeText(this, "Password must be at least 8 characters long and contain a mix of letters and numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isTermsAccepted) {
            Toast.makeText(this, "You must agree to terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent intent = new Intent(MainActivity.this, MainActivity2.class);


        String message = String.format("First Name: %s\nLast Name: %s\nPassword: %s\nGender: %s\nNew Member: %s\nTerms Accepted: %s",
                firstName, lastName, password, gender, isNewMember, isTermsAccepted);
        intent.putExtra("user_data", message);


        startActivity(intent);
    }


    private boolean isValidPassword(String password) {

        return password.length() >= 8 ;
    }
}