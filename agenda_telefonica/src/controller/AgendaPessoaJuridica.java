package controller;

import java.util.ArrayList;

import model.Cnpj;
import model.Cpf;
import model.PessoaFisica;
import model.PessoaJuridica;

public class AgendaPessoaJuridica implements DAO{
	public ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
	
	@Override
	public void adicionarPessoa() {
		PessoaJuridica contato = new PessoaJuridica();
		Cnpj umaCnpj = new Cnpj();
		System.out.print("\n- Nome: ");
		contato.nome = iu.sc.next();
		System.out.print("- Telefone: ");
		contato.telefone = iu.sc.next();
		System.out.print("- CNPJ: ");
		umaCnpj.numeroCnpj = iu.sc.next();
		System.out.print("- Local de emissao da CNPJ: ");
		umaCnpj.localDeEmissao = iu.sc.next();
		contato.cnpj = umaCnpj;
		
		PessoaFisica responsavel = new PessoaFisica();
		Cpf umCpf = new Cpf();
		System.out.print("\n- Nome do Responsavel: ");
		responsavel.nome = iu.sc.next();
		System.out.print("- Telefone do Responsavel: ");
		responsavel.telefone = iu.sc.next();
		System.out.print("- CPF do Responsavel: ");
		umCpf.numeroCpf = iu.sc.next();
		System.out.print("- Local de emissao do CPF do Responsavel: ");
		umCpf.localDeEmissao = iu.sc.next();
		responsavel.cpf = umCpf;
		
		contato.responsavel = responsavel;
		pessoasJuridicas.add(contato);
	}
	@Override
	public void listarPessoa() {
		if(pessoasJuridicas.size() != 0) {
			for(int i=0; i<pessoasJuridicas.size(); i++) {
				System.out.println("_____________ Contato "+(i+1)+" ____________");
				System.out.println("\n > Nome: "+pessoasJuridicas.get(i).nome);
				System.out.println(" > Telefone: "+pessoasJuridicas.get(i).telefone);
				System.out.println(" > CNPJ: "+pessoasJuridicas.get(i).cnpj.numeroCnpj);		
				System.out.println(" > Local de emissao da CNPJ: "+pessoasJuridicas.get(i).cnpj.localDeEmissao);					
				System.out.println(" > Tipo de Contato: "+pessoasJuridicas.get(i).tipoDeContato());
				System.out.println(" > Responsavel: ");
				System.out.println("    - Nome: "+pessoasJuridicas.get(i).responsavel.nome);
				System.out.println("    - Telefone: "+pessoasJuridicas.get(i).responsavel.telefone);
				System.out.println("    - CPF: "+pessoasJuridicas.get(i).responsavel.cpf.numeroCpf);	
				System.out.println("    - Local de emissao do CPF: "+pessoasJuridicas.get(i).responsavel.cpf.localDeEmissao);					
				System.out.println("    - Tipo de Contato: "+pessoasJuridicas.get(i).responsavel.tipoDeContato());
			}
		}else {
			System.out.println("____________________________________");
			System.out.println("\n------ Lista de contatos vazia -----");
		}
	}
}
