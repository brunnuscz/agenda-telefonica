package controller;

import java.util.ArrayList;

import model.Cpf;
import model.PessoaFisica;

public class AgendaPessoaFisica implements DAO{
	public ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
	
	@Override
	public void adicionarPessoa() {
		PessoaFisica contato = new PessoaFisica();
		Cpf umCpf = new Cpf();
		
		System.out.print("\n- Nome: ");
		contato.nome = iu.sc.next();
		System.out.print("- Telefone: ");
		contato.telefone = iu.sc.next();
		
		System.out.print("- CPF: ");
		umCpf.numeroCpf = iu.sc.next();
		System.out.print("- Local de emissao do CPF: ");
		umCpf.localDeEmissao = iu.sc.next();

		contato.cpf = umCpf;
		
		pessoasFisicas.add(contato);
	}
	@Override
	public void listarPessoa() {
		if(pessoasFisicas.size() != 0) {
			for(int i=0; i<pessoasFisicas.size(); i++) {
				System.out.println("_____________ Contato "+(i+1)+" ____________");
				System.out.println("\n > Nome: "+pessoasFisicas.get(i).nome);
				System.out.println(" > Telefone: "+pessoasFisicas.get(i).telefone);
				System.out.println(" > CPF: "+pessoasFisicas.get(i).cpf.numeroCpf);	
				System.out.println(" > Local de emissao do CPF: "+pessoasFisicas.get(i).cpf.localDeEmissao);					
				System.out.println(" > Tipo de Contato: "+pessoasFisicas.get(i).tipoDeContato());
			}										
		}else {
			System.out.println("____________________________________");
			System.out.println("\n------ Lista de contatos vazia -----");
		}
	}
}
