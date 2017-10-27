package ecommerce.pos.facade;
import ecommerce.pos.models.Pedido;
import ecommerce.pos.models.Produto;
import ecommerce.pos.models.Pessoa;

//INTERFACE "IFACADE" COM TODOS OS MÉTODOS RESPONSÁVEIS PARA DESENVOLVER O FACADE
//DO PROJETO.
interface IFacade {
     // metodos de pessoa
    void cadastrar(Pessoa pessoa);
    void editar(Pessoa pessoa);
    void excluir(Pessoa pessoa);
    Pessoa buscarPessoa(Integer codigo);
    Pessoa buscarPessoaPorLoginSenha(String login, String senha);
    // metodos de produto
    Produto buscarProduto(Integer codigo);
    //metodos de pedido
    void cadastrar(Pedido pedido);
    void editar(Pedido pedido);
    void excluir(Pedido pedido);
}
