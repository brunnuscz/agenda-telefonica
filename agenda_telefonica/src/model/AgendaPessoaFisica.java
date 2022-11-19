package model;

import controller.DAO;
import controller.PessoaFisicaDAO;
import view.Agenda;

public class AgendaPessoaFisica extends Agenda{
	public DAO pFDAO = new PessoaFisicaDAO();
	@Override
	public void escolherOperacao() {
		int op;
		do {
			op = iu.pegarOpcao();
			switch (op) {
			case 1: {
				System.out.println("=========== LISTAR PESSOAS =========\n");
				pFDAO.listar();
				System.out.println("\n====================================");			
				break;
			}
			case 2: {
				System.out.println("====== ADICIONAR NOVA PESSOA =======");
				pFDAO.adicionar();
				System.out.println("\n====================================");				
				break;
			}
			case 3: {
				System.out.println("========= REMOVER PESSOA ===========\n");
				pFDAO.remover();
				System.out.println("\n====================================");				
				break;
			}
			case 4: {
				System.out.println("========== EDITAR PESSOA ===========\n");
				pFDAO.editar();
				System.out.println("\n====================================");
				break;
			}
			case 5: {
				System.out.println("============== LIXEIRA =============\n");
				pFDAO.lixeira();
				System.out.println("\n====================================");
				break;
			}
			case 6: {
				System.out.println("============== BUSCAR ==============");
				pFDAO.buscar();
				System.out.println("\n====================================");
				break;
			}
			case 7: {
				System.out.println(" ----- Saindo de Agenda Fisica ---- ");
				break;
			}
			default:
				System.out.println(" --------- Opcao Invalida --------- ");
			}
			
		}while(op != 7);
	}
}
