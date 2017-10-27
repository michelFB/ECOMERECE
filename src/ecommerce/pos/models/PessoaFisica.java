package ecommerce.pos.models;
import ecommerce.pos.models.interfaces.IPessoaAutenticavel;
import ecommerce.pos.models.interfaces.IPessoaFisica;

/* SUBCLASSE "PESSOAFISICA" NA QUAL HERDA DA CLASSE ABSTRATA "PESSOA" SUAS CARACTERISTICAS E IMPLEMENTA A INTERFACE "IPESSOAAUTENTICAVEL", RESPONSÁVEL PELO 
MÉTODO DE AUTENTICAÇÃO DE UM TIPO DE  PESSOA .*/
//HERANÇA DA SUPERCLASSE "PESSOA" E IMPLEMENTAÇÃO DA INTERFACE "IPESSOAAUNTENTICAVEL"
public class PessoaFisica extends Pessoa implements IPessoaAutenticavel, IPessoaFisica{// ATRIBUTOS PRIVADOS DE "PESSOAFISICA"
	private String nome;
	private String datanascimento;
	private String rg;
	private String cpf;
	
        //Construtor Vazio
        public PessoaFisica() {            
	}
        //CONSTRUTOR DE "PESSOAFISICA" COM SEUS ATRBUTOS E O ATRIBUTO CÓDIGO DA SUPERCLASSE "PESSOA"
	public PessoaFisica(int codigo, String nome, String datanascimento, String rg, String cpf) {
		super(codigo);	// Heranca da super classe pessoa
		this.nome = nome;
		this.datanascimento = datanascimento;
		this.rg = rg;
		this.cpf = cpf;
	} 
        // GETS E SETS PARA OS ATRIBUTOS DE "PESSOAFISICA" */
	@Override
public  String getNome() {
	return nome;
}
@Override
public  void setNome(String nome) {
	this.nome = nome;
}
@Override
public  String getDatanascimento() {
	return datanascimento;
}
@Override
public  void setDatanascimento(String datanascimento) {
	this.datanascimento = datanascimento;
}
@Override
public  String getRg() {
	return rg;
}
@Override
public  void setRg(String rg) {
	this.rg = rg;
}
@Override
public  String getCpf() {
	return cpf;
}
@Override
public  void setCpf(String cpf) {
	this.cpf = cpf;
}
         /*IMPLEMENTAÇÃO DA INTERFACE "IPESSOAAUTENTICAVEL" ESSA IMPLEMENTAÇÃO DO MÉTODO IRÁ CHECAR O LOGIN E SENHA
       DE UMA PESSOA FISICA ATRAVÉS DOS ARGUMENTOS PASSADOS NO MÉTODO "AUTENTICACAO" O RETORNO É  UM BOOLEANO.*/
        @Override
	public boolean Autenticacao(String login, String senha)  // Implementa��o de m�todo da interface
	{
		if(login != "clientePF" && senha != "1234"){
		return false;}
		return true;}
}
	

