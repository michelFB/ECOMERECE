package ecommerce.pos.negocio;
import ecommerce.pos.enumerador.GeneroProduto;
import ecommerce.pos.models.Produto;
import ecommerce.pos.negocio.interfaces.INegocioProduto;

public class NegocioProduto extends NegocioGenerico<Produto> implements INegocioProduto{
//Inicializa produtos em estoque em tempo de excução em memória
    @Override
    public void inicializar() {
        inserir(new Produto(10, "impressora",35, GeneroProduto.PERIFERICOS ,100));
        inserir(new Produto(11, "MicroSystem",550, GeneroProduto.COMPONETES,80));
        inserir(new Produto(12, "Antivírus",75, GeneroProduto.SEGURANCA,70));
        inserir(new Produto(13, "Windows 7",19, GeneroProduto.SISTEMA_OPERACIONAL,80));
        inserir(new Produto(14, "Mouse multilaser",25,GeneroProduto.PERIFERICOS,90));
    }
    
}
