package com.jay_puzon.kickscalculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView FNum, SNum, Result;
    Button ClearButton;
    double fnum = 0, snum = 0, result = 0;

    void operation(int oper) {
        if (fnum == 0) {
            FNum.setError("Empty!");
            return;
        }
        if (snum == 0) {
            SNum.setError("Empty!");
            return;
        }

        FNum.setError(null);
        SNum.setError(null);

        switch (oper) {
            case 0: {
                result = fnum + snum;
                Result.setText(String.valueOf(result));
            }
            ;
            break;
            case 1: {
                result = fnum - snum;
                Result.setText(String.valueOf(result));
            }
            ;
            break;
            case 2: {
                result = fnum * snum;
                Result.setText(String.valueOf(result));
            }
            ;
            break;
            case 3: {
                result = fnum / snum;
                Result.setText(String.valueOf(result));
            }
            ;
            break;
            case 4: {
                result = fnum % snum;
                Result.setText(String.valueOf(result));
            }
        }
    }

    void clear() {
        fnum = 0;
        FNum.setText("0");
        snum = 0;
        SNum.setText("0");
        result = 0;
        Result.setText("0");
        FNum.requestFocus();
        FNum.setError(null);
        SNum.setError(null);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Result = findViewById(R.id.result);
        FNum = findViewById(R.id.fnum);
        SNum = findViewById(R.id.snum);

        Button[] Buttons = new Button[] {
                findViewById(R.id.add),
                findViewById(R.id.subtract),
                findViewById(R.id.multiply),
                findViewById(R.id.divide),
                findViewById(R.id.modulo),
        };

        for (int i = 0; i < Buttons.length; i++) {
            int finalI = i;
            Buttons[finalI].setOnClickListener(view -> operation(finalI));
        }

        FNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    fnum = Double.valueOf(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        SNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    snum = Double.valueOf(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ClearButton = findViewById(R.id.clear);
        ClearButton.setOnClickListener(view -> clear());
    }
}