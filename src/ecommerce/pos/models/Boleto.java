package ecommerce.pos.models;

import ecommerce.pos.enumerador.TipoBanco;
import ecommerce.pos.models.interfaces.IBoleto;

//SUBCLASSE "BOLETO" RESPONSÁVEL POR CRIAR BOLETOS DE PAGAMENTO.
public class Boleto extends FormaPagamento implements IBoleto{
    
//ENCAPSULAMENTO DOS ATRIBUTOS DE BOLETO
	private String dataVencimento;
	private String Codigodebarras;
	private TipoBanco Banco;    //ENUMERADOR QUE DEFINE TIPO DE BANCO
        private final float taxadesconto = 0.1f; 
        
//CONSTRUTOR DA CLASSE	
	public Boleto(int codPagamento, String dataVencimento, String Codigodebarras, TipoBanco banco) {
		super(codPagamento); //CHAMA CONSTRUTOR DA SUPERCLASSE
		this.dataVencimento = dataVencimento;
		this.Codigodebarras = Codigodebarras;
		this.Banco = banco;
	}      
        
       // GETS E SETS DE "BOLETO"     
	@Override
        public String getDataVencimento() {
                return dataVencimento;
        }
        @Override
        public void setDataVencimento(String dataVencimento) {
                this.dataVencimento = dataVencimento;
        }
        @Override
        public String getNumero() {
                return Codigodebarras;
        }
        @Override
        public void setNumero(String Codigodebarras) {
                this.Codigodebarras = Codigodebarras;
        }
        @Override
        public TipoBanco getBanco() {
                return Banco;
        }
        @Override
        public void setBanco(TipoBanco banco) {
                Banco = banco;
        }
        
        @Override
         // reedefinição do método fecharPagamento
        public float fecharPagamento(Pedido pedido){
            float valorAPagar = pedido.calcularTotal() - (pedido.calcularTotal()*this.getTaxadesconto());
                return valorAPagar;
        }

    public float getTaxadesconto() {
        return taxadesconto;
    }

    public String getCodigodebarras() {
        return Codigodebarras;
    }
}
