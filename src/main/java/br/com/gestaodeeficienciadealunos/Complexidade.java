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

public class Complexidade {
    private int codigo = 0;
    private String complexidade = "";
    DefaultTableModel modelo_tabela;

    public Complexidade(DefaultTableModel modelo_tabela)
    {
        this.modelo_tabela = modelo_tabela;
    }
      
    public void iniciar() throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM complexidade ORDER BY DES_GRAU_COMPLEXIDADE ASC");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_COMPLEXIDADE"), rs.getString("DES_GRAU_COMPLEXIDADE") });
        }
    }
    
    public void consultar(Complexidade cp) throws SQLException
    {       
        clearTable();
        
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM complexidade WHERE DES_GRAU_COMPLEXIDADE LIKE ? ORDER BY DES_GRAU_COMPLEXIDADE ASC");

        ps.setString(1, "%" + cp.getComplexidade() + "%");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_COMPLEXIDADE"), rs.getString("DES_GRAU_COMPLEXIDADE") });
        }
    }
    
    public void salvar(Complexidade cp) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("INSERT INTO complexidade SET DES_GRAU_COMPLEXIDADE = ?");

        ps.setString(1, cp.getComplexidade());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void editar(Complexidade cp) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("UPDATE complexidade SET DES_GRAU_COMPLEXIDADE = ? WHERE COD_COMPLEXIDADE = ?");

        ps.setString(1, cp.getComplexidade());
        ps.setInt(2, cp.getCodigo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void deletar(int id) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("DELETE FROM complexidade WHERE COD_COMPLEXIDADE = ?");

        ps.setInt(1, id);

        ps.execute();
        Mysql.desconectar();
    }
    
    public Object getRowObject() throws SQLException
    {
        Object obj = null;
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM complexidade ORDER BY COD_COMPLEXIDADE DESC LIMIT 1");
        
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            obj = new Object[] { rs.getInt("COD_COMPLEXIDADE"), rs.getString("DES_GRAU_COMPLEXIDADE") };
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

    public String getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }
}
