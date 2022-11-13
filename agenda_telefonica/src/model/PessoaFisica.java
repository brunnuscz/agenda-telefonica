package model;

public class PessoaFisica extends Pessoa{
	public Cpf cpf;
	
	@Override
	public String tipoDePessoa() {
		return "Pessoa Fisica";
	}
}
