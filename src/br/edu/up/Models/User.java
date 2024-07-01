package br.edu.up.Models;

import java.util.ArrayList;

public abstract class User  {
    private int id;
    private String name, cpf;

    public User(int id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "User |" + id + " |" + name + " |" + cpf + " |";
    }

    public abstract ArrayList<Transacao> getTransacoes();
    public abstract double getSaldoCredito();

    public abstract void setSaldoCredito(double saldoCredito);
    public abstract void addToSaldoCredito(double addValue);
    public abstract void subToSaldoCredito(double addValue); 
    public abstract double getSaldoDebito();
    public abstract void setSaldoDebito(double saldoDebito);
    public abstract void addToSaldoDebito(double addValue);
    public abstract void subToSaldoDebito(double addValue);
    public abstract double getLimiteCredito();
    public abstract void setLimiteCredito(double limiteCredito);
    public abstract void addToLimiteCredito(double limiteCredito);
    public abstract String listTransacoes();
    public abstract void subToLimiteCredito(double limiteCredito);
    
}
