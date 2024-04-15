package com.example.facedetection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class enter extends AppCompatActivity {

    TextView GotoSignup;
    EditText Email,Password;
    Button loginButton;
    FirebaseAuth mAuth ;
    ProgressBar loginProgressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        GotoSignup=findViewById(R.id.txtsignup);
        Email=findViewById(R.id.loginEmail);
        mAuth = FirebaseAuth.getInstance();
        Password=findViewById(R.id.loginPassword);
        loginProgressbar=findViewById(R.id.loginprogressBar);
        loginButton=findViewById(R.id.btnlogin);

        GotoSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Gotosignup=new Intent(getApplicationContext(), Register.class);
                startActivity(Gotosignup);
                finish();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Emailval,Passwordval;
                Emailval=Email.getText().toString();
                Passwordval=Password.getText().toString();

                if(TextUtils.isEmpty(Emailval))
                {
                    Toast.makeText(getApplicationContext(), "email empty", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(TextUtils.isEmpty(Passwordval))
                {
                    Toast.makeText(getApplicationContext(), "password empty", Toast.LENGTH_SHORT).show();
                }

                else {
                    loginProgressbar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(Emailval, Passwordval)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    loginProgressbar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(enter.this, "Login Successful",
                                                Toast.LENGTH_SHORT).show();
                                        Intent homepage = new Intent(getApplicationContext(), Homescreen.class);
                                        startActivity(homepage);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(enter.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

    }
}