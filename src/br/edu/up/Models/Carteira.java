package br.edu.up.Models;

public class Carteira extends User {
    private double SaldoDebito = 0, SaldoCredito = 0, limiteCredito = 500;//Limite de crédito mínimo 500
    
    //User sem saldo nenhum 
    public Carteira(int id, String name, String cpf) {
        super(id, name, cpf);
    }
    public Carteira(int id, String name, String cpf, double SaldoDebito) {
        super(id, name, cpf);
        this.setSaldoDebito(SaldoDebito);
    }

    public double getSaldoCredito() {
        return SaldoCredito;
    }

    public void setSaldoCredito(double saldoCredito) {
        SaldoCredito = saldoCredito;
    }
    
    public void addToSaldoCredito(double addValue) {
        SaldoCredito += addValue;
    }



    public double getSaldoDebito() {
        return SaldoDebito;
    }

    public void setSaldoDebito(double saldoDebito) {
        SaldoDebito = saldoDebito;
    }
    public void addToSaldoDebito(double addValue) {
        SaldoDebito += addValue;
    }



    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void addToLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " Saldo: R$"+getSaldoDebito()+"| Crédito: "+(getLimiteCredito()-getSaldoCredito());
    }

}