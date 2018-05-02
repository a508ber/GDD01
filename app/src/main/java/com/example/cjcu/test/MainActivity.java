package com.example.cjcu.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText input_lend;
    private EditText input_rate;
    private EditText input_number;
    private TextView amount;
    private Button submit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponent();
        setListener();
    }
    public void setComponent(){
        input_lend=(EditText)this.findViewById(R.id.input_lend);
        input_rate=(EditText)this.findViewById(R.id.input_rate);
        input_number=(EditText)this.findViewById(R.id.input_number);
        amount=(TextView)this.findViewById(R.id.amount);
        submit=(Button)this.findViewById(R.id.submit);
    }
    public void setListener(){
        submit.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0) {
                DecimalFormat df=new DecimalFormat("0");
                double d_lend=Double.parseDouble(input_lend.getText().toString());
                double d_rate=Double.parseDouble(input_rate.getText().toString());
                double d_number=Double.parseDouble(input_number.getText().toString());
                double resault=d_lend*Math.pow((d_rate/12/100)+1, d_number);
                amount.setText("本利和為:"+df.format(resault));
            }
        });
    }
}
