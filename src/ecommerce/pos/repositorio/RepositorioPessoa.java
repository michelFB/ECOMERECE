package ecommerce.pos.repositorio;

import ecommerce.pos.models.Pessoa;
import ecommerce.pos.repositorio.interfaces.IRepositorioPessoa;
import java.util.List;


public class RepositorioPessoa extends RepositorioGenerico<Pessoa> implements IRepositorioPessoa{

    @Override
    public Pessoa buscarPorLoginSenha(String login, String senha) {
        
        List<Pessoa> listaPessoas = super.listar();
        
        for (Pessoa p : listaPessoas) {
            if (login.equals(p.getLogin()) && senha.equals(p.getSenha())) {
                return p;
            }
        }                
        
        return null;        
    }
    
}
