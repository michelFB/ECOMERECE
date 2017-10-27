package ecommerce.pos.facade;
import ecommerce.pos.models.*;
import ecommerce.pos.models.Pessoa;
import ecommerce.pos.negocio.NegocioGenerico;
import ecommerce.pos.negocio.NegocioPessoa;
import ecommerce.pos.negocio.NegocioProduto;
import ecommerce.pos.negocio.interfaces.INegocioGenerico;
import ecommerce.pos.negocio.interfaces.INegocioPessoa;
import ecommerce.pos.negocio.interfaces.INegocioProduto;
import java.util.List;

public class Facade implements IFacade{      
    
    private final INegocioPessoa negocioPessoa;
    private final INegocioProduto negocioProduto;
    private final INegocioGenerico<FormaPagamento> negocioFormaPagamento;
    private final INegocioGenerico<Pedido> negocioPedido;
    //construtor da classe    
    public Facade() {
        negocioPessoa = new NegocioPessoa();
        negocioProduto = new NegocioProduto();
        negocioFormaPagamento = new NegocioGenerico<>();
        negocioPedido = new NegocioGenerico<>();
        negocioProduto.inicializar();
        negocioPessoa.inicializar();        
    }            
    
    public List<Produto> getProdutos(){
        return negocioProduto.listar();
    }
    
    @Override
    public Pessoa buscarPessoaPorLoginSenha(String login, String senha) {
        return negocioPessoa.buscarPorLoginSenha(login, senha);
    }
       
    @Override
    public void cadastrar(Pessoa pessoa) {        
        negocioPessoa.inserir(pessoa);                      
    }

    @Override
    public void editar(Pessoa pessoa) {
        negocioPessoa.alterar(pessoa);
    }

    @Override
    public void excluir(Pessoa pessoa) {
        negocioPessoa.excluir(pessoa);
    }

    @Override
    public Pessoa buscarPessoa(Integer codigo) {
        return negocioPessoa.buscar(codigo);
    }

    @Override
    public Produto buscarProduto(Integer codigo) {
        return negocioProduto.buscar(codigo);
    }

    @Override
    public void cadastrar(Pedido pedido) {
        negocioPedido.inserir(pedido);
    }

    @Override
    public void editar(Pedido pedido) {
        negocioPedido.alterar(pedido);
    }

    @Override
    public void excluir(Pedido pedido) {
        negocioPedido.excluir(pedido);
    }
    
    
}
