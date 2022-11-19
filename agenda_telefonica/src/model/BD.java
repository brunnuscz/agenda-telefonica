package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import view.InterfaceUsuario;

public abstract class BD {
	Map<String, Pessoa> mapPessoas = new LinkedHashMap<String, Pessoa>();
	ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	ArrayList<Pessoa> pessoasRemovidas = new ArrayList<Pessoa>();
	InterfaceUsuario iu = new InterfaceUsuario();
	
	public boolean adicionarPessoa(Pessoa p) { return true; }
	public boolean editarPessoa(int e) { return true; }
	public boolean listarPessoa() {	return true;}
	public boolean removerPessoa(int e) { return true; }
	public boolean restaurarPessoa(int e) { return true; }
	public boolean listarPessoaRemovida() {	return true; }
	public boolean verificarLista(ArrayList<Pessoa> p) { return true; }
	public boolean verificarNome(Pessoa p) { return true; }
	public void buscarPessoa(String n) { }
	public void editarTelefone(Pessoa p) { }
}
