package model;

public class Cnpj extends Documento{
	@Override
	boolean verificarQuantidadeDeNumero() {
		if(super.numero.length() == 18) {
			return true;
		}else {
			System.out.println("\n ---------- Cnpj Invalido --------- \n");		
			return false;			
		}
	}
}
