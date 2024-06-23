package br.edu.up.View;

import br.edu.up.Controller.Controle;
import br.edu.up.Models.Boleto;
import br.edu.up.Models.Carteira;
import br.edu.up.Models.User;
// import br.edu.up.Files.*;
// import br.edu.up.Models.*;
// import br.edu.up.util.Prompt;

import java.util.Scanner;
import java.util.ArrayList;

// import java.io.File;
// import java.io.FileWriter;
// import java.io.FileReader;

public class Menu {
    Scanner input = new Scanner(System.in);
    Controle control = new Controle();
    ArrayList<User> carteira = control.getCarteiras();

    public Menu() {
        firstOptions();
    }

    public void firstOptions() {
        System.out.println("---------------------------------------------------");
        System.out.println("|1) Listar Usuários                               |");
        System.out.println("|2) Fazer um novo cadastro                        |");
        System.out.println("|3) entrar na conta");
        System.out.println("|4) sair                                          |");
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
                acessarCarteira();
                break;
            case 4:
                System.out.println("");
                break;
            default:
                System.out.println("This Option is not avalaible, Exiting the program...");
                break;
        }
    }

    public void listUsers() {
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

                break;
            case 2:
                deletarCarteira();
                break;
            case 3:
                firstOptions();
                break;
            default:
                System.out.println("This Option is not avalaible, Exiting the program...");
                break;
        }

    }

    public void cadastrar() {
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
        System.out.println("boleto");
        Boleto boleto = new Boleto();
        boleto.run();


    }

    public void deletarCarteira() {
        System.out.println("Qual o Id da carteira que você deseja deletar?");
        int id = input.nextInt();
        input.nextLine();
        control.removeUser(id);
        firstOptions();
    }
}