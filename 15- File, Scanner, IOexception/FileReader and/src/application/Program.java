package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String path = "D:\\Java\\java aula arquivos\\in.csv";
        File file = new File(path);
        String folderPath = file.getParent();
        System.out.println(folderPath);
        new File(folderPath + "\\out\\").mkdir();
        try (BufferedReader br = new BufferedReader(new FileReader(path));
                BufferedWriter bw = new BufferedWriter(new FileWriter(folderPath + "\\out\\summary.csv"))) {

            String line = br.readLine();
            while (line != null) {
                String[] price = line.split(",");
                Double total = Double.parseDouble(price[1]) * Integer.parseInt(price[2]);

                bw.write(price[0] + "," + total);
                bw.newLine();
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
