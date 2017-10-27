/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.models.interfaces;

import ecommerce.pos.models.FormaPagamento;
import ecommerce.pos.models.ItemPedido;
import ecommerce.pos.models.Pessoa;

/**
 *
 * @author iago
 */
public interface IPedido {
    
FormaPagamento getPagamento();                                                                  
                                                                                                                                  
void setPagamento(FormaPagamento pagamento);                                      
                                                                                                                                  
Pessoa getCliente();                                                                                             
                                                                                                                                  
void setCliente(Pessoa cliente);                                                                         
                                                                                                                                  
ItemPedido[] getListaItens(); 
                                                                                                                                  
void AdicionandoItemLista(ItemPedido item);                                                  
                                                                                                                                  
                                                                                                                                  
float getValorTotal();                                                                                            
                                                                                                                                  
void setValorTotal(float valorTotal);                                                                    

}
