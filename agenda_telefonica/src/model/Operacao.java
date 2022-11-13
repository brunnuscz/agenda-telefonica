package model;

import controller.AgendaPessoaFisica;
import controller.AgendaPessoaJuridica;
import view.InterfaceUsuario;

public class Operacao {
	InterfaceUsuario iu = new InterfaceUsuario();
	AgendaPessoaFisica agendaF = new AgendaPessoaFisica();
	AgendaPessoaJuridica agendaJ = new AgendaPessoaJuridica();
	
	public void operacaoAdicionar() {
		System.out.println("====================================");
		System.out.println("=       (0) - Pessoa Fisica        =");
		System.out.println("=      (1) - Pessoa Juridica       =");
		System.out.println("====================================\n");
		System.out.print("- Escolha: ");
		int op = iu.sc.nextInt();
		if(op == 0) {
			agendaF.adicionarPessoa();
		}else if(op == 1){
			agendaJ.adicionarPessoa();
		}
		else {
			System.out.println("\n---------- Opcao Invalida ----------");
		}
	}
	public void operacaoListar() {
		System.out.println("====================================");
		System.out.println("=       (0) - Pessoa Fisica        =");
		System.out.println("=      (1) - Pessoa Juridica       =");
  		System.out.println("====================================\n");
		System.out.print("- Escolha: ");
		int op = iu.sc.nextInt();
		if(op == 0) {
			agendaF.listarPessoa();
		}else if(op == 1){
			agendaJ.listarPessoa();
		}
		else {
			System.out.println("\n---------- Opcao Invalida ----------");
		}
	}
}
