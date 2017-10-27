/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.models.interfaces;

import ecommerce.pos.models.Contato;
import ecommerce.pos.models.Endereco;

/**
 *
 * @author iago
 */
public interface IPessoa {
    
Contato getContato();                                                                                                                                                            
     
Endereco getEndereco();                                                                                                                                                      
                                                                                                                                                                                                    
String getLogin();                                                                                                                                                                    
                                                                                                                                                                                                    
void setLogin(String login);                                                                                                                                                    
                                                                                                                                                                                                    
String getSenha();                                                                                                                                                                  
                                                                                                                                                                                                    
void setSenha(String senha);                                                                                                                                               
                                                                                                                                                                                                    
void AdicionaContato(String telefone, String email);                                                                                                    

void AdicionaEndereco(String logradouro, String numero, String bairro, String cidade, String estado, String cep) ;

}
