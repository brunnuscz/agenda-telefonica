package view;

import java.util.ArrayList;

import model.Operacao;
import model.PessoaFisica;
import model.PessoaJuridica;

public class Agenda {
	public InterfaceUsuario iu = new InterfaceUsuario();
	
	public ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
	public ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
	
	public Operacao operacao = new Operacao();
	
	public void escolherOperacao() {
		int op;
		do {
			op = iu.pegarOpcao();
			switch (op) {
			case 1: {
				System.out.println("========== LISTAR CONTATOS =========\n");
				operacao.operacaoListar();
				System.out.println("\n====================================");			
				break;
			}
			case 2: {
				System.out.println("===== ADICIONANDO NOVO CONTATO =====\n");
				operacao.operacaoAdicionar();
				System.out.println("\n====================================");				
				break;
			}
			case 3: {
				System.out.println("========= REMOVER CONTATO ==========\n");
				//agenda.removerContato();
				System.out.println("\n====================================");				
				break;
			}
			case 4: {
				System.out.println("========== EDITAR CONTATO ==========\n");
				//agenda.editarContato();
				System.out.println("\n====================================");
				break;
			}
			case 5: {
				System.out.println("======== LIXEIRA DE CONTATOS =======\n");
				//agenda.lixeiraContato();
				System.out.println("\n====================================");
				break;
			}
			case 6: {
				System.out.println("--------- Saindo da Agenda ---------\n");
				break;
			}
			default:
				System.out.println("---------- Opcao Invalida ----------");
			}
			
		}while(op != 6);
	}
}
