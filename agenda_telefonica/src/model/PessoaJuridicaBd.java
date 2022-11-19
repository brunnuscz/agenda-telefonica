package model;

import java.util.ArrayList;

public class PessoaJuridicaBd extends BD{
	// ADICIONAR UMA PESSOA
	@Override
	public boolean adicionarPessoa(Pessoa p) {
		if(verificarNome(p) && p.documento.validarDocumento()) { // && p.responsavel.documento.validarDocumento()
			listaPessoas.add(p);
			mapPessoas.put(p.nome, p);	
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");		
			return true;
		}else {
			return false;
		}
	}
    // EDITAR UM TELEFONE ESCOLHIDO
	@Override
	public void editarTelefone(Pessoa p) {
		p.listarTelefones();
		System.out.print(" - Qual numero deseja editar: ");
		int escolhido = iu.sc.nextInt()-1;
		if(escolhido >= 0 && escolhido < p.telefones.size()) {
			System.out.print(" - Editar numero "+(escolhido+1)+": ");
			
			p.telefones.get(escolhido).numero = iu.sc.next();			
		}else {
			System.out.println("\n ------- Telefone invalido -------- \n");
		}
	}
	// EDITAR PESSOA JURIDICA
	@Override
	public boolean editarPessoa(int e) {
		if(e >= 0 && e <listaPessoas.size()) {
			mapPessoas.remove(listaPessoas.get(e).nome);
			
			System.out.print("\n - Nome: ");
			listaPessoas.get(e).nome = iu.sc.next();
			
			editarTelefone(listaPessoas.get(e));
			
			System.out.print(" - CNPJ: ");
			
			Documento umNumero = new Cnpj();
			umNumero.numero = iu.sc.next();
			if(umNumero.validarDocumento()) {
				listaPessoas.get(e).documento.numero = umNumero.numero;				
			}
			
			System.out.print(" - Local de emissao do CNPJ: ");
			listaPessoas.get(e).documento.localDeEmissao = iu.sc.next();
			
			
			System.out.print("\n - Responsavel: ");
			System.out.print("\n  - Nome: ");
			listaPessoas.get(e).getPessoa().nome = iu.sc.next();
			
			editarTelefone(listaPessoas.get(e).getPessoa());
			
			System.out.print("  - CPF: ");
			
			Documento outroNumero = new Cpf();
			outroNumero.numero = iu.sc.next();
			if(outroNumero.validarDocumento()) {
				listaPessoas.get(e).getPessoa().documento.numero = outroNumero.numero;				
			}
			
			System.out.print("  - Local de emissao do CPF: ");
			listaPessoas.get(e).getPessoa().documento.localDeEmissao = iu.sc.next();
			
			mapPessoas.put(listaPessoas.get(e).nome, listaPessoas.get(e));
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");			
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	// BUSCAR UMA PESSOA
	public void buscarPessoa(String n) {
		int teste = 0;
		System.out.println(" __________________________________ ");
		 // Criar um conjunto de elementos-chave contidos no mapa
		for (String chave : mapPessoas.keySet()) {
			// O a recebe o 1 elemento do conjunto de chaves
			Pessoa a = mapPessoas.get(chave);
			// Se a palavra digitada contem nas chaves do map
			if(a.nome.contains(n)) {
				System.out.println("\n > Nome: "+mapPessoas.get(chave).nome);
				mapPessoas.get(chave).listarTelefones();
				System.out.println(" > CNPJ: "+mapPessoas.get(chave).documento.numero);
				System.out.println(" > Local de Emissao: "+mapPessoas.get(chave).documento.localDeEmissao);
				System.out.println(" > Tipo de Pessoa: "+mapPessoas.get(chave).tipoDePessoa());
				System.out.println(" > Responsavel: ");
				System.out.println(" + Nome: "+mapPessoas.get(chave).getPessoa().nome);
				mapPessoas.get(chave).getPessoa().listarTelefones();
				System.out.println(" + CPF: "+mapPessoas.get(chave).getPessoa().documento.numero);		
				System.out.println(" + Local de emissao da CPF: "+mapPessoas.get(chave).getPessoa().documento.localDeEmissao);					
				System.out.println(" + Tipo de Pessoa: "+mapPessoas.get(chave).getPessoa().tipoDePessoa());
				teste = 1;
				System.out.println(" __________________________________ ");
			}
		}
		if(teste != 1) {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
	}
	// LISTAR PESSOA
	public boolean listarPessoa() {
		if(verificarLista(listaPessoas)) {
			for(int i=0; i<listaPessoas.size(); i++) {
				System.out.println(" _____________ Pessoa "+(i+1)+" ___________ ");
				System.out.println("\n > Nome: "+listaPessoas.get(i).nome);
				listaPessoas.get(i).listarTelefones();
				System.out.println(" > CPF: "+listaPessoas.get(i).documento.numero);		
				System.out.println(" > Local de emissao da CPF: "+listaPessoas.get(i).documento.localDeEmissao);					
				System.out.println(" > Tipo de Pessoa: "+listaPessoas.get(i).tipoDePessoa());
				System.out.println(" > Responsavel: ");
				System.out.println(" + Nome: "+listaPessoas.get(i).getPessoa().nome);
				listaPessoas.get(i).getPessoa().listarTelefones();
				System.out.println(" + CPF: "+listaPessoas.get(i).getPessoa().documento.numero);		
				System.out.println(" + Local de emissao da CPF: "+listaPessoas.get(i).getPessoa().documento.localDeEmissao);					
				System.out.println(" + Tipo de Pessoa: "+listaPessoas.get(i).getPessoa().tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	// LISTAR PESSOAS REMOVIDAS
	public boolean listarPessoaRemovida() {
		if(verificarLista(pessoasRemovidas)) {
			for(int i=0; i<pessoasRemovidas.size(); i++) {
				System.out.println("\n _________ Pessoa Removida "+(i+1)+" ______ ");
				System.out.println("\n > Nome: "+pessoasRemovidas.get(i).nome);
				pessoasRemovidas.get(i).listarTelefones();
				System.out.println(" > CPF: "+pessoasRemovidas.get(i).documento.numero);		
				System.out.println(" > Local de emissao da CPF: "+pessoasRemovidas.get(i).documento.localDeEmissao);					
				System.out.println(" > Tipo de Pessoa: "+pessoasRemovidas.get(i).tipoDePessoa());
				System.out.println(" > Responsavel: ");
				System.out.println(" + Nome: "+pessoasRemovidas.get(i).getPessoa().nome);
				pessoasRemovidas.get(i).getPessoa().listarTelefones();
				System.out.println(" + CPF: "+pessoasRemovidas.get(i).getPessoa().documento.numero);		
				System.out.println(" + Local de emissao da CPF: "+pessoasRemovidas.get(i).getPessoa().documento.localDeEmissao);					
				System.out.println(" + Tipo de Pessoa: "+pessoasRemovidas.get(i).getPessoa().tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	// REMOVER PESSOA ESCOLHIDA
	public boolean removerPessoa(int e) {
		if(e >= 0 && e < listaPessoas.size()) {
			pessoasRemovidas.add(listaPessoas.get(e));			
			mapPessoas.remove(listaPessoas.get(e).nome);
			listaPessoas.remove(e);
			System.out.println("\n ---- Pessoa Removida com Exito --- ");	
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	// RESTAURAR PESSOA ESCOLHIDA
	public boolean restaurarPessoa(int e) {
		if(e >= 0 && e < pessoasRemovidas.size()) {
			listaPessoas.add(pessoasRemovidas.get(e));			
			mapPessoas.put(pessoasRemovidas.get(e).nome, pessoasRemovidas.get(e));
			pessoasRemovidas.remove(e);
			System.out.println("\n --- Pessoa Restaurada com Exito -- ");
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
		return false;
	}
	// VERIFICAR A LISTA SE TA VAZIA
	public boolean verificarLista(ArrayList<Pessoa> p) {
		if(p.size() != 0) {
			return true;
		}else {
			System.out.println(" ----------- Lista Vazia ---------- ");
			return false;
		}
	}
	// VERIFICAR SE O EXISTE ALGUM NOME NA LISTA DE PESSOAS SALVAS IGUAL AO NOME PASSADO
	public boolean verificarNome(PessoaJuridica p) {
		for(int i=0; i<listaPessoas.size(); i++) {
			if(listaPessoas.get(i).nome.equals(p.nome)) {
				System.out.println("\n -- Ja Existe Esse Nome na Lista -- ");
				return false;				
			}
		}
		return true;
	}
}
