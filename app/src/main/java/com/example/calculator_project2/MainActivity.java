package com.example.calculator_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView_Number;
    Boolean isNewOp= true;
    String oldnumber ="";
    String op = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_Number = findViewById(R.id.et_number);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            textView_Number.setText("");
        isNewOp=false;

        String number = textView_Number.getText().toString();
        switch (view.getId())
        {
            case R.id.btn_9: number+="9";
            break;
            case R.id.btn_8: number+="8";
                break;
            case R.id.btn_7: number+="7";
                break;
            case R.id.btn_6: number+="6";
                break;
            case R.id.btn_5: number+=5;
                break;
            case R.id.btn_4: number+="4";
                break;
            case R.id.btn_3: number+="3";
                break;
            case R.id.btn_2: number+="2";
                break;
            case R.id.btn_1: number+="1";
                break;
            case R.id.btn_0: number+="0";
                break;
            case R.id.btn_Dot: number+=".";
                break;
            case R.id.btn_PlusMinus: number = "-" + number;
                break;
        }
        textView_Number.setText(number);
    }
    public static String removeLastChar(String s) {
        return s.substring(0, s.length()-1) + s.substring(s.length()-1 + 1);
    }
    public void numberDelete(View view) {

        String number = textView_Number.getText().toString();
        if(number.length()==1)
        {
            number = "0";
            isNewOp = true;
        }
        else
            number = number.substring(0,number.length()-1);

        textView_Number.setText(number);
    }
    public void operatorEvent(View view) {
        isNewOp=true;
        oldnumber=textView_Number.getText().toString();
        switch (view.getId())
        {
            case R.id.btn_Plus:op ="+";
            break;
            case R.id.btn_Minus:op ="-";
                break;
            case R.id.btn_Divide:op ="/";
                break;
            case R.id.btn_Multiply:op ="x";
                break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = textView_Number.getText().toString();
        double result =0.0;
        switch(op)
        {
            case "+":
                result = Double.parseDouble(oldnumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldnumber) - Double.parseDouble(newNumber);
                break;
            case "x":
                result = Double.parseDouble(oldnumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldnumber) / Double.parseDouble(newNumber);
                break;
        }
        textView_Number.setText(result+"");
    }

    public void acEvent(View view) {
        textView_Number.setText("0");
        isNewOp=true;
    }
}