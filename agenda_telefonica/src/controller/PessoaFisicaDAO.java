package controller;

import model.PessoaFisicaBd;
import model.Cpf;
import model.PessoaFisica;

public class PessoaFisicaDAO implements DAO{
	public PessoaFisicaBd pessoaFisicaBd = new PessoaFisicaBd();
	
	@Override
	public void adicionar() {
		PessoaFisica pessoa = new PessoaFisica();
		Cpf umCpf = new Cpf();
		System.out.print("\n - Nome: ");
		pessoa.nome = iu.sc.next();
		System.out.print(" - Telefone: ");
		pessoa.telefone = iu.sc.next();
		System.out.print(" - CPF: ");
		umCpf.numeroCpf = iu.sc.next();
		System.out.print(" - Local de emissao do CPF: ");
		umCpf.localDeEmissao = iu.sc.next();
		pessoa.cpf = umCpf;
		
		pessoaFisicaBd.adicionarPessoa(pessoa);
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
	@Override
	public void editar() {
		if(pessoaFisicaBd.listarPessoa()) {
			System.out.print("\n - Qual deseja editar: ");
			int escolhido = iu.sc.nextInt()-1;
			pessoaFisicaBd.editarPessoa(escolhido);			
		}
	}
}
