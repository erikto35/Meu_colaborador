package com.example.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.SQLException;

import com.google.android.material.snackbar.Snackbar;

public class mainActivity extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private EditText CPF, Senha;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponents();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity.this, FormCadastro.class);
                startActivity(intent);
            }
        });
        CPF = findViewById(R.id.edit_CPF);
        Senha = findViewById(R.id.editsenha);
        Button botaoentre = findViewById(R.id.bt_entrar);

        botaoentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editCPF = CPF.getText().toString();
                String editsenha = Senha.getText().toString();

                if (editCPF.isEmpty() || editsenha.isEmpty()) {
                    Snackbar.make(v, "preencha todos os campos corretamente", Snackbar.LENGTH_SHORT).show();
                }

            }

        });

    }
    private void IniciarComponents(){
        text_tela_cadastro =findViewById(R.id.tela_cadastro);

    }

}