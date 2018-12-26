package com.example.user.hw1210;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener
{
    int resultb;
    TextView p2n;
    Spinner spn;
    String [] food  = {"蘋果","香蕉","橘子","西瓜"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        p2n=(TextView)findViewById(R.id.p2n);
        spn =(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> foodAd=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        food);
        foodAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(foodAd);
        spn.setOnItemSelectedListener(this);

        Intent itb = getIntent();
        Bundle bundleb = itb.getExtras();
        String nameb = bundleb.getString("NAME");
        String p2n_str = "名稱:"+nameb;
        p2n.setText(p2n_str);




}

    public void twoBack_Main(View v){
        Intent itb2 = new Intent();
        Bundle bundleb2 = new Bundle();
        bundleb2.putInt("BACK",resultb);
        itb2.putExtras(bundleb2);
        setResult(RESULT_OK,itb2);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0:
                resultb=1;
                break;
            case 1:
                resultb=2;
                break;
            case 2:
                resultb=3;
                break;
            case 3:
                resultb=4;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
