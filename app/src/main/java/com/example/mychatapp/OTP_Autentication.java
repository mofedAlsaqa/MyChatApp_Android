package com.example.mychatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTP_Autentication extends AppCompatActivity {

    TextView mchangenumber;
    EditText mgetotp;
    android.widget.Button mverifyotp;
    String enteredotp;


    FirebaseAuth firebaseAuth;
    ProgressBar mprogresbarodotpauth;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_autentication);
        mchangenumber=findViewById(R.id.Change_Number);
        mgetotp=findViewById(R.id.Get_Code);
        mverifyotp=findViewById(R.id.VerfyCode_Btn);
        mprogresbarodotpauth=findViewById(R.id.ProgressBarOfOTPAuth);
        firebaseAuth=FirebaseAuth.getInstance();




        mchangenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OTP_Autentication.this,MainActivity.class);

                startActivity(intent);
            }
        });
        mverifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enteredotp=mgetotp.getText().toString();
                if (enteredotp.isEmpty())
                {
                    Toast.makeText(OTP_Autentication.this, "Enter your OTP First", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mprogresbarodotpauth.setVisibility(View.VISIBLE);
                    String coderesived=getIntent().getStringExtra("otp");
                    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(coderesived,enteredotp);
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    mprogresbarodotpauth.setVisibility(View.INVISIBLE);
                    Toast.makeText(OTP_Autentication.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(OTP_Autentication.this,SetProfile.class);
                    startActivity(intent);
                    finish();
                }else
                {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                    {
                        mprogresbarodotpauth.setVisibility(View.VISIBLE);
                        Toast.makeText(OTP_Autentication.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}