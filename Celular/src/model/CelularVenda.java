
package model;

/**
 *
 * @author Vitor
 */
public class CelularVenda {
    
    private int id;
    private String descricao;
    private int quantidade_vendida;
    private double valor;
    private int id_venda;
    private int id_celular;
    private int quantidade_vendida_registro;

    public int getQuantidade_vendida_registro() {
        return quantidade_vendida_registro;
    }

    public void setQuantidade_vendida_registro(int quantidade_vendida_registro) {
        this.quantidade_vendida_registro = quantidade_vendida_registro;
    }
    public int getId_celular() {
        return id_celular;
    }

    public void setId_celular(int id_celular) {
        this.id_celular = id_celular;
    }

    public CelularVenda(int id, String descricao, int quantidade_vendida, double valor, int id_venda, int quantidade_vendida_registro) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade_vendida = quantidade_vendida;
        this.valor = valor;
        this.id_venda = id_venda;
        this.quantidade_vendida_registro=quantidade_vendida_registro;
    }
    
    public CelularVenda(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade_vendida() {
        return quantidade_vendida;
    }

    public void setQuantidade_vendida(int quantidade_vendida) {
        this.quantidade_vendida = quantidade_vendida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }
    
}
