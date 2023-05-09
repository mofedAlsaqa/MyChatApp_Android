package com.example.mychatapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.gms.common.api.internal.BasePendingResult;

public class Activity__A extends AppCompatActivity {


    Button moveBt,hidBt;
    EditText nameEt;
    CheckBox checkBoxOne,checkBoxTwo;
    RadioGroup rGroupOne;
    RadioButton mRadioBT,fRadioBT;
    Spinner spOnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        moveBt=findViewById(R.id.move_BT);
        nameEt=findViewById(R.id.nameET);
        checkBoxOne=findViewById(R.id.checkBox1);
        checkBoxTwo=findViewById(R.id.checkBox2);
        rGroupOne=findViewById(R.id.RGrop1);
        mRadioBT =findViewById(R.id.mRButton);
        fRadioBT=findViewById(R.id.fRButton);
        spOnee=findViewById(R.id.spOne);
        hidBt=findViewById(R.id.hideBT);



        moveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nameEt.getText().toString();
                String now="not Selected";
                if (checkBoxOne.isChecked())
                {
                    now="yes its mofeed";
                }else if (checkBoxTwo.isChecked())
                {
                    now="No not mofeed";
                }

                String gender="not Selected";
                if (rGroupOne.getCheckedRadioButtonId()==R.id.mRButton)
                {
                    gender="Male";
                }else if (rGroupOne.getCheckedRadioButtonId()==R.id.fRButton)
                {
                    gender="Female";
                }

               String spinnerOne= spOnee.getSelectedItem().toString();


                Intent intent=new Intent();
                 intent.putExtra("nameOne",name);
                 intent.putExtra("nowOne",now);
                 intent.putExtra("genderOne",gender);
                 intent.putExtra("spOne",spinnerOne);
                 Log.d("TAG", "send Success ");
                 setResult(105,intent);
                 finish();

            }
        });


        hidBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEt.setVisibility(View.INVISIBLE);
            }
        });


    }
}