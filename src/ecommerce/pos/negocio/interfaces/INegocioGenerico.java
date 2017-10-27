package ecommerce.pos.negocio.interfaces;
import ecommerce.pos.models.Entidade;
import java.util.List;

//Interface que obriga classes implementarem as assinaturas dos metos descritos
public interface INegocioGenerico<T extends Entidade> {  
    void inserir(T t);
    void alterar(T t);
    void excluir(T t);
    T buscar(Integer codigo);
    List<T> listar();
}
