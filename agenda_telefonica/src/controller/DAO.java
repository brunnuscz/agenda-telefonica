package controller;

import view.InterfaceUsuario;

public interface DAO {
	InterfaceUsuario iu = new InterfaceUsuario();
	void adicionarPessoa();
	void listarPessoa();
}
