package com.example.demo1.Model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    public static Connection getCon(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName=MYTEST;encrypt=true;trustServerCertificate=true;","zshocker","Hich15");
        }catch (ClassNotFoundException e){
            System.err.println(e);
            return  null;
        }catch (SQLException e){
            System.err.println(e);
            return  null;
        }
    }
}
