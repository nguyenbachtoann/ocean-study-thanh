package hci201.se1171.oceanstudy;

import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{
    private int screenHeight;
    private int screenWidth;


    private ImageView fish_home_1;
    private ImageView fish_home_2;
    private ImageView fish_home_3;


    private ImageView bubble1;
    private ImageView bubble2;
    private ImageView bubble3;
    private ImageView bubble4;


    private float fish_home_1_X;
    private float fish_home_1_Y;
    private float fish_home_2_X;
    private float fish_home_2_Y;
    private float fish_home_3_X;
    private float fish_home_3_Y;


    private float bubble1_X;
    private float bubble1_Y;
    private float bubble2_X;
    private float bubble2_Y;
    private float bubble3_X;
    private float bubble3_Y;
    private float bubble4_X;
    private float bubble4_Y;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fish_home_1 = findViewById(R.id.fish_home_1);
        fish_home_2 =  findViewById(R.id.fish_home_2);
        fish_home_3 = findViewById(R.id.fish_home_3);

        bubble1 = findViewById(R.id.bubble1);
        bubble2 = findViewById(R.id.bubble2);
        bubble3 = findViewById(R.id.bubble3);
        bubble4 = findViewById(R.id.bubble4);

        //Animation for bubble and fish
        TranslateAnimation translateXAnimation = new TranslateAnimation(0f, 20f, 0f, 0f);
        translateXAnimation.setDuration(1000);
        translateXAnimation.setRepeatCount(Animation.INFINITE);
        translateXAnimation.setRepeatMode(Animation.REVERSE);
        bubble1.setAnimation(translateXAnimation);
        bubble2.setAnimation(translateXAnimation);
        bubble3.setAnimation(translateXAnimation);
        bubble4.setAnimation(translateXAnimation);

        TranslateAnimation translateYAnimation = new TranslateAnimation(0f, 0f, 0f, -15f);
        translateYAnimation.setDuration(1000);
        translateYAnimation.setRepeatCount(Animation.INFINITE);
        translateYAnimation.setRepeatMode(Animation.REVERSE);
        fish_home_1.setAnimation(translateYAnimation);
        fish_home_2.setAnimation(translateYAnimation);
        fish_home_3.setAnimation(translateYAnimation);



        //get screen size
        WindowManager wm = getWindowManager();
        Display dp = wm.getDefaultDisplay();
        Point size = new Point();
        dp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        // move out of the screen
        fish_home_1.setX(-80.0f);
        fish_home_1.setY(-80.0f);
        fish_home_2.setX(screenWidth + 80.0f);
        fish_home_2.setY(-80.0f);
        fish_home_3.setX(screenWidth + 80.0f);
        fish_home_3.setY(-80.0f);



        bubble1.setX(-80.0f);
        bubble1.setY(-80.0f);
        bubble2.setX(-80.0f);
        bubble2.setY(-80.0f);
        bubble3.setX(-80.0f);
        bubble3.setY(-80.0f);
        bubble4.setX(-80.0f);
        bubble4.setY(-80.0f);



        // Start timer

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
//                        changePostFish();
//                        changePostBubble();

                    }
                });
            }
        },0,20);
    }

    public void changeToStart(View view){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void changePostFish(){

//        fish_home_1_Y -= 7;
//        if (fish_home_1.getY() + fish_home_1.getHeight() < 0){
//            fish_home_1_X = (float)Math.floor(Math.random() * (screenWidth - fish_home_1.getWidth()));
//            fish_home_1_Y = screenHeight + 100.0f;
//        }
//        fish_home_1.setX(fish_home_1_X);
//        fish_home_1.setY(fish_home_1_Y);


        fish_home_1_X -= 5;
        if (fish_home_1.getX() + fish_home_1.getWidth() < 0){
            fish_home_1_Y = (float)Math.floor(Math.random() * (screenHeight - fish_home_1.getHeight()));
            fish_home_1_X = screenWidth + 100.0f;
        }
        fish_home_1.setX(fish_home_1_X);
        fish_home_1.setY(fish_home_1_Y);

        fish_home_2_X += 5;
        if (fish_home_2.getX() > screenWidth){
            fish_home_2_X = -100.0f;
            fish_home_2_Y = (float)Math.floor(Math.random() * (screenHeight - fish_home_2.getHeight()));

        }
        fish_home_2.setX(fish_home_2_X);
        fish_home_2.setY(fish_home_2_Y);


        fish_home_3_X += 8;
        if (fish_home_3.getX() > screenWidth){
            fish_home_3_X = -100.0f;
            fish_home_3_Y = (float)Math.floor(Math.random() * (screenHeight - fish_home_3.getHeight()));

        }
        fish_home_3.setX(fish_home_3_X);
        fish_home_3.setY(fish_home_3_Y);



    }


    public void changePostBubble(){

        bubble1_Y -= 10;
        if (bubble1.getY() + bubble1.getHeight() < 0){
            bubble1_X = (float)Math.floor(Math.random() * (screenWidth - bubble1.getWidth()));
            bubble1_Y = screenHeight + 100.0f;
        }
        bubble1.setX(bubble1_X);
        bubble1.setY(bubble1_Y);


        bubble2_Y -= 10;
        if (bubble2.getY() + bubble2.getHeight() < 0){
            bubble2_X = (float)Math.floor(Math.random() * (screenWidth - bubble2.getWidth()));
            bubble2_Y = screenHeight + 100.0f;
        }
        bubble2.setX(bubble2_X);
        bubble2.setY(bubble2_Y);

        bubble3_Y -= 10;
        if ( bubble3.getY() +  bubble3.getHeight() < 0){
            bubble3_X = (float)Math.floor(Math.random() * (screenWidth -  bubble3.getWidth()));
            bubble3_Y = screenHeight + 100.0f;
        }
        bubble3.setX( bubble3_X);
        bubble3.setY( bubble3_Y);


        bubble4_Y -= 10;
        if ( bubble4.getY() +  bubble4.getHeight() < 0){
            bubble4_X = (float)Math.floor(Math.random() * (screenWidth -  bubble4.getWidth()));
            bubble4_Y = screenHeight + 100.0f;
        }
        bubble4.setX(bubble4_X);
        bubble4.setY(bubble4_Y);

    }

}
