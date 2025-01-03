package AlgasKalkulators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

public class Dati {
    private LinkedHashMap<String, Integer> invaliditate = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> gadiApgad = new LinkedHashMap<>();

    public void Read(String hmNos, String cels) {
        LinkedHashMap<String, Integer> kursHMaps = null;

        if (hmNos.equals("invaliditate")) {
            kursHMaps = invaliditate;
        } else if (hmNos.equals("gadiApgad")) {
            kursHMaps = gadiApgad;
        }

        if (kursHMaps != null) {
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/" + cels)) {
                if (inputStream == null) {
                    JOptionPane.showMessageDialog(null, "Kļūda nolasot no faila: " + hmNos, "Kļūda", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    String rinda;
                    while ((rinda = br.readLine()) != null) {
                        String[] dalas = rinda.split(",", 2);
                        if (dalas.length == 2) {
                            String key = dalas[0];
                            Integer value = Integer.parseInt(dalas[1].trim());
                            kursHMaps.put(key, value);
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Kļūda nolasot no faila: " + hmNos, "Kļūda", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String[] getKeys(String hmNos) {
        LinkedHashMap<String, Integer> kursHMaps = null;

        if (hmNos.equals("invaliditate")) {
            kursHMaps = invaliditate;
        } else if (hmNos.equals("gadiApgad")) {
            kursHMaps = gadiApgad;
        }

        if (kursHMaps != null) {
            String[] keys = kursHMaps.keySet().toArray(new String[0]);
            return keys;
        } else {
            return new String[0];
        }
    }

    public Integer getValue(String hmNos, String key) {
        LinkedHashMap<String, Integer> kursHMaps = null;

        if (hmNos.equals("invaliditate")) {
            kursHMaps = invaliditate;
        } else if (hmNos.equals("gadiApgad")) {
            kursHMaps = gadiApgad;
        }

        if (kursHMaps != null) {
            return kursHMaps.getOrDefault(key, 0);
        } else {
            return 0;
        }
    }
}
