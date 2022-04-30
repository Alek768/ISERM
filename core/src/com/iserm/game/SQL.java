package com.iserm.game;

import javax.xml.transform.Result;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SQL {

    private Connection c;
    private static SQL instance;

    public SQL() throws IOException{
        setConnection();
    }

    /**
     * @return
     */
    public static SQL getInstance() throws IOException {
        if (instance == null){
            instance = new SQL();
        }
        return instance;
    }
    /**
     * Test si on peut connecter la BDD
     * @return
     */
    private boolean testConnection() throws IOException {
        boolean b;
        Properties props = new Properties();
        props.load(new FileReader("db.properties"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(props.getProperty("url"),props.getProperty("user"),props.getProperty("password"));
            b = true;
        } catch (Exception e){
            e.printStackTrace();
            b = false;
        }
        return b;
    }

    /**
     * Effectue la connexion
     */
    private void setConnection() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("db.properties"));
        if (testConnection()){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection(props.getProperty("url"),props.getProperty("user"),props.getProperty("password"));
                this.c = c;
                System.out.println("Connected");
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Connection Failed");
            }
        } else {
            System.out.println("Connection impossible");
        }
    }

    /**
     * Arrête la connexion
     */
    private void arretConnection() {
        try {
            this.c.close();
            System.out.println("Disconnected");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Disconnection failed");
        }
    }

    /**
     * Méthode qui va modifier le contenu d'une BDD
     * @param requete
     */
    //1 Value Int
    public void Update(String requete, Object value1) {
        try{
            PreparedStatement pstmt = c.prepareStatement(requete);
            pstmt.setInt(1,(int) value1);
            pstmt.executeUpdate();
            System.out.println("Updated");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update Failed");
        }
    }
    //2 Value Int
    public void Update(String requete, Object value1, Object value2) {
        try{
            PreparedStatement pstmt = c.prepareStatement(requete);
            pstmt.setInt(1,(int) value1);
            pstmt.setInt(2,(int) value2);
            pstmt.executeUpdate();
            System.out.println("Updated");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update Failed");
        }
    }
    //3 Value String
    public void UpdateString(String requete, Object value1, Object value2, Object value3) {
        try{
            PreparedStatement pstmt = c.prepareStatement(requete);
            pstmt.setString(1, value1.toString());
            pstmt.setString(2, value2.toString());
            pstmt.setString(3, value3.toString());
            pstmt.executeUpdate();
            System.out.println("Updated");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update Failed");
        }
    }

    /**
     * Méthode qui vient chercher les informations dans la BDD
     * @param requete
     * @return
     */
    public ResultSet Request(String requete){
        ResultSet Result = null;
        try{
            PreparedStatement pstmt = c.prepareStatement(requete);
            Result = pstmt.executeQuery(requete);
            //Print dans la console.
            ResultSetMetaData rsmd = Result.getMetaData();
            int nbCols = rsmd.getColumnCount();
            boolean next = Result.next();
            while (next) {
                for (int i = 1; i <= nbCols; i++) {
                    System.out.print(Result.getString(i) + " ");
                }
                System.out.println();
                next = Result.next();
            }
            Result.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Request Failed");
        }
        return Result;
    }

    public ResultSet Request1(String requete,Object value1){
        ResultSet Result = null;
        try{
            PreparedStatement pstmt = c.prepareStatement(requete);
            pstmt.setInt(1,(int) value1);
            Result = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Request Failed");
        }
        return Result;
    }
    public ResultSet Request2(String requete,Object value1, Object value2){
        ResultSet Result = null;
        try{
            PreparedStatement pstmt = c.prepareStatement(requete);
            pstmt.setInt(1,(int) value1);
            pstmt.setInt(2,(int) value2);
            Result = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Request Failed");
        }
        return Result;
    }
    public ResultSet RequestString(String requete,Object value1, Object value2){
        ResultSet Result = null;
        try{
            PreparedStatement pstmt = c.prepareStatement(requete);
            pstmt.setString(1,value1.toString());
            pstmt.setString(2,value2.toString());
            Result = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Request Failed");
        }
        return Result;
    }
}