package ru.plesser.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "MainActivity";

    TextView displayTextview;

    Button zeroButton;

    Button oneButton;
    Button twoButton;
    Button threeButton;

    Button fourButton;
    Button fiveButton;
    Button sixButton;

    Button sevenButton;
    Button eightButton;
    Button nineButton;

    Button clearButton;
    Button plusminusButton;
    Button percentButton;
    Button backspaceButton;
    Button equalButton;

    Button multiButton;
    Button plusButton;
    Button divButton;
    Button minusButton;
    Button dotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextview = findViewById(R.id.display_textview);

        zeroButton = findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(this);

        oneButton = findViewById(R.id.one_button);
        oneButton.setOnClickListener(this);
        twoButton = findViewById(R.id.two_button);
        twoButton.setOnClickListener(this);
        threeButton = findViewById(R.id.three_button);
        threeButton.setOnClickListener(this);

        fourButton = findViewById(R.id.four_button);
        fourButton.setOnClickListener(this);
        fiveButton = findViewById(R.id.five_button);
        fiveButton.setOnClickListener(this);
        sixButton = findViewById(R.id.six_button);
        sixButton.setOnClickListener(this);

        sevenButton = findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(this);
        eightButton = findViewById(R.id.eight_button);
        eightButton.setOnClickListener(this);
        nineButton = findViewById(R.id.nine_button);
        nineButton.setOnClickListener(this);

        clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(this);
        plusminusButton = findViewById(R.id.plusminus_button);
        plusminusButton.setOnClickListener(this);
        percentButton = findViewById(R.id.percent_button);
        percentButton.setOnClickListener(this);
        backspaceButton = findViewById(R.id.backspace_button);
        backspaceButton.setOnClickListener(this);
        equalButton = findViewById(R.id.equal_button);
        equalButton.setOnClickListener(this);

        multiButton = findViewById(R.id.multi_button);
        multiButton.setOnClickListener(this);
        plusButton = findViewById(R.id.plus_button);
        plusButton.setOnClickListener(this);
        divButton = findViewById(R.id.div_button);
        divButton.setOnClickListener(this);

        minusButton = findViewById(R.id.minus_button);
        minusButton.setOnClickListener(this);

        dotButton = findViewById(R.id.dot_button);
        dotButton.setOnClickListener(this);

        displayTextview.setText("0");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.zero_button):
                Log.d(TAG, "key 0");
                break;
            case (R.id.one_button):
                Log.d(TAG, "key 1");
                addNumber(1);
                break;
            case (R.id.two_button):
                Log.d(TAG, "key 2");
                addNumber(2);
                break;
            case (R.id.three_button):
                Log.d(TAG, "key 3");
                addNumber(3);
                break;
            case (R.id.four_button):
                Log.d(TAG, "key 4");
                addNumber(4);
                break;
            case (R.id.five_button):
                Log.d(TAG, "key 5");
                addNumber(5);
                break;
            case (R.id.six_button):
                Log.d(TAG, "key 6");
                addNumber(6);
                break;
            case (R.id.seven_button):
                Log.d(TAG, "key 7");
                addNumber(7);
                break;
            case (R.id.eight_button):
                Log.d(TAG, "key 8");
                addNumber(8);
                break;
            case (R.id.nine_button):
                Log.d(TAG, "key 9");
                addNumber(9);
                break;
            case (R.id.plus_button):
                Log.d(TAG, "key +");
                break;
            case (R.id.minus_button):
                Log.d(TAG, "key -");
                break;
            case (R.id.multi_button):
                Log.d(TAG, "key *");
                break;
            case (R.id.div_button):
                Log.d(TAG, "key /");
                break;
            case (R.id.dot_button):
                Log.d(TAG, "key .");
                break;
            case (R.id.clear_button):
                Log.d(TAG, "key C");
                break;
            case (R.id.plusminus_button):
                Log.d(TAG, "key +/-");
                addOperator("+/-");
                break;
            case (R.id.percent_button):
                Log.d(TAG, "key %");
                break;
            case (R.id.backspace_button):
                Log.d(TAG, "key <-");
                break;
            case (R.id.equal_button):
                Log.d(TAG, "key =");
                break;
            default:
                Log.d(TAG, "WTF");
        }
    }

    private void addOperator(String operator) {
        String display = displayTextview.getText().toString();
        if ("0".equals(display)){
            return;
        }
        if ("+/-".equals(operator)){
            String sign = String.valueOf(display.charAt(0));
            if ("-".equals(sign)){
                displayTextview.setText(display.substring(1, display.length()));
            } else {
                displayTextview.setText("-"+display);
            }
        }
    }

    private void addNumber(int number) {
        String display = displayTextview.getText().toString();
        if ("0".equals(display)){
            displayTextview.setText(""+number);
        } else {
            displayTextview.setText(display + number);
        }
    }
}