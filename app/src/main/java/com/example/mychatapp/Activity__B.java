package com.example.mychatapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity__B extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(

            //ActivityResultContract
            //ActivityResultCollback


            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent i = result.getData();
                    String nameOOne = i.getStringExtra("nameOne");
                    String nowOne = i.getStringExtra("nowOne");
                    String genderOne = i.getStringExtra("genderOne");
                    String spOne = i.getStringExtra("spOne");

                    myNameTv.append(nameOOne+"\n"+nowOne+"\n"+genderOne+"\n"+spOne);
//                    if (result.getData()!=null){
//                        if (result.getResultCode()==105)
//                        {
//
//
//                        }
//
//                    }



                }
            }
    );
    TextView myNameTv;
    Button moveBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        myNameTv = findViewById(R.id.myDataTV);
        moveBt = findViewById(R.id.moveBT2);
//        Intent intent=getIntent();
//        String show=intent.getStringExtra("nameOne");
//        String showTwo=intent.getStringExtra("nowOne");
//        String showTree=intent.getStringExtra("genderOne");
//        String showFour=intent.getStringExtra("spOne");
//        myNameTv.setText(show+"\n"+showTwo+"\n"+showTree+"\n"+showFour);

        moveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Activity__A.class);
                launcher.launch(intent);
            }
        });


    }
}