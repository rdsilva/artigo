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
public class Estado {
    
    private String sigla;
    private int total;
    private double suporte;

    public Estado() {
        
    }
    
    public Estado(String sigla, int total, double suporte) {
        this.sigla = sigla;
        this.total = total;
        this.suporte = suporte;
    }
    
    public Estado(String sigla, int total) {
        this.sigla = sigla;
        this.total = total;
    }
    
    public Estado(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
