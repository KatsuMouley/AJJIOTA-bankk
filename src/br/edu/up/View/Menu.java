package br.edu.up.View;

import br.edu.up.Controller.Controle;
import br.edu.up.Models.*;
import br.edu.up.util.*;
//import br.edu.up.Files.*;

import java.util.Scanner;
import java.util.ArrayList;

// import java.io.File;
// import java.io.FileWriter;
// import java.io.FileReader;

public class Menu {
    Scanner input = new Scanner(System.in);
    Controle control = new Controle();
    Prompt utilities = new Prompt();
    ArrayList<User> carteira = control.getCarteiras();

    int id = 0;
    String name, cpf;

    public Menu() {
        firstOptions();
    }

    public void firstOptions() {
        utilities.limparConsole();
        System.out.println("---------------------------------------------------");
        System.out.println("|1) Listar Usuários                               |");
        System.out.println("|2) Fazer um novo cadastro                        |");
        System.out.println("|3) sair                                          |");
        System.out.println("---------------------------------------------------");
        int value = input.nextInt();
        input.nextLine();
        // File file = new File("src/br/edu/up/Files/user"+1+".txt");
        // if (file.exists()) {
        // System.out.println("The file exists");

        // } else {
        // System.out.println("The file doesn't exists");
        // }
        switch (value) {
            case 1:
                listUsers();
                break;
            case 2:
                cadastrar();
                break;
            case 3:
                System.out.println("");
                break;
            default:
                System.out.println("This option is not available, restarting the program");
                utilities.pressionarEnter();
                firstOptions();
                break;
        }
    }

    public void listUsers() {
        utilities.limparConsole();
        System.out.println(control.toString());
        System.out.println("\n");
        System.out.println("---------------------------------------------------");
        System.out.println("|1) Acessar Carteira                              |");
        System.out.println("|2) Deletar Carteira                              |");
        System.out.println("|3) Voltar                                        |");
        System.out.println("---------------------------------------------------");
        int value = input.nextInt();
        input.nextLine();
        switch (value) {
            case 1:
                acessarCarteira();
                break;
            case 2:
                deletarCarteira();
                break;
            case 3:
                firstOptions();
                break;
            default:
            System.out.println("This option is not available, restarting the program");
            utilities.pressionarEnter();
            firstOptions();
                break;
        }

    }

    public void cadastrar() {
        utilities.limparConsole();
        System.out.println("---------------------------------------------------");
        System.out.println("| Qual o nome do usuário?                         |");
        String name = input.nextLine();
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("| Qual o CPF do usuário?                          |");
        String cpf = input.nextLine();
        System.out.println("---------------------------------------------------");
        for (User user : carteira) {
            if (user.getCpf().equals(cpf)) {
                System.out.println("usuario ja cadastrado");
                firstOptions();
            }
        }
        control.novoCadastro(name, cpf);
        System.out.println("Cadastro Adicionado :D                            |");
        System.out.println("---------------------------------------------------");
        listUsers();
    }

    public void acessarCarteira() {
        System.out.println("Degite o id do usuário que deseja selecionar");
        int id = input.nextInt();
        input.nextLine();
        opcoesCarteira(id);
    }

    public void deletarCarteira() {
        System.out.println("Qual o Id da carteira que você deseja deletar?");
        int id = input.nextInt();
        input.nextLine();
        control.removeUser(id);
        firstOptions();
    }

    public void opcoesCarteira(int id) {
        utilities.limparConsole();
        System.out.println("\n");
        System.out.println(control.getCarteiras().get(id-1).toString());
        this.id = id;
        for (User user : carteira) {
            if (user.getId() == this.id-1) {
                this.name = user.getName();
                this.cpf = user.getCpf();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println("|1) Visualizar Histórico de transações            |");
        System.out.println("|2) Realizar uma transação                        |");
        System.out.println("|3) Cripto Bank                                   |");
        // System.out.println("|*) Emprestimo                                    |");
        System.out.println("|4) voltar                                        |");
        System.out.println("---------------------------------------------------");
        int opcoes = input.nextInt();
        input.nextLine();
        switch (opcoes) {
            case 1:
                verHistorico();
                break;
            case 2:
                transacao();
                break;
            case 3:
                CriptoBank();
                break;
            case 4:
                firstOptions();
                break;
            default:
                System.out.println("This option is not available, restarting the program");
                utilities.pressionarEnter();
                firstOptions();
                break;
        }
    }

    public void transacao(){
        utilities.limparConsole();
        System.out.println(control.toString());//Da um print na lista de usuários
        System.out.println("Qual conta você deseja pagar?");
        int escolhaConta = input.nextInt();
        input.nextLine();
        System.out.println("Quanto você deseja pagar para "+control.getCarteiras().get(escolhaConta-1).getName()+"?");
        double valor = input.nextDouble();
        input.nextLine();
        Transacao transacao = new Transacao(this.id, escolhaConta, valor);
        double creditoRestante = control.getCarteiras().get(escolhaConta-1).getLimiteCredito() + control.getCarteiras().get(escolhaConta-1).getSaldoCredito();

        if (escolhaConta != this.id) {
            System.out.println("------------------------------------");
            System.out.println("Nome do pagador: " + this.name);
            System.out.println("Nome do recebedor: " + control.getCarteiras().get(escolhaConta-1).getName());
            System.out.println("valor: " + valor);
            System.out.println("------------------------------------");
            System.out.println("1) Pagar débito");
            System.out.println("2) Pagar crédito");
            System.out.println("3) voltar");
            int ress = input.nextInt();
            input.nextLine();

            switch (ress) {
                case 1:
                    if (control.getCarteiras().get(this.id - 1).getSaldoDebito() - valor <= 0) {
                        System.out.println("Você não tem Debito o suficiente para realizar esta operação");
                    } else {
                        control.getCarteiras().get(this.id - 1).subToSaldoDebito(valor);
                        control.getCarteiras().get(escolhaConta - 1).addToSaldoDebito(valor);
                        transacao.setMessage("O usuário " + control.getCarteiras().get(this.id- 1).getName() + " efetuou uma transação de $" + valor + " em debito para o usuário "+ control.getCarteiras().get(escolhaConta- 1).getName() + "\n");
                    }
                    break;
                case 2:
                    if (creditoRestante - valor <= 0) {
                        System.out.println("Você não tem crédito o suficiente para realizar esta operação");
                    } else {
                        control.getCarteiras().get(this.id - 1).subToSaldoCredito(valor);
                        control.getCarteiras().get(escolhaConta - 1).addToSaldoDebito(valor);
                        transacao.setMessage("O usuário " + control.getCarteiras().get(this.id- 1).getName() + " efetuou uma transação de $" + valor + " em crédito para o usuário "+ control.getCarteiras().get(escolhaConta- 1).getName() + "\n");
                    }
                    break;
                case 3:
                    opcoesCarteira(this.id);
                    break;
                default:
                    System.out.println("This option is not available");
                    utilities.pressionarEnter();
                    opcoesCarteira(this.id);
                    break;
            }
        } else {
            if ( creditoRestante != control.getCarteiras().get(escolhaConta-1).getLimiteCredito()) {
                System.out.println("------------------------------------");
                System.out.println("O usuário tem uma pendência de $"+ control.getCarteiras().get(escolhaConta-1).getSaldoCredito()+ " créditos, você deseja pagar essa pendência?");
                System.out.println("------------------------------------");
                System.out.println("1) Pagar débito");
                System.out.println("2) voltar");
                
                int ress = input.nextInt();
                input.nextLine();

                switch (ress) {
                    case 1:
                        if (control.getCarteiras().get(this.id - 1).getSaldoDebito() - valor <= 0) {
                            System.out.println("Você não tem Debito o suficiente para realizar esta operação");
                        } else {
                            control.getCarteiras().get(this.id - 1).addToSaldoCredito(valor);
                            control.getCarteiras().get(this.id - 1).addToLimiteCredito(valor);
                            control.getCarteiras().get(escolhaConta - 1).subToSaldoDebito(valor);
                            transacao.setMessage("Você "+ control.getCarteiras().get(this.id - 1).getName() +" efetuou um pagamento para suas pêndencias de créditos de $" + valor + ", seu novo limite de crédito é de " + control.getCarteiras().get(this.id - 1).getLimiteCredito());
                        }
                        break;
                    case 2:
                        opcoesCarteira(this.id);
                        break;
                    default:
                        System.out.println("This option is not available");
                        utilities.pressionarEnter();
                        opcoesCarteira(this.id);
                        break;
                }
            } else {
                System.out.println(" Não dividas pendentes em relação a você mesmo");
            }

        }
        
        control.getCarteiras().get(this.id - 1).getTransacoes().add(transacao);
        opcoesCarteira(this.id);
    }

    public void verHistorico(){
        utilities.limparConsole();
        System.out.println(control.getCarteiras().get(this.id - 1).listTransacoes());
        System.out.println("------------------------------------");
        utilities.pressionarEnter();
        opcoesCarteira(this.id);
    }

    public void CriptoBank(){
        utilities.limparConsole();
        System.out.println("CRIPTO BANK");
        System.out.println("---------------------------------------------------");
        System.out.println("|1) Listar moedas                                 |");
        System.out.println("|2) Voltar                                        |");
        System.out.println("---------------------------------------------------");
        
        int opcoes = input.nextInt();
        input.nextLine();
        switch (opcoes) {
            case 1:
                ListarCriptos();
                break;
            case 2:
                opcoesCarteira(this.id);
                break;
            default:
                System.out.println("This option is not available");
                utilities.pressionarEnter();
                CriptoBank();
                break;
        }
    }

    public void ListarCriptos(){
        utilities.limparConsole();
        System.out.println("---------------------------------------------------");
        System.out.println("1| Ethereum | valor: $"+control.getCarteiras().get(this.id).getCriptobank().obterTaxa("Ethereum")+" | Saldo: "+ control.getCarteiras().get(this.id).getCriptobank().verSaldoCripto("Ethereum"));
        System.out.println("2| Bitcoin  | valor: $"+control.getCarteiras().get(this.id).getCriptobank().obterTaxa("Bitcoin")+" | Saldo: "+ control.getCarteiras().get(this.id).getCriptobank().verSaldoCripto("Bitcoin"));
        System.out.println("3| Ajjicoin | valor: $"+control.getCarteiras().get(this.id).getCriptobank().obterTaxa("Ajjicoin")+" | Saldo: "+ control.getCarteiras().get(this.id).getCriptobank().verSaldoCripto("Ajjicoin"));
        System.out.println("---------------------------------------------------");
        System.out.println("|1) Investir                                      |");
        System.out.println("|2) Vender                                        |");
        System.out.println("|3) Voltar                                        |");
        System.out.println("---------------------------------------------------");
        int opcoes = input.nextInt();
        input.nextLine();
        switch (opcoes) {
            case 1:
                investirCripto();
                break;
            case 2:
                venderCripto();
                break;
            case 3:
                opcoesCarteira(this.id);
                break;
            default:
                System.out.println("This option is not available");
                utilities.pressionarEnter();
                CriptoBank();
                break;
        }
    }

    public void investirCripto(){
        System.out.println("Qual a moeda que você deseja Investir?");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Qual o valor que você deseja Investir?");
        double value = input.nextDouble();
        input.nextLine();
        switch (id) {
            case 1:
            control.getCarteiras().get(this.id).getCriptobank().comprarCripto("Ethereum", value);
            control.getCarteiras().get(this.id - 1).subToSaldoDebito(value);
                break;
            case 2:
            control.getCarteiras().get(this.id).getCriptobank().comprarCripto("Bitcoin", value);
            control.getCarteiras().get(this.id - 1).subToSaldoDebito(value);
                break;
            case 3:
            control.getCarteiras().get(this.id).getCriptobank().comprarCripto("Ajjicoin", value);
            control.getCarteiras().get(this.id - 1).subToSaldoDebito(value);
                break;
        
            default:
            System.out.println("This option is not available");
            utilities.pressionarEnter();
            CriptoBank();
                break;
        }
        ListarCriptos();
    }

    public void venderCripto(){
        String nome = "";
        System.out.println("Qual a moeda que você deseja vender?");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Quanto você deseja retirar desta moeda??");
        double value = input.nextDouble();
        input.nextLine();
        switch (id) {
            case 1:
            nome = "Ethereum";
                break;
            case 2:
            nome = "Bitcoin";
                break;
            case 3:
            nome = "Ajjicoin";
                break;
            default:
            System.out.println("This option is not available");
            utilities.pressionarEnter();
            CriptoBank();
                break;
        }
        double Saldo = control.getCarteiras().get(this.id).getCriptobank().verSaldoCripto(nome);
        if ( Saldo < value) {
            System.out.println("Você não possui esta quantia de dinheiro em "+name+"s");
            utilities.pressionarEnter();
        } else {
            control.getCarteiras().get(this.id).getCriptobank().venderCripto(nome, value);
            control.getCarteiras().get(this.id - 1).addToSaldoDebito(value * control.getCarteiras().get(this.id).getCriptobank().obterTaxa(nome));

        }
        ListarCriptos();

    }
}