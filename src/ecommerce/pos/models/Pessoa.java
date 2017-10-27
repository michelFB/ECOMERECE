package ecommerce.pos.models;

// CLASSE ABSTRATA "PESSOA" NA QUAL VAI SER UTILIZADA COMO HERANÇA PARA AS CLASSES "PESSOAFISICA" E "PESSOA JURIDICA".

import ecommerce.pos.models.interfaces.IPessoa;

public abstract class Pessoa extends Entidade implements IPessoa{ //classe abstrata não pode ser instanciada   
    private String login;
    private String senha;
    private Contato contato; 	// Agregacao de Contato  parte de  Todo Pessoa
    private Endereco endereco; 	// Agregado de Endereco  parte de do Todo Pessoa
// AGREGACAO NA CONSTRUÇÃO DO CONSTRTUTOR--> construtor da classe Pessoa, com os atributos de Entidade, Contato e Endereço
    public Pessoa(Integer codigo) {
        super.setCodigo(codigo); //chama construtor da superclasse entidade
        contato = new Contato();
        endereco = new Endereco();
    }
// AGREGACAO NA CONSTRUÇÃO DO CONSTRUTOR 2--> ONDE SERÁ CONSTRUIDO UMA PESSOA COM OS ATRIBUTOS DA CLASSE CONTATO E ENDERECO
    public Pessoa() {
        contato = new Contato();
        endereco = new Endereco();  
    }
// GETS E SETS PARA OS ATRIBUTOS DE "PESSOA"
    @Override
public  Contato getContato() {
            return contato;
    }
    @Override
public  Endereco getEndereco() {
            return endereco;
    }  
    @Override
public  String getLogin() {
        return login;
    }
    @Override
public  void setLogin(String login) {
        this.login = login;
    }
    @Override
public  String getSenha() {
        return senha;
    }
    @Override
public  void setSenha(String senha) {
        this.senha = senha;
    }     
//método para adiconar um novo contato a partir desta classe.
    @Override
public  void AdicionaContato(String telefone, String email){
            this.contato = new Contato(telefone,email);	// instanciando objeto Contato	
    }
//método para adiconar um novo Endereco a partir desta classe.
    @Override
public  void AdicionaEndereco(String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
            this.endereco = new Endereco(logradouro,numero,bairro,cidade,estado,cep); // Instanciando Objeto Endere?o
            } 
}
