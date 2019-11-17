/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeeficienciadealunos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Problema {
    private int codigo = 0;
    private String problema = "";
    DefaultTableModel modelo_tabela;

    public Problema(DefaultTableModel modelo_tabela)
    {
        this.modelo_tabela = modelo_tabela;
    }
      
    public void iniciar() throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM problema ORDER BY DES_PROBLEMA ASC");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_PROBLEMA"), rs.getString("DES_PROBLEMA") });
        }
    }
    
    public void consultar(Problema pb) throws SQLException
    {       
        clearTable();
        
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM problema WHERE DES_PROBLEMA LIKE ? ORDER BY DES_PROBLEMA ASC");

        ps.setString(1, "%" + pb.getProblema() + "%");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_PROBLEMA"), rs.getString("DES_PROBLEMA") });
        }
    }
    
    public void salvar(Problema pb) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("INSERT INTO problema SET DES_PROBLEMA = ?");

        ps.setString(1, pb.getProblema());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void editar(Problema pb) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("UPDATE problema SET DES_PROBLEMA = ? WHERE COD_PROBLEMA = ?");

        ps.setString(1, pb.getProblema());
        ps.setInt(2, pb.getCodigo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void deletar(int id) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("DELETE FROM problema WHERE COD_PROBLEMA = ?");

        ps.setInt(1, id);

        ps.execute();
        Mysql.desconectar();
    }
    
    public Object getRowObject() throws SQLException
    {
        Object obj = null;
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM problema ORDER BY COD_PROBLEMA DESC LIMIT 1");
        
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            obj = new Object[] { rs.getInt("COD_PROBLEMA"), rs.getString("DES_PROBLEMA") };
        }
        return obj;
    }
    
    public void resetTable() throws SQLException
    {
        clearTable();          
        iniciar();
    }
    
    public void clearTable() throws SQLException
    {
        modelo_tabela.setRowCount(0);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
