package br.edu.up.telas;

import br.edu.up.Models.Boleto;
import br.edu.up.Models.Carteira;
import br.edu.up.util.Prompt;
import br.edu.up.controles.Controle;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

public class Menu {
    Controle control = new Controle();
    ArrayList<Carteira> carteiras = control.getCarteiras();
    private boolean ligado = true;

    public void run() {
        System.out.println("1: Criar conta");
        System.out.println("2: Entrar na conta");
        int resposta = Prompt.lerInteiro();
        switch (resposta) {
            case 1:
                criarConta();
                break;
            case 2:
                entrarNaConta();
                break;
            default:
                break;
        }
    }

    public void dentroSystem() {

        while (ligado) {
            System.out.println("1: Boleto");
            System.out.println("2: Empréstimos");
            System.out.println("3: Pix");
            System.out.println("4: Cripto moeda");
            System.out.println("5: Sair do app");
            int respostas = Prompt.lerInteiro();
            switch (respostas) {
                case 1:
                    boleto();
                    break;
                case 2:
                    emprestimos();
                    break;
                case 3:
                    pix();
                    break;
                case 4:
                    criptomoeda();
                    break;
                case 5:
                    ligado = false;
                    break;
            }
        }

    }

    public void boleto() {
        System.out.println("1: Pagar um boleto");
        System.out.println("2: Ver contas pagas");
        System.out.println("3: Voltar");
        int resposta = Prompt.lerInteiro();
        switch (resposta) {
            case 1:
            Random rand = new Random();
            int number = rand.nextInt(5 + 1);
            int[] TodasAsContas = new int[number]; 
            for (int i = 0; i < TodasAsContas.length; i++) {
                int valor = rand.nextInt(1000); 
                TodasAsContas[i] = valor;
            }

            for (int i = 0; i < TodasAsContas.length; i++) {
                System.out.println("-----------------------");
                System.err.println("conta" + TodasAsContas.length + "=" + TodasAsContas[i]);
                System.out.println("-----------------------");
            }
                break;
            case 2:
                // Implemente a lógica para ver contas pagas
                break;
            case 3:
                run();
                break;
            default:
                break;
        }
    }

    public void emprestimos() {
        // Implemente a lógica para empréstimos
    }

    public void pix() {
        // Implemente a lógica para PIX
    }

    public void criptomoeda() {
        // Implemente a lógica para criptomoeda
    }

    public void criarConta() {
        System.out.println("cpf");
        String cpf = Prompt.lerLinha();
        for (Carteira carteira : carteiras) {
            if (carteira.getCpf().equals(cpf) == true) {
                System.out.println("esse perfil ja existe");
                run();
            }
        }
        System.out.println("nome");
        String nome = Prompt.lerLinha();
        System.out.println("senha da sua conta");
        String senha = Prompt.lerLinha();
        System.err.println("email");
        String email = Prompt.lerLinha();
        Random rand = new Random();
        int id = rand.nextInt(100000);

        Carteira carteira = new Carteira(cpf, nome, senha, email, id);
        carteiras.add(carteira);
        dentroSystem();
    }

    public void entrarNaConta() {
        System.out.println("email");
        String email = Prompt.lerLinha();
        System.out.println("senha");
        String senha = Prompt.lerLinha();
        for (Carteira carteira : carteiras) {
            if (carteira.getEmai().equals(email) || carteira.getSenha().equals(senha)) {
                Carteira usuarioAtual = carteira;
            }
        }
    }
}
