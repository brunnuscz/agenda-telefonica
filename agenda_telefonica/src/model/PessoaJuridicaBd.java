package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import view.InterfaceUsuario;

public class PessoaJuridicaBd{
	public ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
	public ArrayList<PessoaJuridica> pessoasJuridicasRemovidas = new ArrayList<PessoaJuridica>();
	Map<String, PessoaJuridica> mapPessoasJuridicas = new LinkedHashMap<String, PessoaJuridica>();
	InterfaceUsuario iu = new InterfaceUsuario();
	
	public boolean adicionarPessoa(PessoaJuridica p) {
		if(verificarNome(p) && p.documento.validarDocumento() && p.responsavel.documento.validarDocumento()) {
			pessoasJuridicas.add(p);
			mapPessoasJuridicas.put(p.nome, p);	
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");		
			return true;
		}else {
			return false;
		}
	}
	// EDITAR PESSOA JURIDICA
	public boolean editarPessoa(int e) {
		if(e >= 0 && e <pessoasJuridicas.size()) {
			mapPessoasJuridicas.remove(pessoasJuridicas.get(e).nome);
			
			System.out.print("\n - Nome: ");
			pessoasJuridicas.get(e).nome = iu.sc.next();
			System.out.print(" - Telefone: ");
			pessoasJuridicas.get(e).telefone = iu.sc.next();
			System.out.print(" - CNPJ: ");
			pessoasJuridicas.get(e).documento.numero = iu.sc.next();
			System.out.print(" - Local de emissao do CNPJ: ");
			pessoasJuridicas.get(e).documento.localDeEmissao = iu.sc.next();
			
			
			System.out.print("\n - Responsavel: ");
			System.out.print("\n  - Nome: ");
			pessoasJuridicas.get(e).responsavel.nome = iu.sc.next();
			System.out.print("  - Telefone: ");
			pessoasJuridicas.get(e).responsavel.telefone = iu.sc.next();
			System.out.print("  - CPF: ");
			pessoasJuridicas.get(e).responsavel.documento.numero = iu.sc.next();
			System.out.print("  - Local de emissao do CPF: ");
			pessoasJuridicas.get(e).responsavel.documento.localDeEmissao = iu.sc.next();
			
			mapPessoasJuridicas.put(pessoasJuridicas.get(e).nome, pessoasJuridicas.get(e));
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");			
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	public void buscarPessoa(String n) {
		int teste = 0;
		for (String chave : mapPessoasJuridicas.keySet()) { // Criar um conjunto de elementos-chave contidos no mapa
			PessoaJuridica a = mapPessoasJuridicas.get(chave); // a recebe o 1 elemento do conjunto de chaves
			if(a.nome.contains(n)) { // Se a palavra digitada contem nas chaves do map
				System.out.println("\n > Nome: "+mapPessoasJuridicas.get(chave).nome); 
				System.out.println(" > Telefone: "+mapPessoasJuridicas.get(chave).telefone);
				System.out.println(" > CNPJ: "+mapPessoasJuridicas.get(chave).documento.numero);
				System.out.println(" > Local de Emissao: "+mapPessoasJuridicas.get(chave).documento.localDeEmissao);
				System.out.println(" > Tipo de Pessoa: "+mapPessoasJuridicas.get(chave).tipoDePessoa());
				System.out.println(" > Responsavel: ");
				System.out.println(" - Nome: "+mapPessoasJuridicas.get(chave).responsavel.nome);
				System.out.println(" - Telefone: "+mapPessoasJuridicas.get(chave).telefone);
				System.out.println(" - CPF: "+mapPessoasJuridicas.get(chave).responsavel.documento.numero);		
				System.out.println(" - Local de emissao da CPF: "+mapPessoasJuridicas.get(chave).responsavel.documento.localDeEmissao);					
				System.out.println(" - Tipo de Pessoa: "+mapPessoasJuridicas.get(chave).responsavel.tipoDePessoa());
				teste = 1;
			}
		}
		if(teste != 1) {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
	}
	public boolean listarPessoa() {
		if(verificarLista(pessoasJuridicas)) {
			for(int i=0; i<pessoasJuridicas.size(); i++) {
				System.out.println(" _____________ Pessoa "+(i+1)+" ___________ ");
				System.out.println("\n > Nome: "+pessoasJuridicas.get(i).nome);
				System.out.println(" > Telefone: "+pessoasJuridicas.get(i).telefone);
				System.out.println(" > CPF: "+pessoasJuridicas.get(i).documento.numero);		
				System.out.println(" > Local de emissao da CPF: "+pessoasJuridicas.get(i).documento.localDeEmissao);					
				System.out.println(" > Tipo de Pessoa: "+pessoasJuridicas.get(i).tipoDePessoa());
				System.out.println(" > Responsavel: ");
				System.out.println(" - Nome: "+pessoasJuridicas.get(i).responsavel.nome);
				System.out.println(" - Telefone: "+pessoasJuridicas.get(i).telefone);
				System.out.println(" - CPF: "+pessoasJuridicas.get(i).responsavel.documento.numero);		
				System.out.println(" - Local de emissao da CPF: "+pessoasJuridicas.get(i).responsavel.documento.localDeEmissao);					
				System.out.println(" - Tipo de Pessoa: "+pessoasJuridicas.get(i).responsavel.tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	public boolean listarPessoaRemovida() {
		if(verificarLista(pessoasJuridicasRemovidas)) {
			for(int i=0; i<pessoasJuridicasRemovidas.size(); i++) {
				System.out.println("\n _________ Pessoa Removida "+(i+1)+" ______ ");
				System.out.println("\n > Nome: "+pessoasJuridicasRemovidas.get(i).nome);
				System.out.println(" > Telefone: "+pessoasJuridicasRemovidas.get(i).telefone);
				System.out.println(" > CPF: "+pessoasJuridicasRemovidas.get(i).documento.numero);		
				System.out.println(" > Local de emissao da CPF: "+pessoasJuridicasRemovidas.get(i).documento.localDeEmissao);					
				System.out.println(" > Tipo de Pessoa: "+pessoasJuridicasRemovidas.get(i).tipoDePessoa());
				System.out.println(" > Responsavel: ");
				System.out.println(" - Nome: "+pessoasJuridicasRemovidas.get(i).responsavel.nome);
				System.out.println(" - Telefone: "+pessoasJuridicasRemovidas.get(i).telefone);
				System.out.println(" - CPF: "+pessoasJuridicasRemovidas.get(i).responsavel.documento.numero);		
				System.out.println(" - Local de emissao da CPF: "+pessoasJuridicasRemovidas.get(i).responsavel.documento.localDeEmissao);					
				System.out.println(" - Tipo de Pessoa: "+pessoasJuridicasRemovidas.get(i).responsavel.tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	public boolean removerPessoa(int e) {
		if(e >= 0 && e < pessoasJuridicas.size()) {
			pessoasJuridicasRemovidas.add(pessoasJuridicas.get(e));			
			mapPessoasJuridicas.remove(pessoasJuridicas.get(e).nome);
			pessoasJuridicas.remove(e);
			System.out.println("\n ---- Pessoa Removida com Exito --- ");	
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	public boolean restaurarPessoa(int e) {
		if(e >= 0 && e < pessoasJuridicasRemovidas.size()) {
			pessoasJuridicas.add(pessoasJuridicasRemovidas.get(e));			
			mapPessoasJuridicas.put(pessoasJuridicasRemovidas.get(e).nome, pessoasJuridicasRemovidas.get(e));
			pessoasJuridicasRemovidas.remove(e);
			System.out.println("\n --- Pessoa Restaurada com Exito -- ");
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	public boolean verificarLista(ArrayList<PessoaJuridica> p) {
		if(p.size() != 0) {
			return true;
		}else {
			System.out.println("\n ----------- Lista Vazia ---------- ");
			return false;
		}
	}
	// VERIFICAR SE O EXISTE ALGUM NOME NA LISTA DE PESSOAS SALVAS IGUAL AO NOME PASSADO
	public boolean verificarNome(PessoaJuridica p) {
		for(int i=0; i<pessoasJuridicas.size(); i++) {
			if(pessoasJuridicas.get(i).nome.equals(p.nome)) {
				System.out.println("\n -- Ja Existe Esse Nome na Lista -- ");
				return false;				
			}
		}
		return true;
	}
}
