package ru.plesser.materialdesign;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class StyleActivity extends AppCompatActivity {

    static final String TAG = "StyleActivity";
    static final String BASE_STYLE = "base_style";
    RadioGroup styleGroup;
    Button calculatorButton;
    Button intentButton;
    Button styleButton;

    String mode;

    int styleMode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        calculatorButton = findViewById(R.id.button_calculator);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MainActivity.newInstance(StyleActivity.this, mode));
            }
        });


        intentButton = findViewById(R.id.button_calculator_intent);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("ru.plesser.intent.action.calculator");
                startActivity(intent);
            }
        });
        mode = "day";

        styleGroup = findViewById(R.id.radiogroup_style);
        styleGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int radioButton) {
                Log.d(TAG, "style " + radioButton);
                switch (radioButton){
                    case R.id.radiobutton_day:
                        mode = "day";
                        break;
                    case R.id.radiobutton_night:
                        mode = "night";
                        break;
                    default:
                        mode = "day";
                }
            }
        });

        styleButton = findViewById(R.id.button_style);
        styleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("day".equals(mode)){
                    AppCompatDelegate
                            .setDefaultNightMode(
                                    AppCompatDelegate
                                            .MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate
                            .setDefaultNightMode(
                                    AppCompatDelegate
                                            .MODE_NIGHT_YES);
                }
            }
        });
    }

 }