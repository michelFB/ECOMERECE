package ecommerce.pos.vew;
import ecommerce.pos.enumerador.TipoBanco;
import ecommerce.pos.enumerador.TipoBandeiraCartao;
import ecommerce.pos.enumerador.TipoFormaPagamento;
import ecommerce.pos.facade.Facade;
import ecommerce.pos.models.Boleto;
import ecommerce.pos.models.CartaoCredito;
import ecommerce.pos.models.FormaPagamento;
import ecommerce.pos.models.ItemPedido;
import ecommerce.pos.models.Pedido;
import ecommerce.pos.models.Pessoa;
import ecommerce.pos.util.DataUtil;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FConfirmacao extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4957524281332397288L;
	private Facade fachada;
    private JFrame janelaPai;
    private Pedido pedido;
    private FormaPagamento formaPagamento;
    
    public FConfirmacao(JFrame janelaPai, Facade fachada, Pedido pedido) {
        this.pedido = pedido;
        this.janelaPai = janelaPai;
        this.fachada = fachada;
        initComponents();
        configurar();
    }
    
    private FormaPagamento formParaBoleto(){        
        return new Boleto(1, tfVencimento.getText(),tfCodBarras.getText(),(TipoBanco)cbBanco.getSelectedItem());
    }
    
    private FormaPagamento formParaCartao(){
        return new CartaoCredito(1, (TipoBandeiraCartao)cbBandeiraCartao.getSelectedItem(),
                tfOperacao.getText(), Integer.parseInt(tfQtdVezes.getText()), tfTitular.getText(), tfValidade.getText(),
                tfNumeroCartao.getText(), tfCodSeguranca.getText());        
    }
    
    /*private Float calcularTotal(){
        Float retorno = 0f;        
        for (ItemPedido ip : pedido.getListaItens()){
            retorno += (ip.getQtdItem() * ip.getProduto().getValorProduto());
        }        
        return retorno;
    }*/
    
    private void addProdutoNaTabela(ItemPedido item){
        DefaultTableModel model = (DefaultTableModel) tabelaItensPedido.getModel();
        model.addRow(new Object[]{item.getProduto().getCodigo(), item.getProduto().getDescricao(), item.getQtdItem(), item.getProduto().getValorProduto(), item.calcularTotal() });
    }
    
    private void preencheCbFormasPagamento(){        
        List<TipoFormaPagamento> lista = Arrays.asList(TipoFormaPagamento.values());
        for (TipoFormaPagamento t : lista) {
            cbFormaPagamento.addItem(t);
        }
    }
    
    private void preencheCbBandeiraCartao(){        
        List<TipoBandeiraCartao> lista = Arrays.asList(TipoBandeiraCartao.values());
        for (TipoBandeiraCartao t : lista) {
            cbBandeiraCartao.addItem(t);
        }
    }
    
    private void preencheCbBanco(){        
        List<TipoBanco> lista = Arrays.asList(TipoBanco.values());
        for (TipoBanco t : lista) {
            cbBanco.addItem(t);
        }
    }
    
    private Integer calcularQtdTotal(){
        Integer retorno = 0;        
        for (ItemPedido ip : pedido.getListaItens()){
            retorno += ip.getQtdItem();
        }        
        return retorno;
    }
    
    private void configurar(){
        //preenche tabela
        for (ItemPedido ip : pedido.getListaItens()) {
            addProdutoNaTabela(ip);
        }
        
        lbValorTotal.setText("" + pedido.calcularTotal());
        lbQtdTotal.setText("" + calcularQtdTotal());
        
        //preenche endereco        
        preencheEndereco(pedido.getCliente());
        
        // preenche formas de pagamento
        preencheCbFormasPagamento();
        
        // preenche bandeira cartao de credito
        preencheCbBandeiraCartao();
        
        // preenche bandeira cartao de credito
        preencheCbBanco();
                
        // boleto defualt
        configurarBoleto();
    }        
    
    private void configurarBoleto(){                
        
        Calendar data = Calendar.getInstance();
        data.add(Calendar.DAY_OF_MONTH, 4);                
        
        tfCodBarras.setText(gerarNumeroBoleto());
        tfVencimento.setText(DataUtil.formatar(data));
        
        formaPagamento = new Boleto(1, tfVencimento.getText(),tfCodBarras.getText(),(TipoBanco)cbBanco.getSelectedItem());
        tfValorPedidoDesconto.setText(""+formaPagamento.fecharPagamento(pedido));
    }
    
    private void configurarCartao(){
        formaPagamento = new CartaoCredito(1, (TipoBandeiraCartao)cbBandeiraCartao.getSelectedItem());                
        tfValorPedidoJuros.setText(""+formaPagamento.fecharPagamento(pedido));
    }
    
    private void preencheEndereco(Pessoa pessoa){
        tfUF.setText(pessoa.getEndereco().getEstado());
        tfBairro.setText(pessoa.getEndereco().getBairro());
        tfCidade.setText(pessoa.getEndereco().getCidade());
        tfLogradouro.setText(pessoa.getEndereco().getLogradouro());
        tfNumero.setText(pessoa.getEndereco().getNumero());
        tfCep.setText(pessoa.getEndereco().getCep());
    }
    
    private static String gerarNumeroBoleto(){
                
        String n = "";
        Random r = new Random();
        
        for (int i = 0; i < 20; i++) {            
            n += r.nextInt(10);
        }
        
        return n;
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItensPedido = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbQtdTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfUF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pPagamento = new javax.swing.JPanel();
        cbBandeiraCartao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        tfQtdVezes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfTitular = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfNumeroCartao = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfCodSeguranca = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfValidade = new javax.swing.JTextField();
        tfOperacao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        tfCodBarras = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfVencimento = new javax.swing.JTextField();
        cbBanco = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfValorPedidoDesconto = new javax.swing.JTextField();
        tfValorPedidoJuros = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cbFormaPagamento = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        tfCidade1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfCidade2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens do Pedido"));

        tabelaItensPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Qtd", "Valor Unitário", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaItensPedido);

        jLabel2.setText("Qtd. Itens:");

        lbQtdTotal.setText("0");

        jLabel10.setText("Valor Total: R$");

        lbValorTotal.setText("0,00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValorTotal)
                .addGap(160, 160, 160)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQtdTotal)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbQtdTotal)
                    .addComponent(jLabel10)
                    .addComponent(lbValorTotal)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço de Entrega"));

        jLabel4.setText("Logradouro:");

        jLabel6.setText("Cidade:");

        jLabel8.setText("UF:");

        tfUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUFActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero:");

        tfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroActionPerformed(evt);
            }
        });

        jLabel7.setText("Bairro:");

        jLabel17.setText("CEP:");

        tfCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLogradouro)
                    .addComponent(tfCidade)
                    .addComponent(tfBairro)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCep)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Concluir Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        cbBandeiraCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBandeiraCartaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Bandeira Cartão:");

        jLabel3.setText("Qtd. Vezes:");

        jLabel9.setText("Titular:");

        jLabel11.setText("Número:");

        jLabel13.setText("Cód. Segurança");

        jLabel14.setText("Validade:");

        jLabel15.setText("Operação:");

        jLabel16.setText("Cód. Barras:");

        jLabel18.setText("Data Venc.:");

        cbBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBancoActionPerformed(evt);
            }
        });

        jLabel19.setText("Banco:");

        jLabel22.setText("Vlr.Pedido + Desc.:");

        jLabel23.setText("Vlr.Pedido + Juros.:");

        javax.swing.GroupLayout pPagamentoLayout = new javax.swing.GroupLayout(pPagamento);
        pPagamento.setLayout(pPagamentoLayout);
        pPagamentoLayout.setHorizontalGroup(
            pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(pPagamentoLayout.createSequentialGroup()
                        .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPagamentoLayout.createSequentialGroup()
                                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pPagamentoLayout.createSequentialGroup()
                                        .addComponent(tfQtdVezes, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbBandeiraCartao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pPagamentoLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pPagamentoLayout.createSequentialGroup()
                                        .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pPagamentoLayout.createSequentialGroup()
                                                .addComponent(tfValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfCodSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tfNumeroCartao)))
                                    .addGroup(pPagamentoLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTitular))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPagamentoLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfValorPedidoJuros)
                                        .addGap(6, 6, 6))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPagamentoLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCodBarras))
                            .addGroup(pPagamentoLayout.createSequentialGroup()
                                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pPagamentoLayout.createSequentialGroup()
                                        .addComponent(tfVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfValorPedidoDesconto))
                                    .addComponent(cbBanco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        pPagamentoLayout.setVerticalGroup(
            pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPagamentoLayout.createSequentialGroup()
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBandeiraCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQtdVezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCodSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(tfValorPedidoJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(tfValorPedidoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(tfVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFormaPagamentoActionPerformed(evt);
            }
        });

        jLabel12.setText("Forma Pagamento:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jLabel20.setText("Telefone:");

        jLabel21.setText("E-mail:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCidade2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCidade1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tfCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tfCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 76, Short.MAX_VALUE))
                            .addComponent(pPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUFActionPerformed

    private void tfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroActionPerformed

    private void tfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepActionPerformed

    private void cbFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFormaPagamentoActionPerformed
        
        switch ((TipoFormaPagamento)cbFormaPagamento.getSelectedItem()) {
            case BOLETO:
                    configurarBoleto();
                break;                
        }        
    }//GEN-LAST:event_cbFormaPagamentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                        
        switch ((TipoFormaPagamento)cbFormaPagamento.getSelectedItem()) {
            case BOLETO:
                    formaPagamento = formParaBoleto();                                        
                break; 
                
            case CARTAO:
                    formaPagamento = formParaCartao();
                break;                
        }        
        
        pedido.setPagamento(formaPagamento);
        fachada.cadastrar(pedido);
        
        JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!");
        new FPedido(fachada, pedido.getCliente()).setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBancoActionPerformed

    private void cbBandeiraCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBandeiraCartaoActionPerformed
        configurarCartao();
    }//GEN-LAST:event_cbBandeiraCartaoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbBanco;
    private javax.swing.JComboBox cbBandeiraCartao;
    private javax.swing.JComboBox cbFormaPagamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbQtdTotal;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel pPagamento;
    private javax.swing.JTable tabelaItensPedido;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCidade1;
    private javax.swing.JTextField tfCidade2;
    private javax.swing.JTextField tfCodBarras;
    private javax.swing.JTextField tfCodSeguranca;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfNumeroCartao;
    private javax.swing.JTextField tfOperacao;
    private javax.swing.JTextField tfQtdVezes;
    private javax.swing.JTextField tfTitular;
    private javax.swing.JTextField tfUF;
    private javax.swing.JTextField tfValidade;
    private javax.swing.JTextField tfValorPedidoDesconto;
    private javax.swing.JTextField tfValorPedidoJuros;
    private javax.swing.JTextField tfVencimento;
    // End of variables declaration//GEN-END:variables
}
