package view;

import model.Operacao;

public class Agenda {
	InterfaceUsuario iu = new InterfaceUsuario();
	
	public Operacao operacao = new Operacao();
	
	public void escolherOperacao() {
		int op;
		do {
			op = iu.pegarOpcao();
			switch (op) {
			case 1: {
				System.out.println("=========== LISTAR PESSOAS =========\n");
				operacao.operacaoListar();
				System.out.println("\n====================================");			
				break;
			}
			case 2: {
				System.out.println("====== ADICIONAR NOVA PESSOA =======\n");
				operacao.operacaoAdicionar();
				System.out.println("\n====================================");				
				break;
			}
			case 3: {
				System.out.println("========= REMOVER PESSOA ===========\n");
				operacao.operacaoRemover();
				System.out.println("\n====================================");				
				break;
			}
			case 4: {
				System.out.println("========== EDITAR PESSOA ===========\n");
				operacao.operacaoEditar();
				System.out.println("\n====================================");
				break;
			}
			case 5: {
				System.out.println("============== LIXEIRA =============\n");
				operacao.operacaoLixeira();
				System.out.println("\n====================================");
				break;
			}
			case 6: {
				System.out.println("============== BUSCAR ==============\n");
				operacao.operacaoBuscar();
				System.out.println("\n====================================");
				break;
			}
			case 7: {
				System.out.println(" -------- Saindo da Agenda -------- \n");
				break;
			}
			default:
				System.out.println(" --------- Opcao Invalida --------- ");
			}
			
		}while(op != 7);
	}
}
