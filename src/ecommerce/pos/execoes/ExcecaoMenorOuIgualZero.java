/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.execoes;

/**
 *
 * @author iago
 */
public class ExcecaoMenorOuIgualZero extends RuntimeException {
       
    public ExcecaoMenorOuIgualZero() {
        super("Erro! Quantidade não pode ser inferir ou igual a zero.");        
    }
    
}
