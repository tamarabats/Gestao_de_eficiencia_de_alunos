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

public class Linguagem {
    private int codigo = 0;
    private String linguagem = "";
    DefaultTableModel modelo_tabela;

    public Linguagem(DefaultTableModel modelo_tabela)
    {
        this.modelo_tabela = modelo_tabela;
    }
      
    public void iniciar() throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM linguagem ORDER BY NOM_LINGUAGEM ASC");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_LINGUAGEM"), rs.getString("NOM_LINGUAGEM") });
        }
    }
    
    public void consultar(Linguagem lg) throws SQLException
    {       
        clearTable();
        
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM linguagem WHERE NOM_LINGUAGEM LIKE ? ORDER BY NOM_LINGUAGEM ASC");

        ps.setString(1, "%" + lg.getLinguagem() + "%");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_LINGUAGEM"), rs.getString("NOM_LINGUAGEM") });
        }
    }
    
    public void salvar(Linguagem lg) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("INSERT INTO linguagem SET NOM_LINGUAGEM = ?");

        ps.setString(1, lg.getLinguagem());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void editar(Linguagem lg) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("UPDATE linguagem SET NOM_LINGUAGEM = ? WHERE COD_LINGUAGEM = ?");

        ps.setString(1, lg.getLinguagem());
        ps.setInt(2, lg.getCodigo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void deletar(int id) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("DELETE FROM linguagem WHERE COD_LINGUAGEM = ?");

        ps.setInt(1, id);

        ps.execute();
        Mysql.desconectar();
    }
    
    public Object getRowObject() throws SQLException
    {
        Object obj = null;
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM linguagem ORDER BY COD_LINGUAGEM DESC LIMIT 1");
        
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            obj = new Object[] { rs.getInt("COD_LINGUAGEM"), rs.getString("NOM_LINGUAGEM") };
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

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }
}
