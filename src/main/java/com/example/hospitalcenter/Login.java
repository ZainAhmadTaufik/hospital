package com.example.hospitalcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText user,pass;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String usern = user.getText().toString();
                String passw = pass.getText().toString();
                Log.d("anu", "onClick: "+passw+" "+usern);
                if(usern.equals("admin") && passw.equals("admin")){
                    Toast.makeText(Login.this, "berhasil login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,MainActivity.class));
                }else {
                    Toast.makeText(Login.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}