package br.edu.up.Models;

public class Transacao {
    private int pagador, recebedor;
    private double valor;
    private String message;

    public Transacao(int pagador, int recebedor, double value){
        this.setPagador(pagador);
        this.setRecebedor(recebedor);
        this.setValor(value);
    }
    
    public int getPagador() {
        return pagador;
    }

    public void setPagador(int pagador) {
        this.pagador = pagador;
    }

    public int getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(int recebedor) {
        this.recebedor = recebedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transação [pagador=" + pagador + ", recebedor=" + recebedor + ", valor=" + valor + "]\n" + message;
    }



    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
