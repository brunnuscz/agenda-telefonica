package model;

public class PessoaFisica extends Pessoa{
	@Override
	public String tipoDePessoa() {
		return "Pessoa Fisica";
	}
	@Override
	public void setPessoa(Pessoa p) {
		super.setPessoa(p);
	}
	@Override
	public Pessoa getPessoa() {
		return super.getPessoa();
	}
}
