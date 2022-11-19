package model;

public class PessoaJuridica extends Pessoa{
	public PessoaFisica responsavel;

	@Override
	public String tipoDePessoa() {
		return "Pessoa Juridica";
	}
}
