package controller;

import view.InterfaceUsuario;

public interface DAO {
	public InterfaceUsuario iu = new InterfaceUsuario();
	
	void adicionar();
	void listar();
	void remover();
	void lixeira();
	void buscar();
	void editar();
}
