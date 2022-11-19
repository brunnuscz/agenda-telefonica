package model;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BD {
	Map<String, Pessoa> mapPessoas = new LinkedHashMap<String, Pessoa>();
	// ADICIONAR PESSOA FISICA
	public boolean adicionarPessoa(PessoaFisica p) {
		return true;
	}
	// EDITAR PESSOA FISICA
	public boolean editarPessoa(int e) {
		return true;
	}
	// BUSCAR POR UM CARACTERE OU PALAVRA, SE EXISTE NO MAP DE PESSOAS FISICAS
	public void buscarPessoa(String n) {
		
	}
	// LISTAR PESSOAS FISICAS
	public boolean listarPessoa() {
		return true;
	}
	// REMOVER PESSOA FISICA
	public boolean removerPessoa(int e) {
		return true;
	}
	// RESTAURAR DA LIXEIRA UMA PESSOA FISICA
	public boolean restaurarPessoa(int e) {
		return true;
	}
	// LISTAR PESSOAS QUE ESTÃO NA LIXEIRA
	public boolean listarPessoaRemovida() {
		return true;
	}
}
