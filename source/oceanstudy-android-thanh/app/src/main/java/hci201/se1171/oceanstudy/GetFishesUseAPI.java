package hci201.se1171.oceanstudy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import pl.droidsonroids.gif.GifImageView;

public class GetFishesUseAPI extends AsyncTask<Object, String, String> {

    Context context;
    Activity activity;
    String url;
    InputStream is;
    BufferedReader br;
    StringBuilder sb;

    String data;



    public GetFishesUseAPI(Context context, Activity activity){
        this.context = context;
        this.activity = activity;
    }
    @Override
    protected String doInBackground(Object... objects) {
        try{

            url =(String) objects[0];
            URL myUrl = new URL(url);
            HttpURLConnection httpUrlConnection = (HttpURLConnection)myUrl.openConnection();
            httpUrlConnection.connect();
            is = httpUrlConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            String line = "";
            sb = new StringBuilder();
            while((line = br.readLine()) != null){
                sb.append(line);
            }

            data = sb.toString();

        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        try{

                LinearLayout constraintLayout = (LinearLayout) activity.findViewById(R.id.layoutBody);

                JSONArray jsonArray = new JSONArray(s);
                for(int i = 0; i < jsonArray.length() ; i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    final String fishName = jsonObject.getString("name");
                    String id = jsonObject.getString("id");
                    String image = jsonObject.getString("img");
                    final String video = jsonObject.getString("video");

                     GifImageView imageView = new GifImageView(this.context);
                     imageView.setId(Integer.parseInt(id));
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
                    Glide.with(this.context).load(image).into(imageViewTarget);

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showFishDialog(fishName, video);
                        }
                    });

//                    ConstraintSet set = new ConstraintSet();
//                    set.clone(constraintLayout);
//                    set.connect(imageView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
//                    set.connect(imageView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
//                    set.applyTo(constraintLayout);



                    constraintLayout.addView(imageView,i);


                }
//                Toast.makeText(this.context, jsonArray + " " , Toast.LENGTH_LONG).show();
        }catch(JSONException e){
            e.printStackTrace();
        }

    }


    public void showFishDialog(String name, String video){
        final Dialog dialog = new Dialog(this.context);
        dialog.setContentView(R.layout.activity_fish_dialog);
        dialog.setTitle("Thông tin của cá.");

        ImageView imageView = dialog.findViewById(R.id.image_fish_info);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(context).load(video).into(imageViewTarget);

                // set the custom dialog components - text, image and button
        TextView fishName = (TextView) dialog.findViewById(R.id.txt_fish_name);
        fishName.setText(name);
        fishName.setTextSize(30);


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
}
