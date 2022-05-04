package ru.plesser.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "MainActivity";
    private final static String DATA = "Calculator";

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

    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            calculator = new Calculator();
        } else {
            calculator = (Calculator) savedInstanceState.getSerializable("DATA");
        }

        displayTextview = findViewById(R.id.textview_display);

        zeroButton = findViewById(R.id.button_zero);
        zeroButton.setOnClickListener(this);

        oneButton = findViewById(R.id.button_one);
        oneButton.setOnClickListener(this);
        twoButton = findViewById(R.id.button_two);
        twoButton.setOnClickListener(this);
        threeButton = findViewById(R.id.button_three);
        threeButton.setOnClickListener(this);

        fourButton = findViewById(R.id.button_four);
        fourButton.setOnClickListener(this);
        fiveButton = findViewById(R.id.button_five);
        fiveButton.setOnClickListener(this);
        sixButton = findViewById(R.id.button_six);
        sixButton.setOnClickListener(this);

        sevenButton = findViewById(R.id.button_seven);
        sevenButton.setOnClickListener(this);
        eightButton = findViewById(R.id.button_eight);
        eightButton.setOnClickListener(this);
        nineButton = findViewById(R.id.button_nine);
        nineButton.setOnClickListener(this);

        clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(this);
        plusminusButton = findViewById(R.id.button_plusminus);
        plusminusButton.setOnClickListener(this);
        percentButton = findViewById(R.id.button_percent);
        percentButton.setOnClickListener(this);
        backspaceButton = findViewById(R.id.button_backspace);
        backspaceButton.setOnClickListener(this);
        equalButton = findViewById(R.id.button_equal);
        equalButton.setOnClickListener(this);

        multiButton = findViewById(R.id.button_multi);
        multiButton.setOnClickListener(this);
        plusButton = findViewById(R.id.button_plus);
        plusButton.setOnClickListener(this);
        divButton = findViewById(R.id.button_div);
        divButton.setOnClickListener(this);

        minusButton = findViewById(R.id.button_minus);
        minusButton.setOnClickListener(this);

        dotButton = findViewById(R.id.button_dot);
        dotButton.setOnClickListener(this);

        displayTextview.setText("0");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.button_zero):
                Log.d(TAG, "key 0");
                break;
            case (R.id.button_one):
                Log.d(TAG, "key 1");
                addNumber(1);
                break;
            case (R.id.button_two):
                Log.d(TAG, "key 2");
                addNumber(2);
                break;
            case (R.id.button_three):
                Log.d(TAG, "key 3");
                addNumber(3);
                break;
            case (R.id.button_four):
                Log.d(TAG, "key 4");
                addNumber(4);
                break;
            case (R.id.button_five):
                Log.d(TAG, "key 5");
                addNumber(5);
                break;
            case (R.id.button_six):
                Log.d(TAG, "key 6");
                addNumber(6);
                break;
            case (R.id.button_seven):
                Log.d(TAG, "key 7");
                addNumber(7);
                break;
            case (R.id.button_eight):
                Log.d(TAG, "key 8");
                addNumber(8);
                break;
            case (R.id.button_nine):
                Log.d(TAG, "key 9");
                addNumber(9);
                break;
            case (R.id.button_plus):
                Log.d(TAG, "key +");
                break;
            case (R.id.button_minus):
                Log.d(TAG, "key -");
                break;
            case (R.id.button_multi):
                Log.d(TAG, "key *");
                break;
            case (R.id.button_div):
                Log.d(TAG, "key /");
                break;
            case (R.id.button_dot):
                Log.d(TAG, "key .");
                addOperator("dot");
                break;
            case (R.id.button_clear):
                Log.d(TAG, "key C");
                addOperator("clear");
                break;
            case (R.id.button_plusminus):
                Log.d(TAG, "key +/-");
                addOperator("+/-");
                break;
            case (R.id.button_percent):
                Log.d(TAG, "key %");
                break;
            case (R.id.button_backspace):
                Log.d(TAG, "key <-");
                break;
            case (R.id.button_equal):
                Log.d(TAG, "key =");
                break;
            default:
                Log.d(TAG, "WTF");
        }
    }

    private void addOperator(String operator) {
        Log.d(TAG, "operator is <" + operator + ">");

        String display = displayTextview.getText().toString();

        if ("0".equals(display) && !"dot".equals(operator)){
            Log.d(TAG, "display is 0, return");
            return;
        } else if ("+/-".equals(operator)){
            Log.d(TAG, "operator +/-");
            String sign = String.valueOf(display.charAt(0));
            if ("-".equals(sign)){
                displayTextview.setText(display.substring(1, display.length()));
            } else {
                displayTextview.setText("-"+display);
            }
        } else if ("dot".equals(operator) && display.indexOf(".") == -1){
            Log.d(TAG, display+"." + " ");

            displayTextview.setText(display+".");
        } else if ("clear".equals(operator)){
            Log.d(TAG, "operator is " + operator );
            displayTextview.setText("0");
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(DATA, calculator);
    }
}