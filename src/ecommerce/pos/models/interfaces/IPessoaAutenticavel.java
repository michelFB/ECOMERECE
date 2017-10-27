package ecommerce.pos.models.interfaces;

public interface IPessoaAutenticavel {
        
    abstract boolean Autenticacao(String login, String senha);

}
