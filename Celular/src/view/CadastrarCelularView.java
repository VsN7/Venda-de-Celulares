/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.CelularController;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Celular;

/**
 *
 * @author renato
 */
public class CadastrarCelularView extends javax.swing.JInternalFrame {
    NumberFormat formatter = new DecimalFormat("#0.00");
    private CelularController cc;
    private static int index = 0;
    private static int id = 0;
    
    
    
    public CadastrarCelularView() throws Exception {
        cc = new CelularController();
        initComponents();
            if(cc.primeiroPasso() == 0){
            desativarButtonC();
        }else{
            
            exibirDados();    
        }
       
    }
    public CelularController getUc() {
        return cc;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        inputDescricao = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        inputMarca = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        buttonSalvar = new javax.swing.JButton();
        buttonInicioT2 = new javax.swing.JButton();
        buttonProximo2 = new javax.swing.JButton();
        buttonFinalT2 = new javax.swing.JButton();
        buttonAnterior2 = new javax.swing.JButton();
        inputModelo = new javax.swing.JTextField();
        inputValor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        inputId = new javax.swing.JTextField();
        buttonSelecionar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        inputQnt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        inputQnt1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        inputSerie = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###-###");
            inputSerie = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }

        setClosable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Cadastro de Celulares");

        jLabel12.setText("Descricao:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cc.conta.titulo}"), inputDescricao, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        inputDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDescricaoActionPerformed(evt);
            }
        });

        jLabel13.setText("Marca:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cc.conta.valor}"), inputMarca, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        inputMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMarcaActionPerformed(evt);
            }
        });

        jLabel16.setText("Linha:");

        buttonSalvar.setText("Novo");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonInicioT2.setText("|<");
        buttonInicioT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInicioTActionPerformed(evt);
            }
        });

        buttonProximo2.setText(">>");
        buttonProximo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProximoActionPerformed(evt);
            }
        });

        buttonFinalT2.setText(">|");
        buttonFinalT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFinalTActionPerformed(evt);
            }
        });

        buttonAnterior2.setText("<<");
        buttonAnterior2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnteriorActionPerformed(evt);
            }
        });

        inputModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputModeloActionPerformed(evt);
            }
        });

        jLabel17.setText("Valor:");

        jLabel18.setText("ID:");

        buttonSelecionar.setText("Selecionar");
        buttonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelecionarActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        jLabel19.setText("Série:");

        jLabel20.setText("Qntd. Reservada:");

        jLabel21.setText("Qntd.:");

        inputSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSerieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(inputId)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(10, 10, 10)
                                        .addComponent(inputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputModelo))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonInicioT2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonAnterior2))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonProximo2)
                                    .addComponent(buttonSelecionar))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonFinalT2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputQnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12)
                    .addComponent(inputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(inputModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(inputQnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(inputQnt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonProximo2)
                    .addComponent(buttonAnterior2)
                    .addComponent(buttonInicioT2)
                    .addComponent(buttonFinalT2))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSelecionar)
                    .addComponent(buttonEditar)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonExcluir))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        
        if(buttonEditar.getText().equals("salvar")){
        try {
                cc.atualizarCelular(Integer.parseInt(inputId.getText()),inputDescricao.getText(),inputMarca.getText(),inputModelo.getText(), Double.parseDouble(inputValor.getText()), inputSerie.getText(), Integer.parseInt(inputQnt.getText()));
                buttonEditar.setText("editar");
                ativarButton();
        } catch (Exception ex) {
                
            JOptionPane.showMessageDialog(rootPane, "Campos Invalidos", "Aviso", JOptionPane.ERROR_MESSAGE, null);
//        
        }
        }else{
            buttonEditar.setText("salvar");
            desativarButtonE();
        }
        
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed

        try {
            cc.removeCelular(Integer.parseInt(inputId.getText()));
            limparCampos();
            exibirDados();
            } catch (Exception ex) {
                    
                desativarButtonC();
            JOptionPane.showMessageDialog(rootPane, "Falha ao excluir", "Aviso", JOptionPane.ERROR_MESSAGE, null);
//        
        }
        
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelecionarActionPerformed
       
        if(buttonSelecionar.getText().equals("buscar")){
        try {
            Celular celular;
            int i = 0;
            int id = Integer.parseInt(inputId.getText());
            Iterator iterator = cc.getCelulares().iterator();
            do{
                if(id == cc.getCelulares().get(i).getId()){
                    index=i;
                }
                iterator.next();
                if(i<cc.getCelulares().size()-1)
                    i++;
                
            }while (iterator.hasNext());
            
            limparCampos();
            exibirDados();
            ativar();
            buttonSelecionar.setText("selecionar");
        } catch (Exception ex) {
            
                JOptionPane.showMessageDialog(null, "ID inexistente", "Erro", 0);
        }
        }else{
            buttonSelecionar.setText("buscar");
            desativar();
        }
        
    }//GEN-LAST:event_buttonSelecionarActionPerformed

    private void inputModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputModeloActionPerformed

    private void buttonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnteriorActionPerformed
        if(index > 0){
            anterior();
        }
        try {
            exibirDados();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarCelularView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAnteriorActionPerformed

    private void buttonFinalTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFinalTActionPerformed
        index = cc.getCelulares().size()-1;
        try {
            exibirDados();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarCelularView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonFinalTActionPerformed

    private void buttonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProximoActionPerformed

        if(index < cc.getCelulares().size()-1){
            posterior();
        }
        try {
            exibirDados();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarCelularView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonProximoActionPerformed

    private void buttonInicioTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicioTActionPerformed
        index = 0;
        try {
            exibirDados();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarCelularView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonInicioTActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        
        
        
        if(buttonSalvar.getText().equals("salvar")){
        try {
            if(cc.verificaSerie(inputSerie.getText()) == 1 && cc.verificaDescricao(inputDescricao.getText()) == 1){
                cc.novo(inputDescricao.getText(),inputMarca.getText(),inputModelo.getText(), Double.parseDouble(inputValor.getText()), inputSerie.getText(), Integer.parseInt(inputQnt.getText()),0);
                cc= new CelularController();
                index = cc.getCelulares().size()-1;
                exibirDados();
                buttonSalvar.setText("novo");
                ativarButton();
            }else{
                JOptionPane.showMessageDialog(null, "Celular ja cadastrado !!!", "Erro", 0);
            }
        } catch (Exception ex) {
                
            JOptionPane.showMessageDialog(rootPane, "Campos Invalidos", "Aviso", JOptionPane.ERROR_MESSAGE, null);
//        
        }
        }else{
            limparCampos();
            buttonSalvar.setText("salvar");
            desativarButtonC2();
        }
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void inputDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDescricaoActionPerformed

    }//GEN-LAST:event_inputDescricaoActionPerformed

    private void inputMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMarcaActionPerformed

    private void inputSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSerieActionPerformed

        try{ 
        javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###-###");
        inputSerie = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }
        
    }//GEN-LAST:event_inputSerieActionPerformed

    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnterior2;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonFinalT2;
    private javax.swing.JButton buttonInicioT2;
    private javax.swing.JButton buttonProximo2;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JButton buttonSelecionar;
    private javax.swing.JTextField inputDescricao;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputMarca;
    private javax.swing.JTextField inputModelo;
    private javax.swing.JTextField inputQnt;
    private javax.swing.JTextField inputQnt1;
    private javax.swing.JTextField inputSerie;
    private javax.swing.JTextField inputValor;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public int anterior(){
        return --index;
    }
    public int posterior(){
        return ++index;
    }
    
    public void exibirDados() throws Exception{
       limparCampos();
       cc= new CelularController();
       inputSerie.setText(cc.getCelulares().get(index).getSerie());
       String serie = inputSerie.getText();
       inputId.setText(""+cc.getId(serie));
       inputDescricao.setText(cc.getCelulares().get(index).getDescricao());
       inputMarca.setText(cc.getCelulares().get(index).getMarca());
       inputModelo.setText(cc.getCelulares().get(index).getModelo());
       inputValor.setText(""+cc.getCelulares().get(index).getValor());
       inputQnt.setText(""+cc.getCelulares().get(index).getQuantidade());
       inputQnt1.setText(""+cc.getCelulares().get(index).getQuantidadeReservada());
       inputQnt1.setEnabled(false);
       inputId.setEnabled(false);
       
   }
    
    public void limparCampos(){
        inputId.setText("");
        inputDescricao.setText("");
        inputMarca.setText("");
        inputModelo.setText("");
        inputValor.setText("");
        inputSerie.setText("");
        inputQnt.setText("");
        inputQnt1.setText("");
    }
    
    public void desativar(){
        inputId.setEnabled(true);
        buttonInicioT2.setEnabled(false);
        buttonFinalT2.setEnabled(false);
        buttonProximo2.setEnabled(false);
        buttonAnterior2.setEnabled(false);
        inputDescricao.setEnabled(false);
        inputMarca.setEnabled(false);
        inputModelo.setEnabled(false);
        inputValor.setEnabled(false);
        inputSerie.setEnabled(false);
        inputQnt.setEnabled(false);
        buttonSelecionar.setEnabled(true);
        buttonSalvar.setEnabled(false);
        buttonExcluir.setEnabled(false);
        buttonEditar.setEnabled(false);
    }
    public void ativar(){
        buttonInicioT2.setEnabled(true);
        buttonFinalT2.setEnabled(true);
        buttonProximo2.setEnabled(true);
        buttonAnterior2.setEnabled(true);
        inputId.setEnabled(false);
        inputDescricao.setEnabled(true);
        inputMarca.setEnabled(true);
        inputModelo.setEnabled(true);
        inputValor.setEnabled(true);
        inputSerie.setEnabled(true);
        inputQnt.setEnabled(true);
        buttonSelecionar.setEnabled(true);
        buttonSalvar.setEnabled(true);
        buttonExcluir.setEnabled(true);
        buttonEditar.setEnabled(true);
    }
    public void desativarButtonE(){
        buttonInicioT2.setEnabled(false);
        buttonFinalT2.setEnabled(false);
        buttonProximo2.setEnabled(false);
        buttonAnterior2.setEnabled(false);
        buttonSelecionar.setEnabled(false);
        buttonSalvar.setEnabled(false);
        buttonExcluir.setEnabled(false);
        buttonEditar.setEnabled(true);
    }
    public void desativarButtonC(){
        inputId.setEnabled(false);
        buttonInicioT2.setEnabled(false);
        buttonFinalT2.setEnabled(false);
        buttonProximo2.setEnabled(false);
        buttonAnterior2.setEnabled(false);
        inputDescricao.setEnabled(false);
        inputMarca.setEnabled(false);
        inputModelo.setEnabled(false);
        inputValor.setEnabled(false);
        inputSerie.setEnabled(false);
        inputQnt.setEnabled(false);
        inputQnt1.setEnabled(false);
        buttonSelecionar.setEnabled(false);
        buttonSalvar.setEnabled(true);
        buttonExcluir.setEnabled(false);
        buttonEditar.setEnabled(false);
    }
    
    
    public void desativarButtonC2(){
        inputId.setEnabled(false);
        buttonInicioT2.setEnabled(false);
        buttonFinalT2.setEnabled(false);
        buttonProximo2.setEnabled(false);
        buttonAnterior2.setEnabled(false);
        inputDescricao.setEnabled(true);
        inputMarca.setEnabled(true);
        inputModelo.setEnabled(true);
        inputValor.setEnabled(true);
        inputSerie.setEnabled(true);
        inputQnt.setEnabled(true);
        inputQnt1.setEnabled(false);
        buttonSelecionar.setEnabled(false);
        buttonSalvar.setEnabled(true);
        buttonExcluir.setEnabled(false);
        buttonEditar.setEnabled(false);
    }
    
    public void ativarButton(){
        buttonInicioT2.setEnabled(true);
        buttonFinalT2.setEnabled(true);
        buttonProximo2.setEnabled(true);
        buttonAnterior2.setEnabled(true);
        buttonSelecionar.setEnabled(true);
        buttonSalvar.setEnabled(true);
        buttonExcluir.setEnabled(true);
        buttonEditar.setEnabled(true);
    }
    
}
