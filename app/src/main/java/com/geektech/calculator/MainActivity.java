package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Integer first, second;
    private Boolean isOperationClick;
    private operation operation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
    }



    public void oneNumberClick(View view) {

        switch (view.getId()){
            case R.id.Bottom_0:
                setNumber("0");
                break;
            case R.id.Bottom_1:
                setNumber("1");
                break;
            case R.id.Bottom_2:
                setNumber("2");
                break;
            case R.id.Bottom_3:
                setNumber("3");
                break;
            case R.id.Bottom_4:
                setNumber("4");
                break;
            case R.id.Bottom_5:
                setNumber("5");
                break;
            case R.id.Bottom_6:
                setNumber("6");
                break;
            case R.id.Bottom_7:
                setNumber("7");
                break;
            case R.id.Bottom_8:
                setNumber("8");
                break;
            case R.id.Bottom_9:
                setNumber("9");
                break;
        }
        isOperationClick = false;
    }
    public void setNumber(String number){
        if(tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        }else if(isOperationClick){
            tvResult.setText(number);
        }else {
            tvResult.append(number);
        }

    }


    public void oneOperationClick(View view) {
        switch (view.getId()){

            case R.id.Bottom_clear:
                first = 0;
                second = 0;
                tvResult.setText("0");
                break;
            case R.id.Bottom_minus:
                first = Integer.parseInt(tvResult.getText().toString());
                operation = com.geektech.calculator.operation.MINUS;
                break;
            case R.id.Bottom_division:
                first = Integer.parseInt(tvResult.getText().toString());
                operation = com.geektech.calculator.operation.DIVISION;
                break;
            case R.id.Bottom_multiplication:
                first = Integer.parseInt(tvResult.getText().toString());
                operation = com.geektech.calculator.operation.MULTIPLICATION;
                break;
            case R.id.Bottom_plus:
                first = Integer.parseInt(tvResult.getText().toString());
                operation = com.geektech.calculator.operation.PLUS;
                break;

            case R.id.Bottom_equais:
second = Integer.parseInt(tvResult.getText().toString());
Integer resault = executeOperation();
tvResult.setText(resault.toString());
                break;

        }
        isOperationClick = true;
    }

    private Integer executeOperation() {
        switch (operation){
            case PERCENT:
                return ((first) / (second))* 100;
            case MULTIPLICATION:
                return first * second;
            case PLUS:
                return first + second;
            case DIVISION:
                return first / second;
            case MINUS:
                return first - second;
            default: return 0;
        }
    }
}
