package com.mimi.config;

import org.junit.jupiter.api.Test;

import java.sql.*;


public class ConnectionTest {
    @Test
    public static void main(String...args){
        Connection conn =null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siteweb?useSSL=false","root","Mimi1980");
            Statement statement =conn.createStatement();
            ResultSet resultat =statement.executeQuery("SELECT ID,EMAIL FROM USER");
            while (resultat.next()){
                final int id= resultat.getInt("ID");
                final String email=resultat.getString("EMAIL");
                System.out.println("L'email de l'utilisateur "+id+" est "+email);
            }
            System.out.println("success");
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (conn!=null) {
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
