package com.example.user.hw1210;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener
{
    int resultc;
    TextView p3n;
    Spinner spn2;
    String [] sport  = {"撿棍子","玩球"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        p3n=(TextView)findViewById(R.id.p3n);
        spn2 =(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> sportAd=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        sport);
        sportAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn2.setAdapter(sportAd);
        spn2.setOnItemSelectedListener(this);

        Intent itc = getIntent();
        Bundle bundlec = itc.getExtras();
        String namec = bundlec.getString("NAME");
        String p3n_str = "名稱:"+namec;
        p3n.setText(p3n_str);
    }

    public void threeBack_Main(View v){
        Intent itc2 = new Intent();
        Bundle bundlec2 = new Bundle();
        bundlec2.putInt("BACK",resultc);
        itc2.putExtras(bundlec2);
        setResult(RESULT_OK,itc2);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                resultc=5;
                break;
            case 1:
                resultc=6;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
