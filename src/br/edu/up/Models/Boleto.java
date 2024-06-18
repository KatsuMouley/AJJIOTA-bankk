package br.edu.up.Models;

import java.time.LocalDate;

public class Boleto extends Carteira{
    private String numero;
    private double valor;
    private LocalDate dataVencimento;
    private boolean pago;

    

    public Boleto(String numero, double valor, LocalDate dataVencimento, boolean pago, double debito, double credito, String nome, String cpf, int id, String senha, String email) {
        super(nome, cpf, email, senha, id);
        this.numero = numero;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
}
