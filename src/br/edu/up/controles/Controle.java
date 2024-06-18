package br.edu.up.controles;

import br.edu.up.Models.*;
import java.util.ArrayList;
public class Controle {

    ArrayList<Carteira> carteiras = new ArrayList<>();

    public ArrayList<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(ArrayList<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
    
}
