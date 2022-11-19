package model;

public class Cpf extends Documento{
	
	@Override
	boolean verificarQuantidadeDeNumero() {
		if(super.numero.length() == 14) {
			return true;
		}else {
			System.out.println("\n ---------- Cpf Invalido ---------- \n");
			return false;			
		}
	}
}
