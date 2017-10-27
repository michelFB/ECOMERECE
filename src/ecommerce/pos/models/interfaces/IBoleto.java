/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.models.interfaces;

import ecommerce.pos.enumerador.TipoBanco;

/**
 *
 * @author iago
 */
public interface IBoleto {
 
    String getDataVencimento() ;
    void setDataVencimento(String dataVencimento) ;
    String getNumero() ;
    void setNumero(String Codigodebarras) ;
    TipoBanco getBanco() ;
    void setBanco(TipoBanco banco) ;
    
}
