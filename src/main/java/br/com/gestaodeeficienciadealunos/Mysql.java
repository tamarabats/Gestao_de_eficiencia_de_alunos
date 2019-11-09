/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeeficienciadealunos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mysql{
    private static Connection con;
    private static PreparedStatement ps;
    
    public static Connection conectar() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:mysql://localhost/gestao_eficiencia_alunos", "root", "");
        return con;
    }
    
    public static void desconectar() throws SQLException
    {
        con.close();
    }
}
