package br.edu.up.Controller;

import br.edu.up.Models.*;
import java.util.ArrayList;

public class Controle {
    private ArrayList<User> carteiras = new ArrayList<>();

    public Controle(){
        Carteira user1 = new Carteira(1, "Primo Rico", "991.999.999-99", 25000);
        Carteira user2 = new Carteira(2, "SketchMask", "992.999.999-99", 1200);
        Carteira user3 = new Carteira(3, "Katsu Moulet", "993.999.999-99", 500);
        addToUsers(user1);addToUsers(user2);addToUsers(user3);//3 usuários minimos
    }

    public void addToUsers(User a) {
        carteiras.add(a);
    }
    
    public void removeUser(int index) {
        carteiras.remove(index);
        for (int i = 0; i < carteiras.size(); i++) {
            carteiras.get(i).setId(i+1);   
        }
    }
    
    public ArrayList<User> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(ArrayList<User> carteiras) {
        this.carteiras = carteiras;
    }

    @Override
    public String toString()
    {
        String string = "User |ID |NOME |CPF | Saldo: | Crédito: |\n";
        for (User user : carteiras) {
            string +="----------------------------------------\n";
            string +=user.toString()+"\n";
            string +="----------------------------------------\n";
        }
        return string;
    }

    public void novoCadastro(String name, String cpf){
        int id = carteiras.size() + 1;
        Carteira user = new Carteira(id, name, cpf);
        addToUsers(user);
    }

    
}