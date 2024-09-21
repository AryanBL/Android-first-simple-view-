package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    final int ALBORZ_ID = R.id.radio_button_alborz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Other code...
        Button saveInfoButton = findViewById(R.id.btn_main_save_info);
        saveInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Info saved", Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox androidCheckBox = findViewById(R.id.checkBox_Android);
        androidCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(MainActivity.this, "Android is checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Android is unchecked", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox uiCheckBox = findViewById(R.id.checkBox_main_Ui);
        uiCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(MainActivity.this, "UI is checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "UI is unchecked", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox deepCheckBox = findViewById(R.id.checkBox_main_deep_learning);
        deepCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(MainActivity.this, "deep learning is checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "deep learning is unchecked", Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == ALBORZ_ID) {
                    Toast.makeText(MainActivity.this, "Alborz Karaj is selected", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.radio_button_gilan){
                    Toast.makeText(MainActivity.this, "Gilan Rasht is selected", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.radio_button_tehran){
                    Toast.makeText(MainActivity.this, "Tehran is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button editProfileButton = findViewById(R.id.btn_editProfile);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
                startActivityForResult(intent,100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null){
            String fullName = data.getStringExtra("fullName");
            TextView textView = findViewById(R.id.tv_main_fullname);
            textView.setText(fullName);
        }
    }
}