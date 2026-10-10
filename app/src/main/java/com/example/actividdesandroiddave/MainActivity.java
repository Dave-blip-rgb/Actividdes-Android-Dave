package com.example.actividdesandroiddave;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //codigo
        EditText input_nombre = findViewById(R.id.input_nombre);
        EditText input_cm = findViewById(R.id.input_cm);
        Button boton_enviar = findViewById(R.id.boton_enviar);

        boton_enviar.setOnClickListener(v -> {
            //ejecutar cuando se haga click en boton
            //1- crear intent
            Intent intentResultado = new Intent(MainActivity.this , ResultadosActivity.class);

            String valor_nombre = String.valueOf(input_nombre.getText());
            //enviar nombre en intent
            intentResultado.putExtra("input_nombre", valor_nombre);

            //obtener cm en numero
            int valor_cm = Integer.parseInt(String.valueOf(input_cm.getText()));
            intentResultado.putExtra("input_cm", valor_cm);

            //inicializar intent
            startActivity(intentResultado);
        });
    }
}