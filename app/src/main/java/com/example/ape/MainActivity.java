package com.example.ape;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_plus,btn_minus,btn_multiply,btn_divide,btn_clear,btn_equal;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn_plus = findViewById(R.id.button_plus);
        btn_minus = findViewById(R.id.button_minus);
        btn_multiply = findViewById(R.id.button_multiply);
        btn_divide = findViewById(R.id.button_divide);
        btn_clear=findViewById(R.id.clear);
        btn_equal=findViewById(R.id.button_equal);

        txt = findViewById(R.id.display);

        btn0.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "0"));
        });
        btn1.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "1"));
        });
        btn2.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "2"));
        });
        btn3.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "3"));
        });
        btn4.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "4"));
        });
        btn5.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "5"));
        });
        btn6.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "6"));
        });
        btn7.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "7"));
        });
        btn8.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "8"));
        });
        btn9.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "9"));
        });
        btn0.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "0"));
        });
        btn_plus.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "+"));
        });
        btn_minus.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "-"));
        });
        btn_multiply.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "*"));
        });
        btn_divide.setOnClickListener(view -> {
            txt.setText(String.format("%s%s", txt.getText(), "/"));
        });

        btn_clear.setOnClickListener(view -> {
            txt.setText("");
        });
        btn_equal.setOnClickListener(view->{
            String input = txt.getText().toString();
            txt.setText(eval(input));
        });


    }

        private String eval(String data) {
            try {
                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable = context.initStandardObjects();
                return context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            } catch (Exception e) {
                return "Error";
            }
        }
}
