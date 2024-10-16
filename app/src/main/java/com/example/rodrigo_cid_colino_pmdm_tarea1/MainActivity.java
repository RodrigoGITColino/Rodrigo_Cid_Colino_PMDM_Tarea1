package com.example.rodrigo_cid_colino_pmdm_tarea1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    String user = "";
    String pass = "";


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
try {
    if (getApplicationContext().fileList().length > 2) {

      //  File f = new File(getApplicationContext().getFilesDir(), "credenciales.txt");

    }
}catch (Exception e){
    throw new RuntimeException(e);
}


        try {
            FileInputStream fis = getApplicationContext().openFileInput("credenciales.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                user = reader.readLine();
                pass = reader.readLine();

            } catch (IOException e) {
                // Error occurred when opening raw file for reading.
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        String[] cosinas = getApplicationContext().fileList();

        Button bLogin = findViewById(R.id.btIniciar);
        EditText tfUser = findViewById(R.id.ptNombre);
        EditText tfPass = findViewById(R.id.ptPassword);
        Button bCredenciales = findViewById(R.id.btnCredenciales);
        bLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (tfUser.getText().toString().equals(user) && tfPass.getText().toString().equals(pass)) {

                    //make intent

                    Intent intent = new Intent(MainActivity.this, ActividadLogin.class);
                    intent.putExtra("nombre", tfUser.getText().toString());
                    startActivity(intent);


                    Intent iLogin = new Intent(MainActivity.this, ActividadLogin.class);
                    iLogin.putExtra("nombre", tfUser.getText().toString());


                    startActivity(iLogin);


                } else {


                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();

                }


            }


        });
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(


                new ActivityResultContracts.StartActivityForResult(), result -> {

                    if (result.getResultCode() == RESULT_OK) {


                        Intent data = result.getData();
                        user = data.getStringExtra("nombre");
                        pass = data.getStringExtra("password");

                        System.out.println();


                    }


                }


        );
        bCredenciales.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActividadCredenciales.class);
                activityResultLauncher.launch(intent);


            }

        });
    }
}