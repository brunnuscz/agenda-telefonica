package model;
import java.util.ArrayList;

public abstract class Pessoa {
	public String nome;
	public ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	public Documento documento;
	
	public String tipoDePessoa() { return ""; }
	public void setPessoa(Pessoa r) { }
	public Pessoa getPessoa() {
		Pessoa p = null;
		return p;
	}
	public void listarTelefones() {
		for(int i=0; i< telefones.size(); i++) {
			System.out.println(" \t- Telefone "+(i+1)+": "+telefones.get(i).numero);
		}
	}
}