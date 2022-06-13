package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	/*
	 * C = CREATE - OK
	 * R = READ   -
	 * U = UPDATE -
	 * D = DELETE -
	 */
	
	public void save(Contato contato) {
		
	
		String sql = "INSERT INTO contatos(nome,idade,dataCadastro) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar uma conexão com o banco de dados.
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataDeCadastro().getTime()));
			
			//Executar query	
			pstm.execute();
			System.out.println("Contato salvo com sucesso!!!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {		
			//fechar as conexoes.
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			}	
	}
		
	public void update(Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ? , dataCadastro =? "+
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualiza
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataDeCadastro().getTime()));
			
			//Qual o id do registro que deseja atualizar
			pstm.setInt(4, contato.getId());
			
			//Executar a query
			pstm.execute();
		}catch (Exception e) {
			e.fillInStackTrace();	
		}finally {
			try {
			if(pstm!= null) {
				pstm.close();
			}	
			if (conn!=null) {
				conn.close();
			}
			}catch (Exception e) {
				e.printStackTrace();
				}
			}
		}
	
	public void deleteByID(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
				
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}	
	}
	public List<Contato> getContatos(){
				String sql = "SELECT * FROM contatos";
				
				List<Contato> contatos = new ArrayList<Contato>();
				
				Connection conn = null;
				PreparedStatement pstm = null;
				
				//classe que vai recuperar os dados do banco de dados. ***SELECT***
				ResultSet rset = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = (PreparedStatement) conn.prepareStatement(sql);
					
					rset = pstm.executeQuery();
					
					while (rset.next()) {
						
						Contato contato = new Contato();
						
						//Recuperar o id
						contato.setId(rset.getInt("id"));
						//recuperar o nome
						contato.setNome(rset.getString("nome"));
						//recuperar a idade
						contato.setIdade(rset.getInt("idade"));
						//recuperar a data de cadastro
						contato.setDataDeCadastro(rset.getDate("dataCadastro"));
					
						contatos.add(contato);
						}
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
					
						if(rset!=null) {
							rset.close();
						}
						
						if(pstm!=null) {
							pstm.close();
						}
						
						if(conn!=null) {
							conn.close();
						}
					}catch (Exception e) {
						e.printStackTrace();
						}
					}
					return contatos;
				}
	}

