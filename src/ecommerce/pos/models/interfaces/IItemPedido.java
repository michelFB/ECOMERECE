/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.models.interfaces;

import ecommerce.pos.models.Produto;

/**
 *
 * @author iago
 */
public interface IItemPedido {
    
    Produto getProduto();                     
                                                            
                                                                                                                        
void setProduto(Produto produto);
                                                            
                                                            
                                                            
int getQtdItem();                              
                                                            
                                                            
                                                            
void setQtdItem(int qtdItem);         

}
