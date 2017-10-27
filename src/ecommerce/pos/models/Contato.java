package ecommerce.pos.models;

import ecommerce.pos.models.interfaces.IContato;

/*CLASSE "CONTATO" SERÁ UTILIZADA PARA DEFINIR O CONTATO DE UMA PESSOA */
public class Contato implements IContato{
    
// ATRIBUTOS PRIVADOS DE "CONTATO"
    	private String telefone;
	private String email;	
	// Construtor chamado quando se instancia a classe Pessoa
	public Contato(){
        }
	// sobrecarga do construtor utilizado pelo metodo "adicionacontato" classe Pessoa 
	public Contato(String telefone, String email){
		this.telefone = telefone;
		this.email = email;	
	}
 //GETS E SETS PARA OS ATRIBUTOS DE "CONTATO" 
	@Override
        public  String getTelefone() {
                return telefone;
        }
        @Override
        public  void setTelefone(String telefone) {
                this.telefone = telefone;
        }
        @Override
        public  String getEmail() {
                return email;
        }
        @Override
        public  void setEmail(String email) {
                this.email = email;
        }   
}
