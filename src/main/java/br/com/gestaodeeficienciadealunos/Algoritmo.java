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

public class Algoritmo {
    private int codigo = 0;
    private String algoritmo = "";
    DefaultTableModel modelo_tabela;

    public Algoritmo(DefaultTableModel modelo_tabela)
    {
        this.modelo_tabela = modelo_tabela;
    }
      
    public void iniciar() throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM algoritmo ORDER BY DES_ALGORITMO ASC");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_ALGORITMO"), rs.getString("DES_ALGORITMO") });
        }
    }
    
    public void consultar(Algoritmo pb) throws SQLException
    {       
        clearTable();
        
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM algoritmo WHERE DES_ALGORITMO LIKE ? ORDER BY DES_ALGORITMO ASC");

        ps.setString(1, "%" + pb.getAlgoritmo() + "%");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_ALGORITMO"), rs.getString("DES_ALGORITMO") });
        }
    }
    
    public void salvar(Algoritmo pb) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("INSERT INTO algoritmo SET DES_ALGORITMO = ?");

        ps.setString(1, pb.getAlgoritmo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void editar(Algoritmo pb) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("UPDATE algoritmo SET DES_ALGORITMO = ? WHERE COD_ALGORITMO = ?");

        ps.setString(1, pb.getAlgoritmo());
        ps.setInt(2, pb.getCodigo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void deletar(int id) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("DELETE FROM algoritmo WHERE COD_ALGORITMO = ?");

        ps.setInt(1, id);

        ps.execute();
        Mysql.desconectar();
    }
    
    public Object getRowObject() throws SQLException
    {
        Object obj = null;
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM algoritmo ORDER BY COD_ALGORITMO DESC LIMIT 1");
        
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            obj = new Object[] { rs.getInt("COD_ALGORITMO"), rs.getString("DES_ALGORITMO") };
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

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }
}
