package hci201.se1171.oceanstudy;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {
    Button fish1;
    Button fish2;
    Button fish3;
    Button fish4;

    Context context = this;

    private int screenHeight;
    private int screenWidth;

    private ImageView bubble1;
    private ImageView bubble2;
    private ImageView bubble3;

    private float bubble1_X;
    private float bubble1_Y;
    private float bubble2_X;
    private float bubble2_Y;
    private float bubble3_X;
    private float bubble3_Y;


    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

//        fish1 =  findViewById(R.id.fish1);
//        fish2 =  findViewById(R.id.fish2);
//        fish3 =  findViewById(R.id.fish3);
//        fish4 =  findViewById(R.id.fish4);


        bubble1 = findViewById(R.id.bubble1);
        bubble2 = findViewById(R.id.bubble2);
        bubble3 = findViewById(R.id.bubble3);

//        TranslateAnimation translateYAnimation = new TranslateAnimation(0f, 0f, 0f, -15f);
//        translateYAnimation.setDuration(900);
//        translateYAnimation.setRepeatCount(Animation.INFINITE);
//        translateYAnimation.setRepeatMode(Animation.REVERSE);
//        fish1.setAnimation(translateYAnimation);
//        fish2.setAnimation(translateYAnimation);
//        fish3.setAnimation(translateYAnimation);
//        fish4.setAnimation(translateYAnimation);


        WindowManager wm = getWindowManager();
        Display dp = wm.getDefaultDisplay();
        Point size = new Point();
        dp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        bubble1.setX(-80.0f);
        bubble1.setY(-80.0f);
        bubble2.setX(-80.0f);
        bubble2.setY(-80.0f);
        bubble3.setX(-80.0f);
        bubble3.setY(-80.0f);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
//                        changePostBubble();

                    }
                });
            }
        },0,20);


        StringBuilder stringBuilder = new StringBuilder("http://192.168.85.2:8080/getAllFish");
        String url = stringBuilder.toString();

        Object dataTransfer[] = new Object[1];
        dataTransfer[0] = url;

        GetFishesUseAPI getAllFishes = new GetFishesUseAPI(this, this);
        getAllFishes.execute(dataTransfer);


    }

    public void showFishInfo(View view) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_fish_dialog);
        dialog.setTitle("Thông tin của cá.");

        // set the custom dialog components - text, image and button
//        TextView text = (TextView) dialog.findViewById(R.id.text);
//        text.setText("Android custom dialog example!");
//        ImageView image = (ImageView) dialog.findViewById(R.id.image);
//        image.setImageResource(R.drawable.ic_launcher);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
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


    }
}
