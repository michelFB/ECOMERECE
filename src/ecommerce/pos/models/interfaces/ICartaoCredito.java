/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.models.interfaces;

import ecommerce.pos.enumerador.TipoBandeiraCartao;

/**
 *
 * @author iago
 */
public interface ICartaoCredito {
    
     TipoBandeiraCartao getBandeira() ;

    void setBandeira(TipoBandeiraCartao bandeira) ;

    String getoperacao() ;

    void setoperacao(String operacao) ;

    int getQtddVezes() ;

    void setQtddVezes(int qtddVezes) ;

    String getTitular() ;

    void setTitular(String titular) ;

    String getValidade() ;

    void setValidade(String validade) ;

    String getNumero() ;

    void setNumero(String numero) ;

    String getcodigoSeguranca() ;

    void setcodigoSeguranca(String codigoSeguranca) ;

    String simularParcelamento(float valor, int...parcelas);


}
