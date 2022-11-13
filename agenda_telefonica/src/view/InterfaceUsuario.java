package view;

import java.util.Scanner;

public class InterfaceUsuario {
	public Scanner sc = new Scanner(System.in);
	// METODO PARA PEGAR A OPCAO DO MENU
	public int pegarOpcao() {
		menuOpcao();
		System.out.print("- Digite a opcao: ");
		int op = sc.nextInt();
		System.out.println();
		return op;
	}
	// MENU DE OPÇÕES
	public void menuOpcao() {
		System.out.println("\n=============== MENU ===============");
		System.out.println("=                                  =");
		System.out.println("=       1 - Listar Contatos        =");
		System.out.println("=      2 - Adicionar Contato       =");
		System.out.println("=       3 - Remover Contato        =");
		System.out.println("=       4 - Editar Contato         =");
		System.out.println("=          5 - Lixeira             =");
		System.out.println("=            6 - Sair              =");
		System.out.println("=                                  =");
		System.out.println("====================================\n");
	}
	
	public void imprimirInicio() {
		System.out.println("\n====================================");
		System.out.println("=         AGENDA TELEFONICA        =");
		System.out.println("====================================");
	}
}
