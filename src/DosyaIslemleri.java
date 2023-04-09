import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DosyaIslemleri {
    public void elitUyeEkle() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("İsim: ");
            String name = scanner.next();

            System.out.print("Soyisim: ");
            String surname = scanner.next();

            System.out.print("E-posta: ");
            String email = scanner.next();

            // Mevcut üyeleri oku
            List<String> lines = Files.readAllLines(Paths.get("members.txt"));
            List<String> updatedLines = new ArrayList<>();//okunan satırları tutmak için bir "ArrayList<String>" nesnesi oluşturuluyor.

            // Yeni üyeyi ekle
            boolean elitFound = false;
            boolean genelFound = false;
            for (String line : lines) {
                if (line.equals("#ELIT ÜYELER")) {
                    updatedLines.add(line);
                    updatedLines.add(name + " " + surname + " " + email);
                    elitFound = true;
                } else if (line.equals("#GENEL ÜYELER")) {
                    updatedLines.add(line);
                    genelFound = true;
                } else {
                    updatedLines.add(line);
                }
            }

            // Yeni bölüm eklemek gerekiyorsa, ekle
            if (!elitFound) {
                updatedLines.add("#ELIT ÜYELER");
                updatedLines.add(name + " " + surname + " " + email);
            }

            if (!genelFound) {
                updatedLines.add("#GENEL ÜYELER");
            }

            // Dosyayı yeniden yaz
            FileWriter writer = new FileWriter("members.txt");
            for (String line : updatedLines) {
                writer.write(line + "\n");
            }
            writer.close();

            System.out.println("Üye başarıyla kaydedildi :).");
        } catch (IOException e) {
            System.out.println("Dosya işlemleri hatası: " + e.getMessage());
        }
    }

    public void genelUyeEkle() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("İsim: ");
            String name = scanner.next();

            System.out.print("Soyisim: ");
            String surname = scanner.next();

            System.out.print("E-posta: ");
            String email = scanner.next();

            // Mevcut üyeleri oku
            List<String> lines = Files.readAllLines(Paths.get("members.txt"));
            List<String> updatedLines = new ArrayList<>();

            // Yeni üyeyi ekle
            boolean elitFound = false;
            boolean genelFound = false;
            for (String line : lines) {
                if (line.equals("#ELIT ÜYELER")) {
                    updatedLines.add(line);
                    elitFound = true;
                } else if (line.equals("#GENEL ÜYELER")) {
                    updatedLines.add(line);
                    updatedLines.add(name + " " + surname + " " + email);
                    genelFound = true;
                } else {
                    updatedLines.add(line);
                }
            }

            // Yeni bölüm eklemek gerekiyorsa, ekle
            if (!elitFound) {
                updatedLines.add("#ELIT ÜYELER");
            }

            if (!genelFound) {
                updatedLines.add("#GENEL ÜYELER");
                updatedLines.add(name + " " + surname + " " + email);
            }

            // Dosyayı yeniden yaz
            FileWriter writer = new FileWriter("members.txt");
            for (String line : updatedLines) {
                writer.write(line + "\n");
            }
            writer.close();

            System.out.println("Üye başarıyla kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosya işlemleri hatası: " + e.getMessage());
        }

    }
}
