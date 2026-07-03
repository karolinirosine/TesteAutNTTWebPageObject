package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
    public static void escreverLog(String featureName, String texto) {

        try {
            File pasta = new File("target/evidencias/" + featureName);
            pasta.mkdirs();

            File arquivo = new File(pasta, "log.txt");

            PrintWriter writer = new PrintWriter(new FileWriter(arquivo, true));

            writer.println("[" + java.time.LocalDateTime.now() + "] " + texto);

            writer.close();

        } catch (IOException e) {

        }
    }
}
