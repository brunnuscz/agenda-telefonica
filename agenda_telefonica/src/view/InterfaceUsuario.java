package view;

import java.util.Scanner;

public class InterfaceUsuario {
	public Scanner sc = new Scanner(System.in);
	// METODO PARA PEGAR A OPCAO DO MENU
	public int pegarOpcao() {
		menuOpcao();
		System.out.print(" - Digite a opcao: ");
		int op = sc.nextInt();
		System.out.println();
		return op;
	}
	// MENU DE OPÇÕES
	public void menuOpcao() {
		System.out.println("\n=============== MENU ===============");
		System.out.println("=                                  =");
		System.out.println("=           1 - Listar             =");
		System.out.println("=           2 - Adicionar          =");
		System.out.println("=           3 - Remover            =");
		System.out.println("=           4 - Editar             =");
		System.out.println("=           5 - Lixeira            =");
		System.out.println("=           6 - Buscar             =");
		System.out.println("=           7 - Voltar             =");
		System.out.println("=                                  =");
		System.out.println("====================================\n");
	}
}
