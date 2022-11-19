package model;

public abstract class Documento {
	public String localDeEmissao;
	public String numero;
	
	public boolean validarDocumento() {
		return verificarQuantidadeDeNumero();
	}
	
	abstract boolean verificarQuantidadeDeNumero();
}
