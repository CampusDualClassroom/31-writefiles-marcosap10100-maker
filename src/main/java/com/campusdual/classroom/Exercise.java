package com.campusdual.classroom;

import com.campusdual.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise {

    public static void main(String[] args) {
        String text = generateStringToSave(null);
        printToFile(text);
    }

    public static String generateStringToSave(String string) {
        if (string != null) {
            return string;
        }
        return generateUserInputToSave();
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        String filePath = "src/main/resources/data.txt";
        if (string == null) {
            string = "";
        }

        File file = new File(filePath);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(string);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
