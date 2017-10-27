package ecommerce.pos.models;
import ecommerce.pos.models.interfaces.ICalculo;
import ecommerce.pos.enumerador.GeneroProduto;
import ecommerce.pos.models.interfaces.IProduto;

//CLASSE "PRODUTO" RESPONSÁVEL POR CRIAR UM PRODUTO E CONTROLAR A QUANTIDADE.
public class Produto extends Entidade implements ICalculo, IProduto {
    
    private String Descricao;
    private float valorProduto;
    private int qtdProduto;
    private GeneroProduto tipo; /* Enumerador "GENEROPRODUTO" {COMPONETES, PERIFERICOS, CONECTIVADE, SEGURANCA,AUTOMACAO, MULTIMIDIA, SISTEMA_OPERACIONAL }*/
 
    //CONSTRUTOR DE "PRODUTO" COM OS ATRIBUTOS NECESSARIOS PARA CONSTRUIR UM PRODUTO
    public Produto(Integer codigo, String descricao, float valorProduto, GeneroProduto tipo) { // construtor utilizado pela classe itemPedido
            super.setCodigo(codigo);
            this.Descricao = descricao;
            this.valorProduto = valorProduto;
            this.tipo = tipo;
    }
   /*CONSTRUTOR 2 DE "PRODUTO" COM OS ATRIBUTOS NECESSARIOS PARA CONSTRUIR UM PRODUTO ALÉM DE SETAR A QUANTIDADE EM ESTOQUE DO PRODUTO*/
   public Produto(Integer codigo, String descricao, float valorProduto, GeneroProduto tipo, int qtdProduto) { // construtor utilizado para uma inserção em estoque
            super.setCodigo(codigo);
            this.Descricao = descricao;
            this.valorProduto = valorProduto;
            this.tipo = tipo;
            this.qtdProduto = qtdProduto;
    }
	// gets e sets para os atributos de Produto	
        @Override
public  GeneroProduto getTipo() {
		return tipo;
	}
	@Override
public  void setTipo(GeneroProduto tipo) {
		this.tipo = tipo;
	}
        @Override
public  String getDescricao() {
                return Descricao;
        }
        @Override
public  void setDescricao(String descricao) {
                Descricao = descricao;
        }
        @Override
public  float getValorProduto() {
                return valorProduto;
        }
        @Override
public  void setValorProduto(float valorProduto) {
                this.valorProduto = valorProduto;
        }
        @Override
public  int getqtdProduto() {
                return qtdProduto;
        }
        @Override
public  void setqtdProduto(int qtdProduto) {
                this.qtdProduto = qtdProduto;
        }
        
        //método que retira um produto do estoque, e atualiza o estoque
        @Override
public  void retirarProduto(int quantidade){
                this.qtdProduto = this.qtdProduto - quantidade;
        }
        //método que adiciona uma quantidade ,atualizando o estoque.
        @Override
public  void adicionarProduto(int quantidade){
                this.qtdProduto = this.qtdProduto + quantidade;
        }
        // uso da interface ICalculo para calcular o valor total do estoque do produto
        @Override
        public float calcularTotal(){ 
                float valorTotal = this.getqtdProduto()*this.getValorProduto();
                return valorTotal;   
        }
}
