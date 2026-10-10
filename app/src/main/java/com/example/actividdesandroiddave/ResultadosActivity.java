package com.example.actividdesandroiddave;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultados);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //variables en ResultadoActivity
        TextView resultado_nombre = findViewById(R.id.resultado_nombre);
        TextView resultado_metros = findViewById(R.id.resultado_metros);

        Intent intentActual = getIntent();

        //recuperar valores enviados en intent
        String nombre_actual = intentActual.getStringExtra("input_nombre");
        int cm_actual = intentActual.getIntExtra("input_cm", 0);

        //asignar en app
        resultado_nombre.setText("Hola "+ nombre_actual);

        //cm a mt
        float total_metros = cm_actual/100;
        resultado_metros.setText(cm_actual+"cm -> "+total_metros+"mt");
    }
}