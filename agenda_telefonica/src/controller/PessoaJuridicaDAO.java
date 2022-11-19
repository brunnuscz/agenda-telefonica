package controller;

import model.PessoaJuridica;
import model.BD;
import model.Cnpj;
import model.Cpf;
import model.Documento;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridicaBd;
import model.Telefone;

public class PessoaJuridicaDAO extends PessoaDAO{
	public BD pessoaJuridicaBd = new PessoaJuridicaBd();

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
		Pessoa pessoa = new PessoaJuridica();
		Documento umaCnpj = new Cnpj();
		
		System.out.print("\n - Nome: ");
		pessoa.nome = iu.sc.next();
		
		adicionarTelefone(pessoa);
		
		System.out.print(" - CNPJ: ");
		umaCnpj.numero = iu.sc.next();
		System.out.print(" - Local de emissao da CNPJ: ");
		umaCnpj.localDeEmissao = iu.sc.next();
		
		pessoa.documento = umaCnpj;
		
		Pessoa responsavel = new PessoaFisica();
		Documento umCpf = new Cpf();
		
		System.out.print("\n - Responsavel: ");
		System.out.print("\n  - Nome: ");
		responsavel.nome = iu.sc.next();
		
		adicionarTelefone(responsavel);
		
		System.out.print("  - CPF: ");
		umCpf.numero = iu.sc.next();
		System.out.print("  - Local de emissao do CPF: ");
		umCpf.localDeEmissao = iu.sc.next();
	
		responsavel.documento = umCpf;
		pessoa.setPessoa(responsavel);
		
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
