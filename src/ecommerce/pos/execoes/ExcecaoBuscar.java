package ecommerce.pos.execoes;

import ecommerce.pos.excecoes.interfaces.IExcecao;

public class ExcecaoBuscar extends RuntimeException {

    public ExcecaoBuscar() {
        super("Impossível buscar um objeto sem código!");
    }        
    
}
