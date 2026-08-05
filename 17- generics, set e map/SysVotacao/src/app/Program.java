package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {
        Map<String, Integer> mapCandidatos = new TreeMap<>();
        String path = "C:\\temp\\in.txt";
        File textFile = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] votos = line.split(",");
                String name = votos[0];
                int nVotos = Integer.parseInt(votos[1].trim());
                if (mapCandidatos.containsKey(name)) {
                    mapCandidatos.put(name, mapCandidatos.get(name) + nVotos);
                } else {
                    mapCandidatos.put(name, nVotos);
                }
                line = br.readLine();
            }
            for (String name : mapCandidatos.keySet()) {
                System.out.println(name + ": " + mapCandidatos.get(name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
