package com.example.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.annotation.SuppressLint;

public class tela_ajuda extends AppCompatActivity {
    private Button passe;
    private Button informe;
    private Button ajuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ajuda);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button passe = findViewById(R.id.passe);
       @SuppressLint({"MissingInflatedId", "LocalSuppress"})
       Button informe = findViewById(R.id.informe);


        informe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_ajuda.this, tela_holerite.class);
                startActivity(intent);
            }
        });

        passe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_ajuda.this, FormLogin.class);
                startActivity(intent);

            }
        });
    }
}