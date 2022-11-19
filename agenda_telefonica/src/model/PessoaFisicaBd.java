package model;

import java.util.ArrayList;

public class PessoaFisicaBd extends BD{

	// ADICIONAR PESSOA FISICA
	@Override
	public boolean adicionarPessoa(Pessoa p) {
		if(verificarNome(p) && p.documento.validarDocumento()) {
			listaPessoas.add(p);
			mapPessoas.put(p.nome, p);
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");			
			return true;
		}else {
			return false;
		}
	}
	// EDITAR UM TELEFONE ESCOLHIDO DA LISTA
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
	// EDITAR PESSOA FISICA
	@Override
	public boolean editarPessoa(int e) {
		if(e >= 0 && e < listaPessoas.size()) {
			mapPessoas.remove(listaPessoas.get(e).nome);
			
			System.out.print("\n - Nome: ");
			listaPessoas.get(e).nome = iu.sc.next();
			
			editarTelefone(listaPessoas.get(e));
			
			System.out.print(" - CPF: ");
			
			Documento umNumero = new Cpf();
			umNumero.numero = iu.sc.next();
			if(umNumero.validarDocumento()) {
				listaPessoas.get(e).documento.numero = umNumero.numero;				
			}
			
			System.out.print(" - Local de emissao do CPF: ");
			listaPessoas.get(e).documento.localDeEmissao = iu.sc.next();
			
			mapPessoas.put(listaPessoas.get(e).nome, listaPessoas.get(e));
			
			System.out.println("\n ----- Pessoa Salva com Exito ----- ");			
			return true;
		}else {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
			return false;
		}
	}
	// BUSCAR POR UM CARACTERE OU PALAVRA, SE EXISTE NO MAP DE PESSOAS FISICAS
	@Override
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
				mapPessoas.get(chave).listarTelefones();;
				System.out.println(" > CPF: "+mapPessoas.get(chave).documento.numero);
				System.out.println(" > Local de Emissao: "+mapPessoas.get(chave).documento.localDeEmissao);
				System.out.println(" > Tipo de Pessoa: "+mapPessoas.get(chave).tipoDePessoa());
				teste = 1;
				System.out.println(" __________________________________ ");
			}
		}
		if(teste != 1) {
			System.out.println("\n ------ Pessoa Nao Encontrada ----- ");
		}
	}
	// LISTAR PESSOAS FISICAS
	@Override
	public boolean listarPessoa() {
		if(verificarLista(listaPessoas)) {
			for(int i=0; i<listaPessoas.size(); i++) {
				System.out.println(" _____________ Pessoa "+(i+1)+" ___________ ");
				System.out.println("\n > Nome: "+listaPessoas.get(i).nome);
				listaPessoas.get(i).listarTelefones();
				System.out.println(" > CPF: "+listaPessoas.get(i).documento.numero);		
				System.out.println(" > Local de emissao da CPF: "+listaPessoas.get(i).documento.localDeEmissao);					
				System.out.println(" > Tipo de Contato: "+listaPessoas.get(i).tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	// REMOVER PESSOA FISICA
	@Override
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
	// RESTAURAR DA LIXEIRA UMA PESSOA FISICA
	@Override
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
	// LISTAR PESSOAS QUE ESTÃO NA LIXEIRA
	@Override
	public boolean listarPessoaRemovida() {
		if(verificarLista(pessoasRemovidas)) {
			for(int i=0; i<pessoasRemovidas.size(); i++) {
				System.out.println("_________ Pessoa Removida "+(i+1)+" _______");
				System.out.println("\n > Nome: "+pessoasRemovidas.get(i).nome);
				pessoasRemovidas.get(i).listarTelefones();
				System.out.println(" > CPF: "+pessoasRemovidas.get(i).documento.numero);		
				System.out.println(" > Local de emissao da CPF: "+pessoasRemovidas.get(i).documento.localDeEmissao);					
				System.out.println(" > Tipo de Contato: "+pessoasRemovidas.get(i).tipoDePessoa());
			}
			System.out.println(" __________________________________ ");
			return true;
		}
		return false;
	}
	// VERIFICAR SE A LISTA PASSADA ESTÁ VAZIA
	@Override
	public boolean verificarLista(ArrayList<Pessoa> p) {
		if(p.size() != 0) {
			return true;
		}else {
			System.out.println(" ----------- Lista Vazia ---------- ");
			return false;
		}
	}
	// VERIFICAR SE O EXISTE ALGUM NOME NA LISTA DE PESSOAS SALVAS IGUAL AO NOME PASSADO
	@Override
	public boolean verificarNome(Pessoa p) {
		for(int i=0; i<listaPessoas.size(); i++) {
			if(listaPessoas.get(i).nome.equals(p.nome)) {
				System.out.println("\n -- Ja Existe Esse Nome na Lista -- ");
				return false;				
			}
		}
		return true;
	}
	
}
