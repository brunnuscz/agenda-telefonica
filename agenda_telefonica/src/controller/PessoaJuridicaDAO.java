package controller;

import model.PessoaJuridica;
import model.Cnpj;
import model.Cpf;
import model.PessoaFisica;
import model.PessoaJuridicaBd;

public class PessoaJuridicaDAO implements DAO{
	public PessoaJuridicaBd pessoaJuridicaBd = new PessoaJuridicaBd();
	@Override
	public void adicionar() {
		PessoaJuridica pessoa = new PessoaJuridica();
		Cnpj umaCnpj = new Cnpj();
		System.out.print("\n - Nome: ");
		pessoa.nome = iu.sc.next();
		System.out.print(" - Telefone: ");
		pessoa.telefone = iu.sc.next();
		System.out.print(" - CNPJ: ");
		umaCnpj.numeroCnpj = iu.sc.next();
		System.out.print(" - Local de emissao da CNPJ: ");
		umaCnpj.localDeEmissao = iu.sc.next();
		pessoa.cnpj = umaCnpj;
		
		PessoaFisica responsavel = new PessoaFisica();
		Cpf umCpf = new Cpf();
		System.out.print("\n - Responsavel: ");
		System.out.print("\n  - Nome: ");
		responsavel.nome = iu.sc.next();
		System.out.print("  - Telefone: ");
		responsavel.telefone = iu.sc.next();
		System.out.print("  - CPF: ");
		umCpf.numeroCpf = iu.sc.next();
		System.out.print("  - Local de emissao do CPF: ");
		umCpf.localDeEmissao = iu.sc.next();
		responsavel.cpf = umCpf;
		
		pessoa.responsavel = responsavel;
		pessoaJuridicaBd.adicionarPessoa(pessoa);
	}
	@Override
	public void buscar() {
		System.out.print("\n - Qual deseja buscar: ");
		String n = iu.sc.next();
		pessoaJuridicaBd.buscarPessoa(n);								
	}
	@Override
	public void listar() {
		pessoaJuridicaBd.listarPessoa();
	}
	@Override
	public void remover() {
		if(pessoaJuridicaBd.listarPessoa()) {
			System.out.print("\n - Qual deseja remover: ");
			int escolhido = iu.sc.nextInt()-1;
			pessoaJuridicaBd.removerPessoa(escolhido);			
		}
	}
	@Override
	public void lixeira() {
		if(pessoaJuridicaBd.listarPessoaRemovida()) {
			System.out.print("\n - Qual deseja restaurar: ");
			int escolhido = iu.sc.nextInt()-1;
			pessoaJuridicaBd.restaurarPessoa(escolhido);			
		}
	}
	@Override
	public void editar() {
		if(pessoaJuridicaBd.listarPessoa()) {		
			System.out.print("\n - Qual deseja editar: ");
			int escolhido = iu.sc.nextInt()-1;
			pessoaJuridicaBd.editarPessoa(escolhido);
		}
	}
}
