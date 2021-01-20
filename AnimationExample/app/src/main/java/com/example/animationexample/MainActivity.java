package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    Button next;
    LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        animationView = findViewById(R.id.animation);
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationView.setVisibility(View.VISIBLE);
                next.setVisibility(View.INVISIBLE);
                animationView.playAnimation();
                Thread thread = new Thread(){
                    public void run(){
                        try
                        {
                            sleep(1000);
                        }catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                        finally
                        {
                            Intent intent = new Intent(MainActivity.this, DetailAnimation.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };thread.start();
            }
        });


    }
}