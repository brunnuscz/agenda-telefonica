package model;

public class PessoaFisica extends Pessoa{
	public Cpf cpf;
	
	@Override
	public String tipoDeContato() {
		return "Pessoa Fisica";
	}
	
}
