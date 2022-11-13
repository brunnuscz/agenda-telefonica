package model;

public class PessoaJuridica extends Pessoa{
	public Cnpj cnpj;
	public PessoaFisica responsavel = new PessoaFisica();
	@Override
	public String tipoDeContato() {
		return "Pessoa Juridica";
	}
}
