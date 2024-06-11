import Models.Carteira;
public class Programa {
    public static void main(String[] args) throws Exception {
        Carteira carteira = new Carteira("Katsu", "185.514.152-53", 1);
        System.out.println(carteira.toString());
    }
}
