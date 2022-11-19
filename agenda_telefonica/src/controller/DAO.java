package controller;

import model.Pessoa;
import view.InterfaceUsuario;

public interface DAO {
	public InterfaceUsuario iu = new InterfaceUsuario();
	
	void adicionar();
	void listar();
	void remover();
	void lixeira();
	void buscar();
	void editar();
	void adicionarTelefone(Pessoa p);
}
