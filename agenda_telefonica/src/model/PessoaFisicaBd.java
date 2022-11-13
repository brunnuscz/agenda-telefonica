package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import view.InterfaceUsuario;

public class PessoaFisicaBd{
	public ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
	public ArrayList<PessoaFisica> pessoasFisicasRemovidas = new ArrayList<PessoaFisica>();
	Map<String, PessoaFisica> mapPessoasFisicas = new LinkedHashMap<String, PessoaFisica>();
	InterfaceUsuario iu = new InterfaceUsuario();
	
	// ADICIONAR PESSOA FISICA
	public boolean adicionarPessoa(PessoaFisica p) {
		if(verificarNome(p)) {
			pessoasFisicas.add(p);
			mapPessoasFisicas.put(p.nome, p);
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");			
			return true;
		}else {
			return false;
		}
	}
	// EDITAR PESSOA FISICA
	public boolean editarPessoa(int e) {
		if(e >= 0 && e < pessoasFisicas.size()) {
			mapPessoasFisicas.remove(pessoasFisicas.get(e).nome);
			
			System.out.print("\n - Nome: ");
			pessoasFisicas.get(e).nome = iu.sc.next();
			System.out.print(" - Telefone: ");
			pessoasFisicas.get(e).telefone = iu.sc.next();
			System.out.print(" - CPF: ");
			pessoasFisicas.get(e).cpf.numeroCpf = iu.sc.next();
			System.out.print(" - Local de emissao do CPF: ");
			pessoasFisicas.get(e).cpf.localDeEmissao = iu.sc.next();
			
			mapPessoasFisicas.put(pessoasFisicas.get(e).nome, pessoasFisicas.get(e));
			
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");			
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
			return false;
		}
	}
	// BUSCAR POR UM CARACTERE OU PALAVRA, SE EXISTE NO MAP DE PESSOAS FISICAS
	public void buscarPessoa(String n) {
		int teste = 0;
		for (String chave : mapPessoasFisicas.keySet()) { // Criar um conjunto de elementos-chave contidos no mapa
			PessoaFisica a = mapPessoasFisicas.get(chave); // a recebe o 1 elemento do conjunto de chaves
			if(a.nome.contains(n)) { // Se a palavra digitada contem nas chaves do map
				System.out.println("\n > Nome: "+mapPessoasFisicas.get(chave).nome); 
				System.out.println(" > Telefone: "+mapPessoasFisicas.get(chave).telefone);
				System.out.println(" > CPF: "+mapPessoasFisicas.get(chave).cpf.numeroCpf);
				System.out.println(" > Local de Emissao: "+mapPessoasFisicas.get(chave).cpf.localDeEmissao);
				System.out.println(" > Tipo de Pessoa: "+mapPessoasFisicas.get(chave).tipoDePessoa());
				teste = 1;
			}
		}
		if(teste != 1) {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
	}
	// LISTAR PESSOAS FISICAS
	public boolean listarPessoa() {
		if(verificarLista(pessoasFisicas)) {
			for(int i=0; i<pessoasFisicas.size(); i++) {
				System.out.println(" _____________ Pessoa "+(i+1)+" ___________ ");
				System.out.println("\n > Nome: "+pessoasFisicas.get(i).nome);
				System.out.println(" > Telefone: "+pessoasFisicas.get(i).telefone);
				System.out.println(" > CPF: "+pessoasFisicas.get(i).cpf.numeroCpf);		
				System.out.println(" > Local de emissao da CPF: "+pessoasFisicas.get(i).cpf.localDeEmissao);					
				System.out.println(" > Tipo de Contato: "+pessoasFisicas.get(i).tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	// REMOVER PESSOA FISICA
	public boolean removerPessoa(int e) {
		if(e >= 0 && e < pessoasFisicas.size()) {
			pessoasFisicasRemovidas.add(pessoasFisicas.get(e));			
			mapPessoasFisicas.remove(pessoasFisicas.get(e).nome);
			pessoasFisicas.remove(e);
			System.out.println("\n ---- Pessoa Removida com Exito --- ");	
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	// RESTAURAR DA LIXEIRA UMA PESSOA FISICA
	public boolean restaurarPessoa(int e) {
		if(e >= 0 && e < pessoasFisicasRemovidas.size()) {
			pessoasFisicas.add(pessoasFisicasRemovidas.get(e));
			mapPessoasFisicas.put(pessoasFisicasRemovidas.get(e).nome, pessoasFisicasRemovidas.get(e));		
			pessoasFisicasRemovidas.remove(e);
			System.out.println("\n --- Pessoa Restaurada com Exito -- ");
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	// LISTAR PESSOAS QUE ESTÃO NA LIXEIRA
	public boolean listarPessoaRemovida() {
		if(verificarLista(pessoasFisicasRemovidas)) {
			for(int i=0; i<pessoasFisicasRemovidas.size(); i++) {
				System.out.println("__________ Pessoa Removida "+(i+1)+" ________");
				System.out.println("\n > Nome: "+pessoasFisicasRemovidas.get(i).nome);
				System.out.println(" > Telefone: "+pessoasFisicasRemovidas.get(i).telefone);
				System.out.println(" > CPF: "+pessoasFisicasRemovidas.get(i).cpf.numeroCpf);		
				System.out.println(" > Local de emissao da CPF: "+pessoasFisicasRemovidas.get(i).cpf.localDeEmissao);					
				System.out.println(" > Tipo de Contato: "+pessoasFisicasRemovidas.get(i).tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	// VERIFICAR SE A LISTA PASSADA ESTÁ VAZIA
	public boolean verificarLista(ArrayList<PessoaFisica> p) {
		if(p.size() != 0) {
			return true;
		}else {
			System.out.println("\n ----------- Lista Vazia ---------- ");
			return false;
		}
	}
	// VERIFICAR SE O EXISTE ALGUM NOME NA LISTA DE PESSOAS SALVAS IGUAL AO NOME PASSADO
	public boolean verificarNome(PessoaFisica p) {
		for(int i=0; i<pessoasFisicas.size(); i++) {
			if(pessoasFisicas.get(i).nome.equals(p.nome)) {
				System.out.println("\n -- Ja Existe Esse Nome na Lista -- ");
				return false;				
			}
		}
		return true;
	}
	
}
