package com.example.rodrigo_cid_colino_pmdm_tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadAlarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad_alarma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nombreAlarma = findViewById(R.id.tfNombre);
        EditText hora = findViewById(R.id.tfHora);
        EditText minutos = findViewById(R.id.tfMinutos);
        Button btnCrearAlarma = findViewById(R.id.btnCrearAlarma);



        btnCrearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, nombreAlarma.getText().toString())
                        .putExtra(AlarmClock.EXTRA_HOUR,Integer.parseInt(hora.getText().toString()))
                        .putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minutos.getText().toString()));

                startActivity(intent);
            }
        });


    }
}