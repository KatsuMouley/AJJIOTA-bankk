package br.edu.up.Models;

public class Carteira {
    private    double debito = 0, credito = 0;
    private    String nome, cpf, emai, senha;
    private    int id;

    
    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getCredito() {
        return credito;
    }



    public void setCredito(double credito) {
        this.credito = credito;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getCpf() {
        return cpf;
    }



    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }


    public Carteira(String nome, String cpf, String emai, String senha, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.emai = emai;
        this.senha = senha;
        this.id = id;
    }



    @Override
    public String toString() {
        return "------------------------\nCarteira \nSaldo debito: " +String.format("%.2f",  debito) + " | saldo credito: " + String.format("%.2f",  credito) + "\nnome: " + nome + ", cpf: " + cpf + ", id: " + id+ "\n------------------------";
    }



    public String getEmai() {
        return emai;
    }



    public void setEmai(String emai) {
        this.emai = emai;
    }



    public String getSenha() {
        return senha;
    }



    public void setSenha(String senha) {
        this.senha = senha;
    }


    //Options
    //Carteira (Nome do usuario, cpf, numero de id da carteira)
    //Carteira (Nome do usuario, cpf, numero de id da carteira, saldo inicial)
    //Carteira tera opções de ver credito, debito, adicionar e remover valor a essas variaveis; Toda operação nesta precisara ser guardada, então a carteira tbm terá uma opção de ver movimentações(histórico de movimentações). 
    //Como a carteira será o objeto pai(O objeto de maior hierarquia) é importante frisar que a carteira permitirá outras ações.
    //Displays
    // 1 - saldo de crédito e debito atual
    //A carteira vai ter as seguintes opções = 
    //1 - Remover Saldo
    //          - Credito ou Debito
    //2 - Adicionar Saldo
    //          - Credito ou Debito
    //3 - ver Movimentações da conta (Permite o usuário ver movimentações da conta, passando uma listagem de todas as movimentações da conta do usuário)
    //4- Pix( Eu assumo que permitirá uma troca de valores entre carteiras, tbm constando no histórico da carteira), no qual eu assumo que pode fazer as ações de remover e adicionar ao saldo
    //5- Boleto( Nunca mexi com boleto ent eu realmente n sei muito aonde entraria, pelo que eu sei é uma forma de pagamento fisica, ent talvez)
    //5- Emprestimo ( Eu assumo que pemitirá )
    //6- investimentos (Eu chamei de investimentos mas eu acredito que seja onde possamos colocar Cripto)
}
