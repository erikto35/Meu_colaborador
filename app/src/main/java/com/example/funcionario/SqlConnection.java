package com.example.funcionario;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    private static final String URL = "jdbc:sqlserver://DESKTOP-AF6EDUF//SQLEXPRESSS";
    private static final String USERNAME = "SEU_USUARIO";
    private static final String PASSWORD = "SUA_SENHA";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Erro ao conectar: " + e.getMessage());
        }

    }

}


