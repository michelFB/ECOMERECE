package ecommerce.pos.negocio;
import ecommerce.pos.models.Pessoa;
import ecommerce.pos.models.PessoaFisica;
import ecommerce.pos.negocio.interfaces.INegocioPessoa;
import ecommerce.pos.repositorio.RepositorioPessoa;
import ecommerce.pos.repositorio.interfaces.IRepositorioPessoa;

public class NegocioPessoa extends NegocioGenerico<Pessoa> implements INegocioPessoa {
    // construtor da classe
    public NegocioPessoa() {
        super(new RepositorioPessoa());        
    }
    //Carrega um perfil de ADMINISTRADOR em tempo de execução em memória
    @Override
    public void inicializar() {
        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setNome("ADMINISTRADOR");
        pessoa.setLogin("1");
        pessoa.setSenha("1");

        pessoa.getEndereco().setCep("48907620");
        pessoa.getEndereco().setCidade("JUAZEIRO");
        pessoa.getEndereco().setEstado("BA");
        pessoa.getEndereco().setLogradouro("RUA 01");
        pessoa.getEndereco().setNumero("100");
        pessoa.getEndereco().setBairro("ALTO DA ALIANÇA");
        
        pessoa.AdicionaContato("(87) 98105-9987", "adm@gmail.com");
        pessoa.getContato().setEmail("adm@gmail.com");
        pessoa.getContato().setTelefone("(87) 98105-9987");
        
        inserir(pessoa);
    }
    @Override
    public Pessoa buscarPorLoginSenha(String login, String senha) {
        return ((IRepositorioPessoa)getRepositorio()).buscarPorLoginSenha(login, senha);
    }
    
}
