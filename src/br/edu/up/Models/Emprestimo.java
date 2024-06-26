package br.edu.up.Models;

public class Emprestimo extends User {

    private double saldoEmprestimo = 0.0; // saldo atual do emprestimo
    private double limiteEmprestimo = 500.0; // Limite mínimo de empréstimo (pode ser ajustado)
    private double taxaJuros = 0.1; // Taxa de juros (em porcentagem) por período (pode ser ajustada)
    private int prazoEmprestimo = 0; // Prazo do empréstimo (em períodos)

    //Construtor com informações básicas do usuário
    public Emprestimo(int id, String name, String cpf) {
        super(id, name, cpf);
    }

    // Getter e setter para saldo de empréstimo
    public double getSaldoEmprestimo() {
        return saldoEmprestimo;
    }

    public void setSaldoEmprestimo(double saldoEmprestimo) {
        this.saldoEmprestimo = saldoEmprestimo;
    }

    // Getter e setter para limite de empréstimo
    public double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(double limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    // Getter e setter para taxa de juros
    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros / 100; // Converte porcentagem em valor decimal
    }

    // Getter e setter para prazo de empréstimo
    public int getPrazoEmprestimo() {
        return prazoEmprestimo;
    }

    public void setPrazoEmprestimo(int prazoEmprestimo) {
        this.prazoEmprestimo = prazoEmprestimo;
    }

    // Método para simular um empréstimo (considerar adicionar cheques para o limite disponível)
    public void tomarEmprestimo(double valor) {
        if (valor <= limiteEmprestimo - saldoEmprestimo) {
            saldoEmprestimo += valor;
        } else {
            System.out.println("Limite de empréstimo excedido.");
        }
    }

    // Método para simular o pagamento do empréstimo (considerar adicionar cálculo de juros)
    public void pagarEmprestimo(double valor) {
        if (valor <= saldoEmprestimo) {
            saldoEmprestimo -= valor;
        } else {
            System.out.println("Valor de pagamento excede o saldo do empréstimo.");
        }
    }

    // Ccalcular o valor total a ser pago considerando juros
    public double calcularTotalEmprestimo() {
        double juros = saldoEmprestimo * taxaJuros * prazoEmprestimo;
        return saldoEmprestimo + juros;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Saldo do Empréstimo: R$" + saldoEmprestimo + "\n" +
                "Limite de Empréstimo: R$" + limiteEmprestimo + "\n" +
                "Taxa de Juros: " + taxaJuros * 100 + "%" + (prazoEmprestimo > 0 ? "\nPrazo: " + prazoEmprestimo + " períodos" : "");
    }
}