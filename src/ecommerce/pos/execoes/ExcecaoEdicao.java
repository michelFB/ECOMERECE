package ecommerce.pos.execoes;

public class ExcecaoEdicao extends RuntimeException {

    public ExcecaoEdicao() {
        super("Não é possível Editar um objeto sem código, Tente novamente!");
    }    
}
