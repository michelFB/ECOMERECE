/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.models.interfaces;

/**
 *
 * @author iago
 */
public interface IPessoaFisica {
    
String getNome();                                                        
                                                                                        
void setNome(String nome);                                      
                                                                                        
String getDatanascimento();                                     
                                                                                        
void setDatanascimento(String datanascimento); 
                                                                                        
String getRg();                                                             
                                                                                        
void setRg(String rg);                                                  
                                                                                        
String getCpf();                                                            
                                                                                        
void setCpf(String cpf);                                               

}
