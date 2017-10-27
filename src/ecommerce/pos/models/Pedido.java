package ecommerce.pos.models;

import ecommerce.pos.models.interfaces.ICalculo;
import ecommerce.pos.models.interfaces.IPedido;

/*CLASSE CONCRETA "PEDIDO" RESPONSAVÉL POR CRIAR UM PEDIDO DE VENDA,
TEM RELAÇÃO DE AGREGACAO COM "ITEMPEDIDO" E "FORMAPAGAMENTO" E COMPOSIÇÃO COM A CLASSE "PESSOA" */

public class Pedido extends Entidade implements ICalculo, IPedido{
    
    // Encapsulamento de todos os atributos;
    private Pessoa cliente;  //atribuição do tipo da classe "Pessoa"
    private ItemPedido itens[];	// vetor Utilizado para armazenar os produtos do pedido;
    private FormaPagamento pagamento;//atribuição do tipo da Classe "FormaPagamento"
    private float valorTotal;
    
    private int ultimoIndiceVetor;

    //Contrutor 1 
    public Pedido(Pessoa cliente, int qtd) {        
        itens = new ItemPedido[qtd];
        this.cliente = cliente;
        ultimoIndiceVetor = 0;
    }

    public Pedido() {
        ultimoIndiceVetor = 0;
    }
//GETS E SETS PARA OS ATRIBUTOS DE "PEDIDO"
    @Override
public  FormaPagamento getPagamento() {
    return pagamento;
}

@Override
public  void setPagamento(FormaPagamento pagamento) {
    this.pagamento = pagamento;
}

@Override
public  Pessoa getCliente() {
    return cliente;
}

@Override
public  void setCliente(Pessoa cliente) {
    this.cliente = cliente;
}

@Override
public  ItemPedido[] getListaItens() { //RETORNA A LISTA DE PEDIDOS
    return itens;
}

//MÉTODO QUE ADICIONA UMA "LISTA DE PEDIDOS" EM UMA POSIÇÃO DO VETOR
@Override
public  void AdicionandoItemLista(ItemPedido item) {                    
this.itens[ultimoIndiceVetor++] = item;
}


@Override
public  float getValorTotal() {
    return valorTotal;
}

@Override
public  void setValorTotal(float valorTotal) {
    this.valorTotal = valorTotal;
}

    
    /*IMPLEMENTAÇÃO DA INTERFACE "ICALCULO"
        O  MÉTODO DA INTERFACE ICALCULO IRÁ REALIZAR CALCULAR UM TOTAL GENERICO,
        NESTA IMPLEMENTAÇÃO SERÁ CALCULADO O SUBTOTAL DE TODOS OS PEDIDOS
       */
    @Override
    public float calcularTotal() {
            this.valorTotal = 0;
            for (int x=0;x<itens.length;x++){
            this.valorTotal = this.valorTotal + this.itens[x].calcularTotal();}
            return valorTotal;
    }
    


}
   