/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Aluno;
import models.Professor;

/**
 *
 * @author estevao
 */
public class PessoaDAO {
    
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;
    
    public void inserirAluno(Aluno aluno){
        try{
        sql = "INSERT INTO aluno(nome, rg, cpf, endereco, ira) VALUES(?,?,?,?,?);";
        con = Conexao.openConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, aluno.getNome());
        pst.setString(2, aluno.getRg());
        pst.setString(3, aluno.getCpf());
        pst.setString(4, aluno.getEndereco());
        pst.setFloat(5, aluno.getIra());
        pst.execute();
        Conexao.closeConnection();
        
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
    
    public void inserirProfessor(Professor professor){
        try{
        sql = "INSERT INTO professor(nome, rg, cpf, endereco, formacao) VALUES(?,?,?,?,?);";
        con = Conexao.openConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, professor.getNome());
        pst.setString(2, professor.getRg());
        pst.setString(3, professor.getCpf());
        pst.setString(4, professor.getEndereco());
        pst.setString(5, professor.getFormacao());
        pst.execute();
        Conexao.closeConnection();
        
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void excluirAluno(String nome){
        try{
            sql = "DELETE FROM aluno where nome = ?;";
            con = Conexao.openConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            Conexao.closeConnection();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirProfessor(String nome){
        try{
            sql = "DELETE FROM professor where nome = ?;";
            con = Conexao.openConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            Conexao.closeConnection();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BuscarAluno(String nome) throws ClassNotFoundException, SQLException{
        sql = "SELECT * FROM aluno where nome = ?;";
        Aluno a = new Aluno();
        con = Conexao.openConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nome);
        rs = pst.executeQuery();
        if(rs.next()){
            a.setNome(rs.getString("nome"));
            a.setRg(rs.getString("rg"));
            a.setCpf(rs.getString("cpf"));
            a.setIra(rs.getFloat("ira"));
        }
        Conexao.closeConnection();
        
    }    

    public void BuscarProfessor(String nome) throws ClassNotFoundException, SQLException{
        sql = "SELECT * FROM aluno where nome = ?;";
        Professor p = new Professor();
        con = Conexao.openConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nome);
        rs = pst.executeQuery();
        if(rs.next()){
            p.setNome(rs.getString("nome"));
            p.setRg(rs.getString("rg"));
            p.setCpf(rs.getString("cpf"));
            p.setFormacao(rs.getString("formacao"));
        }
        Conexao.closeConnection();
        
    }
    
}
