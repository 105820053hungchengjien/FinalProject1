package com.example.user.hw1210;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity
implements  View.OnClickListener {

    int choose;
    ImageView i1;
    ImageView i2;
    ImageView i3;
    ImageView i4;
    ImageView i5;
    ImageView i6;
    ImageView doggy;
    EditText name;
    int hp;
    int happyp;
    TextView hp_view;
    TextView happyp_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1 = (ImageView) findViewById(R.id.i1);
        i1.setOnClickListener(this);
        i2 = (ImageView) findViewById(R.id.i2);
        i2.setOnClickListener(this);
        i3 = (ImageView) findViewById(R.id.i3);
        i3.setOnClickListener(this);
        i4 = (ImageView) findViewById(R.id.i4);
        i4.setOnClickListener(this);
        i5 = (ImageView) findViewById(R.id.i5);
        i5.setOnClickListener(this);
        i6 = (ImageView) findViewById(R.id.i6);
        i6.setOnClickListener(this);
        doggy = (ImageView) findViewById(R.id.doggy);
        name = (EditText) findViewById(R.id.ch_name);
        hp_view = (TextView) findViewById(R.id.hp_view);
        happyp_view = (TextView) findViewById(R.id.happyp_view);
    }

    public void topage2b(View v) {
        Intent itb = new Intent(this
                , Main2Activity.class);
        String str1 = name.getText().toString();
        Bundle bundle1 = new Bundle();
        bundle1.putString("NAME", str1);
        itb.putExtras(bundle1);
        startActivityForResult(itb, 222);
    }

    public void topage3b(View v) {
        Intent itb = new Intent(this
                , Main3Activity.class);
        String str2 = name.getText().toString();
        Bundle bundle2 = new Bundle();
        bundle2.putString("NAME", str2);
        itb.putExtras(bundle2);
        startActivityForResult(itb, 333);
    }

    public void startRunning(View v1){
        new Thread(new keeprunning()).start();
    }

    public class keeprunning implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                    if (hp>0)
                        hp=hp-2;
                    if (happyp>0)
                        happyp=happyp-2;
                    hp_view.setText("hp:"+hp);
                    happyp_view.setText("happy:"+happyp);


                } catch (Exception e) {
                    hp=100;
                    happyp=100;
                }
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent it) {
        if (resultCode == RESULT_OK) {

            Bundle bundle = it.getExtras();
            choose = bundle.getInt("BACK");
            switch (choose) {
                case 1:
                    i1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    i2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    i3.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    i4.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    i5.setVisibility(View.VISIBLE);
                    break;
                case 6:
                    i6.setVisibility(View.VISIBLE);
                    break;


            }

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.i1:
                i1.setVisibility(View.GONE);
                hp=hp+5;
                if(hp>100)
                    hp=100;
                happyp=happyp+3;
                if(happyp>100)
                    happyp=100;
                hp_view.setText("hp:"+hp);
                happyp_view.setText("happy:"+happyp);
                break;
            case R.id.i2:
                i2.setVisibility(View.GONE);
                hp=hp+10;
                if(hp>100)
                    hp=100;
                happyp=happyp+6;
                if(happyp>100)
                    happyp=100;
                hp_view.setText("hp:"+hp);
                happyp_view.setText("happy:"+happyp);
                break;
            case R.id.i3:
                i3.setVisibility(View.GONE);
                hp=hp+15;
                if(hp>100)
                    hp=100;
                happyp=happyp+9;
                if(happyp>100)
                    happyp=100;
                hp_view.setText("hp:"+hp);
                happyp_view.setText("happy:"+happyp);
                break;
            case R.id.i4:
                i4.setVisibility(View.GONE);
                hp=hp+20;
                if(hp>100)
                    hp=100;
                happyp=happyp+12;
                if(happyp>100)
                    happyp=100;
                hp_view.setText("hp:"+hp);
                happyp_view.setText("happy:"+happyp);
                break;
            case R.id.i5:
                i5.setVisibility(View.GONE);
                hp=hp-5;
                if(hp<0)
                    hp=0;
                happyp=happyp+20;
                if(happyp>100)
                    happyp=100;
                hp_view.setText("hp:"+hp);
                happyp_view.setText("happy:"+happyp);
                break;
            case R.id.i6:
                i6.setVisibility(View.GONE);
                hp=hp-10;
                if(hp<0)
                    hp=0;
                happyp=happyp+40;
                if(happyp>100)
                    happyp=100;
                hp_view.setText("hp:"+hp);
                happyp_view.setText("happy:"+happyp);
                break;
        }
    }

}

