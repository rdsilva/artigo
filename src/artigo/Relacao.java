/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artigo;

/**
 *
 * @author Rodrigo
 */
public class Relacao {
    
    private Estado origem;
    private Estado destino;
    private int total;
    private double suporte;
    private double confianca; //confianca do estado A dentro da realação de A -> B

    public Relacao() {
    }

    public Relacao(Estado origem, Estado destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Relacao(Estado origem, Estado destino, int total) {
        this.origem = origem;
        this.destino = destino;
        this.total = total;
    }

    public Relacao(Estado origem, Estado destino, int total, double suporte) {
        this.origem = origem;
        this.destino = destino;
        this.total = total;
        this.suporte = suporte;
    }

    public Estado getOrigem() {
        return origem;
    }

    public void setOrigem(Estado origem) {
        this.origem = origem;
    }

    public Estado getDestino() {
        return destino;
    }

    public void setDestino(Estado destino) {
        this.destino = destino;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getSuporte() {
        return suporte;
    }

    public void setSuporte(double suporte) {
        this.suporte = suporte;
    }
    
    
    
}
