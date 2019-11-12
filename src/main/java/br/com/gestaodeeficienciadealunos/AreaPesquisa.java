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

public class AreaPesquisa {
    private int codigo = 0;
    private String area_pesquisa = "";
    private String descricao = "";
    DefaultTableModel modelo_tabela;

    public AreaPesquisa(DefaultTableModel modelo_tabela)
    {
        this.modelo_tabela = modelo_tabela;
    }
      
    public void iniciar() throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM area_pesquisa ORDER BY NOM_AREA_PESQUISA ASC");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_AREA_PESQUISA"), rs.getString("NOM_AREA_PESQUISA"), rs.getString("DES_AREA_PESQUISA") });
        }
    }
    
    public void consultar(AreaPesquisa ap) throws SQLException
    {       
        clearTable();
        
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM area_pesquisa WHERE NOM_AREA_PESQUISA LIKE ? AND DES_AREA_PESQUISA LIKE ? ORDER BY NOM_AREA_PESQUISA ASC");

        ps.setString(1, "%" + ap.getAreaPesquisa() + "%");
        ps.setString(2, "%" + ap.getDescricao() + "%");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_AREA_PESQUISA"), rs.getString("NOM_AREA_PESQUISA"), rs.getString("DES_AREA_PESQUISA") });
        }
    }
    
    public void salvar(AreaPesquisa ap) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("INSERT INTO area_pesquisa SET NOM_AREA_PESQUISA = ?, DES_AREA_PESQUISA = ?");

        ps.setString(1, ap.getAreaPesquisa());
        ps.setString(2, ap.getDescricao());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void editar(AreaPesquisa ap) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("UPDATE area_pesquisa SET NOM_AREA_PESQUISA = ?, DES_AREA_PESQUISA = ? WHERE COD_AREA_PESQUISA = ?");

        ps.setString(1, ap.getAreaPesquisa());
        ps.setString(2, ap.getDescricao());
        ps.setInt(3, ap.getCodigo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void deletar(int id) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("DELETE FROM area_pesquisa WHERE COD_AREA_PESQUISA = ?");

        ps.setInt(1, id);

        ps.execute();
        Mysql.desconectar();
    }
    
    public Object getRowObject() throws SQLException
    {
        Object obj = null;
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM area_pesquisa ORDER BY COD_AREA_PESQUISA DESC LIMIT 1");
        
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            obj = new Object[] { rs.getInt("COD_AREA_PESQUISA"), rs.getString("NOM_AREA_PESQUISA"), rs.getString("DES_AREA_PESQUISA") };
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

    public String getAreaPesquisa() {
        return area_pesquisa;
    }

    public void setAreaPesquisa(String area_pesquisa) {
        this.area_pesquisa = area_pesquisa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
