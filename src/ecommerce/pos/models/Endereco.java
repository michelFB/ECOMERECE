package ecommerce.pos.models;

import ecommerce.pos.models.interfaces.IEndereco;

/*CLASSE "ENDERECO" SERÁ UTULIZADA PARA DEFINIR O ENDERECO DE UMA PESSOA*/

public class Endereco implements IEndereco { // ATRIBUTOS PRIVADOS DE "ENDERECO"
private String logradouro;
private String numero;
private String bairro;
private String cidade;
private String estado;
private String cep;
// Construtor chamado quando se instancia a classe Pessoa
public Endereco() {}
// SOBRECARGA DO CONSTRUTOR DE "ENDERECO" QUE É UTILIZADO PELO MÉTODO "ADICIONAENDERECO" NA CLASSE "PESSOA"  
public Endereco(String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
	this.logradouro = logradouro;
	this.numero = numero;
	this.bairro = bairro;
	this.cidade = cidade;
	this.estado = estado;
	this.cep = cep;
}
// GETS E SETS PARA OS ATRIBUTOS DE "ENDERECO"
@Override
public  String getLogradouro() {
	return logradouro;
}
@Override
public  void setLogradouro(String logradouro) {
	this.logradouro = logradouro;
}
@Override
public  String getNumero() {
	return numero;
}
@Override
public  void setNumero(String numero) {
	this.numero = numero;
}
@Override
public  String getBairro() {
	return bairro;
}
@Override
public  void setBairro(String bairro) {
	this.bairro = bairro;
}
@Override
public  String getCidade() {
	return cidade;
}
@Override
public  void setCidade(String cidade) {
	this.cidade = cidade;
}
@Override
public  String getEstado() {
	return estado;
}
@Override
public  void setEstado(String estado) {
	this.estado = estado;
}
@Override
public  String getCep() {
	return cep;
}
@Override
public  void setCep(String cep) {
	this.cep = cep;
}
}
