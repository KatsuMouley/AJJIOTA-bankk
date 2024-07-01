package br.edu.up.Models;

public class Cripto{


    //--------------------- saldo de cripto
    private double saldoEthereum = 0;
    private double saldoBitcoin = 0;
    private double saldoAjjicoin = 0;


    //--------------------- taxa de cripto
    private double taxaEthereum = 0.2;
    private double taxaBitcoin = 0.25;
    private double taxaAjjicoin = 0.3;


    // compra de criptos
    public void comprarCripto(String nomeCripto, double valor) {
        double taxa = obterTaxa(nomeCripto);
        double valorComTaxa = valor / taxa;
        adicionarSaldoCripto(nomeCripto, valorComTaxa);
        
    }

    // venda de criptos
    public void venderCripto(String nomeCripto, double valor) {
        double taxa = obterTaxa(nomeCripto);
        double valorComTaxa = valor;
        removerSaldoCripto(nomeCripto, valorComTaxa);
    }

    // visualizar taxa de criptos
    public double obterTaxa(String nomeCripto) {
        switch (nomeCripto) {
            case "Ethereum":
                return taxaEthereum;
            case "Bitcoin":
                return taxaBitcoin;
            case "Ajjicoin":
                return taxaAjjicoin;
            default:
                return 0.0;
        }
    }

    // aumentar saldo de cripto
    public void adicionarSaldoCripto(String nomeCripto, double valor) {
        switch (nomeCripto) {
            case "Ethereum":
                saldoEthereum += valor;
                break;
            case "Bitcoin":
                saldoBitcoin += valor;
                break;
            case "Ajjicoin":
                saldoAjjicoin += valor;
                break;
        }
    }

    // diminuir saldo de cripto
    public void removerSaldoCripto(String nomeCripto, double valor) {
        switch (nomeCripto) {
            case "Ethereum":
                saldoEthereum -= valor;
                break;
            case "Bitcoin":
                saldoBitcoin -= valor;
                break;
            case "Ajjicoin":
                saldoAjjicoin -= valor;
                break;
        }
    }

    // ver saldo de criptos
    public double verSaldoCripto(String nomeCripto) {
        switch (nomeCripto) {
            case "Ethereum":
                return saldoEthereum ;
            case "Bitcoin":
                return saldoBitcoin;
            case "Ajjicoin":
                return saldoAjjicoin;
            default:
                return 0.0;
        }
    }

    // // mostrar saldo de criptos
    // public void mostrarSaldoCriptos() {
    //     System.out.println("Saldo Ethereum: " + saldoEthereum);
    //     System.out.println("Saldo Bitcoin: " + saldoBitcoin);
    //     System.out.println("Saldo Ajjicoin: " + saldoAjjicoin);
    // }
}