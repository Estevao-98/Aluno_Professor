/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public Aluno BuscarAluno(String nome) throws ClassNotFoundException, SQLException{
        sql = "SELECT * FROM aluno where nome = ?;";
        Aluno a = new Aluno();
        con = Conexao.openConnection();
        pst = null;
        try{
        pst = con.prepareStatement(sql);
        pst.setString(1, nome);
        rs = pst.executeQuery();
        while(rs.next()){
            a.setNome(rs.getString("nome"));
            a.setRg(rs.getString("rg"));
            a.setCpf(rs.getString("cpf"));
            a.setIra(rs.getFloat("ira"));
        }
        }catch(SQLException ex){
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexao.closeConnection();
        return a;
    }  
    
    public List<Aluno> getAlunos() throws ClassNotFoundException, SQLException{
        List<Aluno> alunos = new ArrayList();
        sql = "SELECT * FROM aluno;";
        
        Aluno a = null;
        con = Conexao.openConnection();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            a = new Aluno();
            a.setNome(rs.getString("nome"));
            a.setRg(rs.getString("rg"));
            a.setCpf(rs.getString("cpf"));
            a.setEndereco(rs.getString("endereco"));
            a.setIra(rs.getFloat("ira"));
            alunos.add(a);
            
        }
        Conexao.closeConnection();
        return alunos;
    }
    public List<Professor> getProfessores() throws ClassNotFoundException, SQLException{
        List<Professor> professores = new ArrayList();
        sql = "SELECT * FROM professor;";
        
        Professor p = null;
        con = Conexao.openConnection();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            p = new Professor();
            p.setNome(rs.getString("nome"));
            p.setRg(rs.getString("rg"));
            p.setCpf(rs.getString("cpf"));
            p.setEndereco(rs.getString("endereco"));
            p.setFormacao(rs.getString("formacao"));
            professores.add(p);
            
        }
        Conexao.closeConnection();
        return professores;
    }
    public Professor BuscarProfessor(String nome) throws ClassNotFoundException, SQLException{
        sql = "SELECT * FROM professor where nome = ?;";
        Professor p = new Professor();
        con = Conexao.openConnection();
        pst = null;
        try{
        pst = con.prepareStatement(sql);
        pst.setString(1, nome);
        rs = pst.executeQuery();
        while(rs.next()){
        p.setNome(rs.getString("nome"));
        p.setRg(rs.getString("rg"));
        p.setCpf(rs.getString("cpf"));
        p.setEndereco(rs.getString("endereco"));
        p.setFormacao(rs.getString("formacao"));            
            
        }
        }catch(SQLException ex){
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexao.closeConnection();
        return p;
        
    }
    
}
