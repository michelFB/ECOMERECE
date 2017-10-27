/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.models.interfaces;

import ecommerce.pos.enumerador.GeneroProduto;

/**
 *
 * @author iago
 */
public interface IProduto {

GeneroProduto getTipo();                                                           
                                                                                                                                                                                                                    
void setTipo(GeneroProduto tipo);                                             
                                                                                                                                                                                                                    
String getDescricao();                                                                  
                                                                                                                                                                                                                    
void setDescricao(String descricao);                                         
                                                                                                                                                                                                                    
float getValorProduto();                                                               
                                                                                                                                                                                                                    
void setValorProduto(float valorProduto);                                 
                                                                                                                                                                                                                    
int getqtdProduto();                                                                      
                                                                                                                                                                                                                    
void setqtdProduto(int qtdProduto);                                           
                                                                                                                                                                                                                                                                                                                                                                                                                                        
void retirarProduto(int quantidade);                                            
                                                                                                                                                                                                                                                                                                                              
void adicionarProduto(int quantidade);
                                                                                                          
                                                                                                          

}
