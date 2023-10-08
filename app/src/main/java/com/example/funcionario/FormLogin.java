package com.example.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FormLogin extends AppCompatActivity {

    private Button passe;
    private Button informe;
    private Button ajuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button ajuda = findViewById(R.id.ajuda);
        Button informe = findViewById(R.id.informe);

        informe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this, tela_holerite.class);
                startActivity(intent);
            }
        });

        ajuda.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(FormLogin.this, tela_ajuda.class);
            startActivity(intent);
        }
    });


}
}
