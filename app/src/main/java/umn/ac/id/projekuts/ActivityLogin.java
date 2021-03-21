package umn.ac.id.projekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    Button login;
    EditText username, passwordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LOGIN PAGE");
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        passwordLogin = findViewById(R.id.passwordLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("uasmobile") && passwordLogin.getText().toString().equals("uasmobilegenap")){
                    Intent intentPlaylist = new Intent(ActivityLogin.this, MySong.class);
                    startActivity(intentPlaylist);
                }else{
                    Toast.makeText(ActivityLogin.this, "Pasword Yang Anda Masukan Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}