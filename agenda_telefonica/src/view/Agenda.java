package view;

public class Agenda {
	public InterfaceUsuario iu = new InterfaceUsuario();
	
	public void escolherOperacao() { }
	
	public int escolherAgenda() {
		int op;
		do {
			System.out.println("\n ------- AGENDA DE PESSOAS -------- ");
			System.out.println(" :   (0) - Agenda Pessoa Fisica   :   ");
			System.out.println(" :  (1) - Agenda Pessoa Juridica  :   ");
			System.out.println(" :          (2) - Sair            :   ");
			System.out.println(" ---------------------------------- \n");
			System.out.print(" - Escolha: ");
			op = iu.sc.nextInt();
			if(op < 0 || op > 2) {
				System.out.println("\n --------- Opcao Invalida --------- ");
			}			
		}while(op < 0 && op > 2);
		
		return op;
	}
}
