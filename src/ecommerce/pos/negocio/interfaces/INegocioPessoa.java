/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.pos.negocio.interfaces;

import ecommerce.pos.models.Pessoa;

/**
 *
 * @author iago
 */
public interface INegocioPessoa extends INegocioGenerico<Pessoa>{
    
    void inicializar();
    Pessoa buscarPorLoginSenha(String login, String senha);
}
