package com.company.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static DataBase dataBase = null;
    private final String url =  "jdbc:postgresql://localhost/customer_tracker";
    private final String user = "postgres";
    private final String password = "3499190";

    private DataBase(){

    }

    public static DataBase INSTANCE(){
        if(dataBase == null){
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public Connection connect() throws ClassNotFoundException {

        Connection con = null;

        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to the PostgreSQL server succesfully");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }
}
