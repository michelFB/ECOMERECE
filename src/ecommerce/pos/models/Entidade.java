package ecommerce.pos.models;

// Classe responsavel por fornecer um codigo para as classes Pessoa, Pedido, FormaPagamento,Produto
public abstract class Entidade {
    
    private Integer codigo;
    
//gets e seteres do atributo codigo emcapsulado
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
}
