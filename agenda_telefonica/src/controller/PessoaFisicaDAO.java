package controller;

import model.PessoaFisicaBd;
import model.Telefone;
import model.BD;
import model.Cpf;
import model.Documento;
import model.Pessoa;
import model.PessoaFisica;

public class PessoaFisicaDAO extends PessoaDAO{
	
	public BD pessoaFisicaBd = new PessoaFisicaBd();
	
	@Override
	public void adicionarTelefone(Pessoa p) {
		System.out.print(" - Quantos numeros deseja salvar: ");
		int qnt = iu.sc.nextInt();
		if(qnt < 1) {
			qnt = 1;
		}
		for(int i=0; i < qnt; i++) {
			System.out.print(" \t> Numero "+(i+1)+": ");
			Telefone telefone = new Telefone();
			telefone.numero = iu.sc.next();
			p.telefones.add(telefone);
		}			
	}
	
	@Override
	public void adicionar() {
		Pessoa pessoa = new PessoaFisica();
		Documento umCpf = new Cpf();
		
		System.out.print("\n - Nome: ");
		pessoa.nome = iu.sc.next();
		
		adicionarTelefone(pessoa);
		
		System.out.print(" - CPF: ");
		umCpf.numero = iu.sc.next();
		System.out.print(" - Local de emissao do CPF: ");
		umCpf.localDeEmissao = iu.sc.next();
		
		pessoa.documento = umCpf;
		pessoaFisicaBd.adicionarPessoa(pessoa);
	}
	@Override
	public void editar() {
		if(pessoaFisicaBd.listarPessoa()) {
			System.out.print("\n - Qual deseja editar: ");
			int escolhido = iu.sc.nextInt()-1;
			pessoaFisicaBd.editarPessoa(escolhido);			
		}
	}
	@Override
	public void listar() {
		pessoaFisicaBd.listarPessoa();
	}
	@Override
	public void remover() {
		if(pessoaFisicaBd.listarPessoa()) {
			System.out.print("\n - Qual deseja remover: ");
			int escolhido = iu.sc.nextInt()-1;
			pessoaFisicaBd.removerPessoa(escolhido);			
		}
	}
	@Override
	public void lixeira() {
		if(pessoaFisicaBd.listarPessoaRemovida()) {
			System.out.print("\n - Qual deseja restaurar: ");
			int escolhido = iu.sc.nextInt()-1;
			pessoaFisicaBd.restaurarPessoa(escolhido);			
		}
	}
	@Override
	public void buscar() {
		System.out.print("\n - Qual deseja buscar: ");
		String n = iu.sc.next();
		pessoaFisicaBd.buscarPessoa(n);			
	}
}
