package AlgasKalkulators;

public class Main {
    public static void main(String[] args) {
        Dati dati = new Dati();
        dati.Read("invaliditate", "invaliditate.txt");
        dati.Read("gadiApgad", "gadiApgad.txt");

        new Ramis(dati);
    }
}
