package ecommerce.pos.vew;

import ecommerce.pos.facade.Facade;
import ecommerce.pos.models.Pessoa;
import ecommerce.pos.models.PessoaFisica;
import ecommerce.pos.models.PessoaJuridica;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

public class FLogin extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 161538903518304287L;
	private Pessoa pessoa;
    private String login;
    private String senha;
    private Facade fachada;
    
    // Construtor
    public FLogin() {        
        initComponents();
        configurar();
    }
    //métodos
    private void configurar(){        
        fachada = new Facade();
    }
    private void formParaObjeto(){        
        login = tfLogin.getText();
        senha = tfSenha.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfSenha = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        btLogin.setText("Entrar");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btRegistrar.setText("Registrar");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        
        lblNewLabel = new JLabel("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(tfLogin, 234, 234, 234)
        						.addComponent(tfSenha, 234, 234, 234)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btRegistrar)
        							.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
        							.addComponent(btLogin))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel1)
        								.addComponent(jLabel2))
        							.addGap(0, 204, Short.MAX_VALUE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(80)
        					.addComponent(lblNewLabel)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(41)
        			.addComponent(lblNewLabel)
        			.addGap(38)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btLogin)
        				.addComponent(btRegistrar))
        			.addContainerGap(23, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Ações
    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        new FCadastro(this, fachada).setVisible(true);
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        
        formParaObjeto();
        pessoa = fachada.buscarPessoaPorLoginSenha(login,senha);
        
        String msg;                    
        if (pessoa != null){
            msg = "Bem Vindo, ";
            if (pessoa instanceof PessoaFisica)
                msg += ((PessoaFisica)pessoa).getNome() + "!";
            else
                msg += ((PessoaJuridica)pessoa).getNomefantasia() + "!";
            
            JOptionPane.showMessageDialog(this, msg);
            new FPedido(fachada, pessoa).setVisible(true);
            setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Login ou senha invÃ¡lidos!");
        }                        
    }//GEN-LAST:event_btLoginActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfSenha;
    private JLabel lblNewLabel;
    // End of variables declaration//GEN-END:variables
}
