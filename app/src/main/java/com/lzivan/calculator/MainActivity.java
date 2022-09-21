package com.lzivan.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText inputBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBox = findViewById(R.id.textView);
        inputBox.setShowSoftInputOnFocus(false);

        inputBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(inputBox.getText().toString())){
                    inputBox.setText("");
                }
            }
        });
    }

    private void updateInput(String newInput){
        String prevString = inputBox.getText().toString();
        int cursorPos = inputBox.getSelectionStart();
        String left = prevString.substring(0, cursorPos);
        String right = prevString.substring(cursorPos);
        if (getString(R.string.display).equals(inputBox.getText().toString())){
            inputBox.setText(newInput);
        } else{
            inputBox.setText(String.format("%s%s%s", left, newInput, right));
        }
        if (newInput.equals("sqrt()"))
            inputBox.setSelection(cursorPos + 5);
        else
            inputBox.setSelection(cursorPos + 1);

    }

    public void zeroBtn(View view){
        updateInput("0");
    }

    public void oneBtn(View view){
        updateInput("1");
    }

    public void twoBtn(View view){
        updateInput("2");
    }

    public void threeBtn(View view){
        updateInput("3");
    }

    public void fourBtn(View view){
        updateInput("4");
    }

    public void fiveBtn(View view){
        updateInput("5");
    }

    public void sixBtn(View view){
        updateInput("6");
    }

    public void sevenBtn(View view){
        updateInput("7");
    }

    public void eightBtn(View view){
        updateInput("8");
    }

    public void nineBtn(View view){
        updateInput("9");
    }

    public void pointBtn(View view){
        updateInput(".");
    }

    public void plusBtn(View view){
        updateInput("+");
    }

    public void minusBtn(View view){
        updateInput("-");
    }

    public void multiplyBtn(View view){
        updateInput("*");
    }

    public void divideBtn(View view){
        updateInput("/");
    }

    public void sqrtBtn(View view){
        updateInput("sqrt()");
    }

    public void equalBtn(View view){
        String expression = inputBox.getText().toString();
        Expression exp = new Expression(expression);
        String output = String.valueOf(exp.calculate());

        inputBox.setText(output);
        inputBox.setSelection(output.length());
    }

}