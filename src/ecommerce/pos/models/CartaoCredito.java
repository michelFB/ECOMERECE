package ecommerce.pos.models;

import ecommerce.pos.enumerador.TipoBandeiraCartao;
import ecommerce.pos.models.interfaces.ICartaoCredito;

public class CartaoCredito extends FormaPagamento implements ICartaoCredito{ //SUB CLASSE "CARTAOCREDITO" RESPONSÁVEL POR CRIAR O PAGAMENTO POR CARTÃO DE CRÉDITO.
        //ENCAPSULAMENTO DOS ATRIBUTOS DO CARTÃO DE CRÉDITO
    	private TipoBandeiraCartao bandeira; //ENUMERADOR QUE DEFINE O TIPO DE BANDEIRA DO CARTÃO
	private String operacao;
	private int QtddVezes;
	private String titular;
	private String validade;
	private String numero;
	private String codigoSeguranca;
        private final float juros = 0.05f;
		
        //CONSTRUTOR QUE CRIA UMA OPERAÇÃO POR CARTÃO DE CRÉDITO
	public CartaoCredito(int codPagamento,TipoBandeiraCartao bandeira, String operacao, int qtddVezes, String titular, String validade, String numero,
			String codigoSeguranca){
		super(codPagamento); //CHAMA O CÓDIGO DE PAGAMENTO DA SUPERCLASSE
		this.bandeira = bandeira; //A BANDEIRA É CONSTRUIDA COM BASE NO ENUMERADOR
		this.operacao = operacao;
		this.QtddVezes = qtddVezes;
		this.titular = titular;
		this.validade = validade;
		this.numero = numero;
		this.codigoSeguranca = codigoSeguranca;
	}
        
        public CartaoCredito(int codPagamento,TipoBandeiraCartao bandeira){
		super(codPagamento); //CHAMA O CÓDIGO DE PAGAMENTO DA SUPERCLASSE
		this.bandeira = bandeira; //A BANDEIRA É CONSTRUIDA COM BASE NO ENUMERADOR						
	}
        
        // GETS E SETS DE "CARTAOCREDITO" 
	@Override
    public  TipoBandeiraCartao getBandeira() {
            return bandeira;
    }
    @Override
    public  void setBandeira(TipoBandeiraCartao bandeira) {
            this.bandeira = bandeira;
    }
    @Override
    public  String getoperacao() {
            return operacao;
    }
    @Override
    public  void setoperacao(String operacao) {
            this.operacao = operacao;
    }
    @Override
    public  int getQtddVezes() {
            return QtddVezes;
    }
    @Override
    public  void setQtddVezes(int qtddVezes) {
            QtddVezes = qtddVezes;
    }
    @Override
    public  String getTitular() {
            return titular;
    }
    @Override
    public  void setTitular(String titular) {
            this.titular = titular;
    }
    @Override
    public  String getValidade() {
            return validade;
    }
    @Override
    public  void setValidade(String validade) {
            this.validade = validade;
    }
    @Override
    public  String getNumero() {
            return numero;
    }
    @Override
    public  void setNumero(String numero) {
            this.numero = numero;
    }
    @Override
    public  String getcodigoSeguranca() {
            return codigoSeguranca;
    }
    @Override
    public  void setcodigoSeguranca(String codigoSeguranca) {
            this.codigoSeguranca = codigoSeguranca;
    }	
    
    @Override
    // reedefinição do método fecharPagamento
    public float fecharPagamento(Pedido pedido){
        float valorAPagar = pedido.calcularTotal() + (pedido.calcularTotal()*this.getJuros());
        return valorAPagar;
    }
    
    @Override   // SIMULACAO DE PARCELAMENTO DE CARTAO DE CREDITO PASSANDO UMA LISTA DE ARGUMENTOS VARIADOS
    public String simularParcelamento(float valor, int...parcelas){ 
        
        String s = "";
        
        for (int p : parcelas){
            if (p > 0)
                s += valor + " divido em " + p + "x = " + valor/p + "\n";
        }
        
        return s;
    }

    public String getOperacao() {
        return operacao;
    }

    public float getJuros() {
        return juros;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }
}
