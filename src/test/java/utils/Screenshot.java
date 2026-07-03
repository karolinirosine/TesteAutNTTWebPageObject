package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void tirarPrint(WebDriver driver, String featureName, String nomeImagem) {

        try {

            File pasta = new File("target/evidencias/" + featureName);
            pasta.mkdirs();

            File origem =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destino =
                    new File(pasta, nomeImagem + ".png");

            FileUtils.copyFile(origem, destino);

        } catch (IOException e) {

        }
    }
}
