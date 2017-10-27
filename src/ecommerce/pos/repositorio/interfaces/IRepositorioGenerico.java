package ecommerce.pos.repositorio.interfaces;
import ecommerce.pos.models.Entidade;
import java.util.List;


public interface IRepositorioGenerico<T extends Entidade> {
   
    void inserir(T t);
    void alterar(T t);
    void excluir(T t);
    T buscar(Integer codigo);
    List<T> listar();
    
}
