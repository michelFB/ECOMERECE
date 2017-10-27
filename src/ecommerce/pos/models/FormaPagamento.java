package ecommerce.pos.models;

// CLASSE "FORMAPAGAMENTO" RESPONSAVEL POR RECEBER A DATA DE PAGAMENTO E CONFIRMAR SE A COMPRA FOI AUTORIZADA.

import ecommerce.pos.models.interfaces.IFormaPagamento;

public class FormaPagamento extends Entidade implements IFormaPagamento{//ENCAPSULAMENTO DOS ATRIBUTOS DA CLASSE FORMA DE PAGAMENTO
    
    private String dataPagamento;        
    

    public FormaPagamento(Integer codigo) { //CONSTRUTOR PASSANDO O CÓDIGO DE PAGAMENTO
            super.setCodigo(codigo); //CHAMA O CONSTRUTOR DE ENTIDADE
    }   
    // GET E SET DE FORMAPAGAMENTO 
    @Override
    public  String getDataPagamento() {
        return dataPagamento;
    }
    @Override
    public  void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    //método será redefinido nas classes filhas com o comportamento especifico para cada operação
    public float fecharPagamento(Pedido pedido){        
        return pedido.calcularTotal();
    }
    
}
