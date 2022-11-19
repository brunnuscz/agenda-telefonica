package model;

public class PessoaJuridica extends Pessoa{
	public Pessoa responsavel;

	@Override
	public String tipoDePessoa() {
		return "Pessoa Juridica";
	}
	@Override
	public void setPessoa(Pessoa r) {
		this.responsavel = r;
	}
   @Override
	public Pessoa getPessoa() {
		return responsavel;
	}
}
