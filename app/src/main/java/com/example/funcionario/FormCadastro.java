package com.example.funcionario;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormCadastro extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button bt_cadastrar;

    private EditText Nome, CPF, nacimento, Telefone;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        Nome = findViewById(R.id.edit_nome);
        CPF = findViewById(R.id.edit_CPF);
        nacimento = findViewById(R.id.edit_nacimento);
        Telefone = findViewById(R.id.edit_Telefone);
        Button botaocad = findViewById(R.id.bt_cadastrar);

        nacimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        botaocad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editNome = Nome.getText().toString();
                String editCPF = CPF.getText().toString();
                String editNascimento = nacimento.getText().toString();
                String editTelefone = Telefone.getText().toString();

                if (editNome.isEmpty() || editCPF.isEmpty() || editNascimento.isEmpty() || editTelefone.isEmpty()) {
                    Snackbar.make(v, "preencha todos os campos corretamente", Snackbar.LENGTH_SHORT).show();
                } else if (!(isCPFValid(editCPF))) {
                    Snackbar.make(v, "CPF inválido", Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();

        Locale ptBR = new Locale("pt", "BR");
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", ptBR);
                        calendar.set(year, month, dayOfMonth);
                        String selectedDate = sdf.format(calendar.getTime());
                        nacimento.setText(selectedDate);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.getDatePicker().updateDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

    private boolean isCPFValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches(cpf.charAt(0) + "{11}")) {
            return false;
        }

        int[] weights = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * weights[i + 1];
        }

        int firstVerifyingDigit = 11 - sum % 11;
        if (firstVerifyingDigit >= 10) {
            firstVerifyingDigit = 0;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * weights[i];
        }

        int secondVerifyingDigit = 11 - sum % 11;
        if (secondVerifyingDigit >= 10) {
            secondVerifyingDigit = 0;
        }

        return firstVerifyingDigit == cpf.charAt(9) - '0' && secondVerifyingDigit == cpf.charAt(10) - '0';
    }
}
