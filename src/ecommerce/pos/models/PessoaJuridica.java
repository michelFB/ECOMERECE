package ecommerce.pos.models;
import ecommerce.pos.models.interfaces.IPessoaAutenticavel;
import ecommerce.pos.models.interfaces.IPessoaJuridica;

/* SUBCLASSE "PESSOAJURIDICA" NA QUAL HERDA DA CLASSE ABSTRATA "PESSOA" SUAS 
CARACTERISTICAS E IMPLEMENTA A INTERFACE "IPESSOAAUTENTICAVEL", RESPONSÁVEL PELO 
MÉTODO DE AUTENTICAÇÃO DE UM TIPO DE  PESSOA. */
//HERANÇA DA SUPERCLASSE "PESSOA" E IMPLEMNETAÇÃO DE UMA INTERFACE
public class PessoaJuridica extends Pessoa implements IPessoaAutenticavel, IPessoaJuridica {
    // ATRIBUTOS PRIVADOS DE "PESSOAJURIDICA"
    private String razaosocial;
    private String nomefantasia;
    private String cnpj;
    //CONSTRUTOR DE "PESSOAJURIDICA" COM SEUS ATRIBUTOS E O ATRIBUTO CÓDIGO DA SUPERCLASSE "PESSOA"
    public PessoaJuridica(int codigo, String razaosocial, String nomefantasia, String cnpj) {
            super(codigo); // Herança do construtor da superclase Pessoa
            this.razaosocial = razaosocial;
            this.nomefantasia = nomefantasia;
            this.cnpj = cnpj;
    }
    //CONSTRUTOR VAZIO
    public PessoaJuridica() {
    }
     // GETS E SETS PARA OS ATRIBUTOS DE "PESSOAFISICA"
    @Override
public  String getRazaosocial() {
return razaosocial;
}
@Override
public  void setRazaosocial(String razaosocial) {
this.razaosocial = razaosocial;
}
@Override
public  String getNomefantasia() {
return nomefantasia;
}
@Override
public  void setNomefantasia(String nomefantasia) {
this.nomefantasia = nomefantasia;
}
@Override
public  String getCnpj() {
return cnpj;
}
@Override
public  void setCnpj(String cnpj) {
this.cnpj = cnpj;
}
    /*IMPLEMENTAÇÃO DA INTERFACE "IPESSOAAUTENTICAVEL" ESSA IMPLEMENTAÇÃO DO MÉTODO  IRÁ CHECAR O LOGIN E SENHA
       DE UMA PESSOA FISICA ATRAVÉS DOS ARGUMENTOS PASSADOS NO MÉTODO "AUTENTICACAO" O RETORNO É  UM BOOLEANO.*/
    public boolean Autenticacao(String login, String senha) 
    {
        return login == "clientePJ" && senha == "1234";            
    }
}