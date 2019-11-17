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

public class Curso {
    private int codigo = 0;
    private String curso = "";
    private int periodo = 0;
    DefaultTableModel modelo_tabela;

    public Curso(DefaultTableModel modelo_tabela)
    {
        this.modelo_tabela = modelo_tabela;
    }
      
    public void iniciar() throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM curso ORDER BY NOM_CURSO ASC");

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_CURSO"), rs.getString("NOM_CURSO"), rs.getString("NUM_PERIODO") });
        }
    }
    
    public void consultar(Curso cs) throws SQLException
    {       
        clearTable();
        
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM curso WHERE NOM_CURSO LIKE ? AND NUM_PERIODO = ? ORDER BY NOM_CURSO ASC");

        ps.setString(1, "%" + cs.getCurso() + "%");
        ps.setInt(2, cs.getPeriodo());

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            modelo_tabela.addRow(new Object[] { rs.getInt("COD_CURSO"), rs.getString("NOM_CURSO"), rs.getString("NUM_PERIODO") });
        }
    }
    
    public void salvar(Curso cs) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("INSERT INTO curso SET NOM_CURSO = ?, NUM_PERIODO = ?");

        ps.setString(1, cs.getCurso());
        ps.setInt(2, cs.getPeriodo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void editar(Curso cs) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("UPDATE curso SET NOM_CURSO = ?, NUM_PERIODO = ? WHERE COD_CURSO = ?");

        ps.setString(1, cs.getCurso());
        ps.setInt(2, cs.getPeriodo());
        ps.setInt(3, cs.getCodigo());

        ps.execute();
        Mysql.desconectar();
    }
    
    public void deletar(int id) throws SQLException
    {
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("DELETE FROM curso WHERE COD_CURSO = ?");

        ps.setInt(1, id);

        ps.execute();
        Mysql.desconectar();
    }
    
    public Object getRowObject() throws SQLException
    {
        Object obj = null;
        Connection con = Mysql.conectar();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM curso ORDER BY COD_CURSO DESC LIMIT 1");
        
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            obj = new Object[] { rs.getInt("COD_CURSO"), rs.getString("NOM_CURSO"), rs.getString("NUM_PERIODO") };
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
