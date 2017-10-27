package ecommerce.pos.models;
import ecommerce.pos.execoes.ExcecaoMenorOuIgualZero;
import ecommerce.pos.models.interfaces.ICalculo;
import ecommerce.pos.models.interfaces.IItemPedido;

// CLASSE "ITEMPEDIDO" RESPONSÁVEL POR GERAR UMA LISTA DE PEDIDO  
public class ItemPedido  extends Entidade implements ICalculo, IItemPedido{ //IMPLEMENTA DUAS INTERFACES
    private Produto produto; //ATRIBUTO produto DO TIPO "PRODUTO" PARA RECEBER UM PRODUTO
    private int qtdItem;
    private float subtotal;

    // CONSTRUTOR DA LISTA DE PEDIDO CHAMA O CONSTRUTOR DA CLASSE "ENTIDADE"
    public ItemPedido(Integer codigo, Produto produto, int qtdItem) {
            
        if (qtdItem <= 0)
            throw new ExcecaoMenorOuIgualZero();    // EXCECAO
        else{
            super.setCodigo(codigo); //chama superclasse entidade		
            this.produto = produto;            
            this.qtdItem = qtdItem;
            produto.retirarProduto(qtdItem); /* AO SETAR UMA QUANTIDADE DE PRODUTOS NA CRIAÇÃO DO CONSTRUTOR , O ESTOQUE DE PRODUTOS É ATUALIZADO */
        }            
    }	
    //GETS E SETS PARA OS ATRIBUTOS DE "ITEMPRODUTO"
    @Override
    public  Produto getProduto() {
        return produto;
    }
    @Override
    public  void setProduto(Produto produto) {
        this.produto = produto;
    }
    @Override
    public  int getQtdItem() {
        return qtdItem;
    }
    @Override
    public  void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }
    /*IMPLEMENTAÇÃO DO MÉTODO "CALCULARTOTAL" DA INTERFACE "ICALCULO" O MÉTODO  CALCULA E RETORNA O SUBTOTAL DA COMPRA */
    @Override
    public float calcularTotal(){
            this.subtotal = produto.getValorProduto()*this.qtdItem;
            return subtotal;
    }
}
