package model;

import controller.DAO;
import controller.PessoaJuridicaDAO;
import view.Agenda;

public class AgendaPessoaJuridica extends Agenda {
	public DAO pJDAO = new PessoaJuridicaDAO();
	@Override
	public void escolherOperacao() {
		int op;
		do {
			op = iu.pegarOpcao();
			switch (op) {
			case 1: {
				System.out.println("=========== LISTAR PESSOAS =========\n");
				pJDAO.listar();
				System.out.println("\n====================================");			
				break;
			}
			case 2: {
				System.out.println("====== ADICIONAR NOVA PESSOA =======");
				pJDAO.adicionar();
				System.out.println("\n====================================");				
				break;
			}
			case 3: {
				System.out.println("========= REMOVER PESSOA ===========\n");
				pJDAO.remover();
				System.out.println("\n====================================");				
				break;
			}
			case 4: {
				System.out.println("========== EDITAR PESSOA ===========\n");
				pJDAO.editar();
				System.out.println("\n====================================");
				break;
			}
			case 5: {
				System.out.println("============== LIXEIRA =============\n");
				pJDAO.lixeira();
				System.out.println("\n====================================");
				break;
			}
			case 6: {
				System.out.println("============== BUSCAR ==============");
				pJDAO.buscar();
				System.out.println("\n====================================");
				break;
			}
			case 7: {
				System.out.println(" --- Saindo de Agenda Juridica ---- ");
				break;
			}
			default:
				System.out.println(" --------- Opcao Invalida --------- ");
			}
			
		}while(op != 7);
	}
}
