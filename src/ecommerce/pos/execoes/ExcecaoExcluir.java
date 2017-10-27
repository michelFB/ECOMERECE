package ecommerce.pos.execoes;

public class ExcecaoExcluir extends RuntimeException {

    public ExcecaoExcluir() {
        super("Não foi possível excluir esse objeto, o mesmo está sem código. Tente novamente!");
    }
        
}
