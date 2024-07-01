package br.edu.up.Models;

import java.util.ArrayList;

public class Carteira extends User {
    private double SaldoDebito = 0, SaldoCredito = 0, limiteCredito = 500;//Limite de crédito mínimo 500

    private ArrayList<Transacao> transacoes = new ArrayList<>();//histórico de transações

    //User sem saldo nenhum 
    public Carteira(int id, String name, String cpf) {
        super(id, name, cpf);
    }
    //User com algum saldo
    public Carteira(int id, String name, String cpf, double SaldoDebito) {
        super(id, name, cpf);
        this.setSaldoDebito(SaldoDebito);
    }

    @Override
    public double getSaldoCredito() {
        return SaldoCredito;
    }

    @Override
    public void setSaldoCredito(double saldoCredito) {
        SaldoCredito = saldoCredito;
    }
    
    @Override
    public void addToSaldoCredito(double addValue) {
        SaldoCredito += addValue;
    }
    
    @Override
    public void subToSaldoCredito(double addValue) {
        SaldoCredito -= addValue;
    }

    @Override
    public double getSaldoDebito() {
        return SaldoDebito;
    }

    @Override
    public void setSaldoDebito(double saldoDebito) {
        this.SaldoDebito = saldoDebito;
    }

    @Override
    public void addToSaldoDebito(double addValue) {
        this.SaldoDebito += addValue;
    }
    
    @Override
    public void subToSaldoDebito(double addValue) {
        this.SaldoDebito -= addValue;
    }

    @Override
    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void addToLimiteCredito(double limiteCredito) {
        this.limiteCredito += limiteCredito;
    }

    @Override
    public void subToLimiteCredito(double limiteCredito) {
        this.limiteCredito -= limiteCredito;
    }

    @Override
    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public String listTransacoes() {
        String message = "";
        for (Transacao transacao : this.transacoes) {
            message += transacao.toString()+"\n------------------o-----------------\n";
        }
        return message;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " Saldo: R$"+getSaldoDebito()+"| Crédito: "+(getLimiteCredito()+getSaldoCredito() + "| Limite de crédito: " + getLimiteCredito() + "| Pendência de crédito: " + getSaldoCredito());
    }

    

}