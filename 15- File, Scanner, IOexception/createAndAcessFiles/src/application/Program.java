package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {

        String path = "D:\\Java\\java aula arquivos\\numbers.txt";
        File file = new File(path);
        String folderpath = file.getParent();
        new File(folderpath + "\\out\\").mkdir();
        try (BufferedReader br = new BufferedReader(new FileReader(path));
                BufferedWriter bw = new BufferedWriter(new FileWriter(folderpath + "\\out\\result.txt"))) {
            String line = br.readLine();
            int sum = 0;
            while (line != null) {
                sum += Integer.parseInt(line);
                line = br.readLine();
            }
            bw.write("A soma é: " + sum);
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
