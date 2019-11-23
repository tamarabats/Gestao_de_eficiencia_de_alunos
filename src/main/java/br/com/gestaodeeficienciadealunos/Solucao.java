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

public class Solucao {
    private int codigo_solucao = 0;
    private int codigo_algoritmo = 0;
    private String descricao_solucao = "";
    private String descricao_computador = "";
    private String arquivo = "";
    DefaultTableModel modelo_tabela;

    public Solucao(DefaultTableModel modelo_tabela)
    {
        this.modelo_tabela = modelo_tabela;
    }
      
    public void iniciar() throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM solucao ORDER BY DES_SOLUCAO ASC");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_SOLUCAO"), rs.getInt("COD_ALGORITMO"), rs.getString("DES_SOLUCAO"), rs.getString("DES_COMPUTADOR"), rs.getString("NOM_ARQ_SOLUCAO") });
        }
    }
    
    public void consultar(Solucao ap) throws SQLException
    {       
        clearTable();
        
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM solucao WHERE DES_SOLUCAO LIKE ? OR DES_COMPUTADOR LIKE ? OR NOM_ARQ_SOLUCAO LIKE ? ORDER BY DES_SOLUCAO ASC");

        ps.setString(1, "%" + ap.getDescricaoSolucao() + "%");
        ps.setString(2, "%" + ap.getDescricaoComputador() + "%");
        ps.setString(3, "%" + ap.getArquivo() + "%");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_SOLUCAO"), rs.getInt("COD_ALGORITMO"), rs.getString("DES_SOLUCAO"), rs.getString("DES_COMPUTADOR"), rs.getString("NOM_ARQ_SOLUCAO") });
        }
    }
    
    public void salvar(Solucao ap) throws SQLException
    {
//        Connection con = Mysql.conectar();
//        PreparedStatement ps = con.prepareStatement("INSERT INTO area_pesquisa SET NOM_AREA_PESQUISA = ?, DES_AREA_PESQUISA = ?");
//
//        ps.setString(1, ap.getAreaPesquisa());
//        ps.setString(2, ap.getDescricao());
//
//        ps.execute();
//        Mysql.desconectar();
    }
    
    public void editar(Solucao ap) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("UPDATE area_pesquisa SET NOM_AREA_PESQUISA = ?, DES_AREA_PESQUISA = ? WHERE COD_AREA_PESQUISA = ?");

        ps.setString(1, ap.getDescricaoSolucao());
        ps.setString(2, ap.getDescricaoComputador());
        ps.setInt(3, ap.getCodigoSolucao());
        ps.setInt(4, ap.getCodigoAlgoritmo());
        ps.setString(5, ap.getArquivo());

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
    
    public int getCodigoAlgoritmo() {
        return codigo_algoritmo;
    }
    
    public int getCodigoSolucao() {
        return codigo_solucao;
    }
    
    public String getArquivo() {
        return arquivo;
    }

    public void setCodigoAlgoritmo(int codigo_algoritmo) {
        this.codigo_algoritmo = codigo_algoritmo;
    }

    public void setCodigoSolucao(int codigo_solucao) {
        this.codigo_solucao = codigo_solucao;
    }
    
    public void setDescricaoComputador(String descricao_comp) {
        this.descricao_computador = descricao_comp;
    }
    
    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getDescricaoSolucao() {
        return descricao_solucao;
    }
    
    public String getDescricaoComputador() {
        return descricao_computador;
    }

    public void setDescricaoSolucao(String descricao_solucao) {
        this.descricao_solucao = descricao_solucao;
    }
}
