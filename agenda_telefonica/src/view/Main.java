package view;

import model.AgendaPessoaFisica;
import model.AgendaPessoaJuridica;

// CPF: 000.000.000-00
// CNPJ: 00.000.000/0000-00

public class Main {
	public static void main(String[] agrs) {
		AgendaPessoaFisica agendaPF = new AgendaPessoaFisica();
		AgendaPessoaJuridica agendaPJ = new AgendaPessoaJuridica();
		Agenda agenda = new Agenda();
		int opcaoEscolhida;
		do {
			opcaoEscolhida = agenda.escolherAgenda();
			
			if(opcaoEscolhida == 0) {
				agendaPF.escolherOperacao();
			}else if(opcaoEscolhida == 1){
				agendaPJ.escolherOperacao();
			}			
		}while(opcaoEscolhida != 2);

		System.out.println("\n ------------ Ate Logo ------------ ");
	}
}
