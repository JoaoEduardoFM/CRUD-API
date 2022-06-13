package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;


public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Para executar o crud é necessario ir para a classe Main e "
		                 + "retirar os comentarios para executar o que deseja ser executado.\n");
		//salva um novo contato
		ContatoDAO contatodao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("João Eduardo");
		contato.setIdade(27);
		contato.setDataDeCadastro( new Date());	
			
		//Comando que executa o salvamento do registro.
		//contatodao.save(contato);
		
		//Atualizar o contato.
		Contato c1 = new Contato();
		c1.setNome("Maria Aparecida");
		c1.setIdade(85);
		c1.setDataDeCadastro(new Date());
		c1.setId(5);// PK do banco de dados.
		//Comando que executa a edição do registro.
		//contatodao.update(c1);
		
		//Comando que deleta o contato pelo seu numero de ID.
		//contatodao.deleteByID(6);
		
		//Visualização dos registros do banco de dados da tabela contatos
		for(Contato c : contatodao.getContatos()) {
		System.out.println("id:"+ c.getId()+" Contato: "+c.getNome() + " idade: " + c.getIdade() );
		}		
	}
}
