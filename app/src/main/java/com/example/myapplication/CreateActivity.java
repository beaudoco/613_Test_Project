package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateActivity extends AppCompatActivity {
    public static final String INVALID = "Invalid";
    public static final String SCALENE = "Scalene";
    public static final String ISOSELES = "Isoseles";
    public static final String EQUILATERAL = "Equilateral";
    int a;
    int b;
    int c;
    private Button calculateBtn;

    @BindView(R.id.length1)
    EditText length1;

    @BindView(R.id.length2)
    EditText length2;

    @BindView(R.id.length3)
    EditText length3;


    private void hideKeypad() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),0);
    }

    public void init() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        calculateBtn = (Button) findViewById(R.id.calculateBtn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(length1.getText().toString());
                b = Integer.parseInt(length2.getText().toString());
                c = Integer.parseInt(length3.getText().toString());
                TextView triangleView = findViewById(R.id.triangleTxt);
                triangleView.setText(triangle(a,b,c));
            }
        });

        init();
    }

    public String triangle(int a, int b, int c) {

        boolean isATriangle;

        // Is A Triangle?
        if((a < b + c) && (b < a + c) && (c < a + b))
            isATriangle = true;
        else
            isATriangle = false;

        // Determine Triangle Type
        String triangleType = INVALID;
        if(isATriangle) {
            if((a == b) && (b == c))
                triangleType = EQUILATERAL;
            else if((a != b) && (a != c) && (b != c))
                triangleType = SCALENE;
            else
                triangleType = ISOSELES;
        } else
            triangleType = INVALID;

        return triangleType;

    }
}
