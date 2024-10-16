package com.example.rodrigo_cid_colino_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btModificar), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button bLogin = findViewById(R.id.btIniciar);
        EditText tfUser = findViewById(R.id.ptNombre);
        EditText tfPass = findViewById(R.id.ptPassword);

        bLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (tfUser.getText().toString().equals("admin") && tfPass.getText().toString().equals("admin")) {

                    //make intent

                    Intent intent = new Intent(MainActivity.this, ActividadLogin.class);
                    intent.putExtra("nombre", tfUser.getText().toString());
                    startActivity(intent);


                    Intent iLogin = new Intent(MainActivity.this, ActividadLogin.class);
                    iLogin.putExtra("nombre", tfUser.getText().toString());


                    startActivity(iLogin);





                } else {

                    //Make a toast here with the message "hello"
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();

                }


            }


        });


    }
}