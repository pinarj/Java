import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("MENU");
            System.out.println("1- Elit üye ekleme");
            System.out.println("2- Genel Üye ekleme");
            System.out.println("3- Mail Gönderme");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:// Elit üye ekleme işlemleri
                    dosyaIslemleri.elitUyeEkle();// fonksiyonu cagir
                    break;

                case 2://Genel üye ekleme işlemleri
                    dosyaIslemleri.genelUyeEkle();
                    break;

                case 3:
                    // Mail gönderme işlemleri (yapamadım)

                    break;

                default://1-2-3 ten farklı sayı girilirse hata ver
                    System.out.println("Hatalı seçim yaptınız, tekrar deneyin.");
                    break;
            }
        }
    }
}
