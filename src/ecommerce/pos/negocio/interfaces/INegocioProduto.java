package ecommerce.pos.negocio.interfaces;

import ecommerce.pos.models.Produto;

public interface INegocioProduto extends INegocioGenerico<Produto> {
    
    void inicializar();
}
