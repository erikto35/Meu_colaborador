package com.example.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela_holerite extends AppCompatActivity {

    private Button passe;
    private Button informe;
    private Button ajuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_holerite);

        Button passe = findViewById(R.id.passe);
        Button informe = findViewById(R.id.informe);
        Button ajuda = findViewById(R.id.ajuda);

        passe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_holerite.this, FormLogin.class);
                startActivity(intent);

            }
        });

        ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tela_holerite.this, tela_ajuda.class);
                startActivity(intent);
            }
        });


    }
}