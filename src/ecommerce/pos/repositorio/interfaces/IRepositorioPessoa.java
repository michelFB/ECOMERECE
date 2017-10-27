package ecommerce.pos.repositorio.interfaces;
import ecommerce.pos.models.Pessoa;

public interface IRepositorioPessoa extends IRepositorioGenerico<Pessoa>{
    
    Pessoa buscarPorLoginSenha(String login, String senha);
    
}
