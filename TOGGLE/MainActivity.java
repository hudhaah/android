package com.example.toggle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView car1;
    private ImageView car2;
    private Button toggleButton;
    private boolean isImage1Visible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car1 = findViewById(R.id.image1);
        car2 = findViewById(R.id.image2);
        toggleButton = findViewById(R.id.toggleButton);

        // Set OnClickListener to the button to toggle images
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImage1Visible) {
                    car1.setVisibility(View.GONE);
                    car2.setVisibility(View.VISIBLE);
                } else {
                    car1.setVisibility(View.VISIBLE);
                    car2.setVisibility(View.GONE);
                }
                isImage1Visible = !isImage1Visible; // toggle the flag
            }
        });
    }
}