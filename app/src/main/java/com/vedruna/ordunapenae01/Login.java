package com.vedruna.ordunapenae01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void iniciarSesion(View view) {

        EditText user = (EditText) findViewById(R.id.editTxtUser);
        EditText pass = (EditText) findViewById(R.id.editTxtPass);

        TextView mensaje = (TextView) findViewById(R.id.txtMensaje);

        if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")){
            mensaje.setText("");
            String usuario = user.getText().toString();
            Intent intent = new Intent(this, FragmentsActivity.class);
            intent.putExtra("user", usuario);
            startActivity(intent);
        } else {
            mensaje.setTextColor(0xFFFF0000);
            mensaje.setText("Usuario o contraseña incorrecta");

        }
    }


}