package ecommerce.pos.repositorio;
import ecommerce.pos.execoes.ExcecaoBuscar;
import ecommerce.pos.execoes.ExcecaoEdicao;
import ecommerce.pos.execoes.ExcecaoExcluir;
import ecommerce.pos.models.Entidade;
import ecommerce.pos.repositorio.interfaces.IRepositorioGenerico;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositorioGenerico<T extends Entidade> implements IRepositorioGenerico<T>{
    //atributo da classe
    private List<T> lista;
    //construtor da classe
    public RepositorioGenerico() {
        lista = new ArrayList<>();
    }   
    //implementação dos métods da interface IrepositorioGenerico
    @Override
    public void inserir(T t) {
        t.setCodigo(lista.size());
        lista.add(t);
    }

    @Override
    public void alterar(T t) {
        if (t != null && ((Entidade)t).getCodigo() != null){
            for (Iterator<T> it = lista.iterator(); it.hasNext();) {
                Entidade e = it.next();
                if (e.getCodigo().equals(e.getCodigo())) {
                    lista.set(lista.indexOf(t), t);
                }
            }
        }else{
            throw new ExcecaoEdicao();
        }
    }
    
    @Override
    public void excluir(T t){
        if (t != null && ((Entidade)t).getCodigo() != null) {
            for (Entidade e : lista) {
                if (e.getCodigo().equals(((Entidade)t).getCodigo())) {
                    lista.remove(lista.indexOf(t));
                }
            }
        }else{
            throw new ExcecaoExcluir();
        }
    }  

    @Override
    public T buscar(Integer codigo) {
        if (codigo != null) {
            for (T t : lista) {
                if (codigo == ((Entidade)t).getCodigo())
                    return t;                
            }
        }else{
            throw new ExcecaoBuscar();
        }
        
        return null;
    }

    @Override
    public List<T> listar() {
        return lista;
    }
    
}
