package com.vedruna.ordunapenae01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = this.getIntent();
        String usuario = intent.getStringExtra("user");
        TextView creadoPor = (TextView) findViewById(R.id.txtCreatedBy);
        creadoPor.setText("By " + usuario);
    }

    public void volver(View view) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
    }
}