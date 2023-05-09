package com.example.mychatapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Action extends AppCompatActivity {
    Button BT1, BT2, BT3, BT4;
    ImageView Img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityResultLauncher <Intent>launcher=registerForActivityResult(

                //ActivityResultContract
                //ActivityResultCollback

                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                   if (result.getResultCode()==RESULT_OK)
                   {
                       Intent intent=result.getData();
                       Bitmap pm=(Bitmap) intent.getExtras().get("data");
                       Img.setImageBitmap(pm);



                   }



                    }
                }
        );
        setContentView(R.layout.activity_action);
        BT1 = findViewById(R.id.button1);
        BT2 = findViewById(R.id.button2);
        BT3 = findViewById(R.id.button3);
        BT4 = findViewById(R.id.button4);
        Img=findViewById(R.id.IMV);


        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0597135573"));
                startActivity(intent);
            }
        });

        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/search?q=tran" +
                        "slate&oq=tra&aqs=chrome.0.69i59i131i433i512j69i57j0" +
                        "i131i433i512l3j69i60j69i61j69i60.1396j0j7&sourceid=chrome&ie=UTF-8"));
                startActivity(intent);

            }
        });
        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=YOlboKLVZzU"));
                startActivity(intent);

            }
        });
        BT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                launcher.launch(intent);


            }
        });
    }
}