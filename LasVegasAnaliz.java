import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LasVegasAnaliz {

    public static void main(String[] args) {
        long ogrenciNo = 1240505015;
        int n = 1000000; // 10^6 veri boyutu
        int denemeSayisi = 100;

        // Veri setini bir kez olusturuyoruz (Seed ile sabitlenmis rastgelelik)
        int[] veriSeti = veriSetiUret(n, ogrenciNo);

        List<Long> adimSayilari = new ArrayList<>();
        List<Double> sureler = new ArrayList<>();

        System.out.println("Deney basliyor...");

        for (int i = 0; i < denemeSayisi; i++) {
            long baslangicZamani = System.nanoTime();

            // Las Vegas algoritmasi burada calisir
            long adim = lasVegasBulucu(veriSeti, ogrenciNo + i); // Her seferinde farkli secimler icin i ekliyoruz

            long bitisZamani = System.nanoTime();

            adimSayilari.add(adim);
            sureler.add((bitisZamani - baslangicZamani) / 1_000_000.0); // ms cinsinden
        }

        istatistikleriYazdir(adimSayilari, sureler);
    }

    // Belirli bir kosulu saglayan elemani rastgele indexler secerek bulur
    public static long lasVegasBulucu(int[] dizi, long localSeed) {
        Random rand = new Random(localSeed);
        long adimSayisi = 0;

        while (true) {
            adimSayisi++;
            int rastgeleIndex = rand.nextInt(dizi.length);

            // Kosul: Elemanin 777'ye tam bolunmesi (Ozel eleman tanimi)
            if (dizi[rastgeleIndex] % 777 == 0) {
                return adimSayisi; // %100 dogru sonuc bulunca cikar
            }
        }
    }

    public static int[] veriSetiUret(int n, long seed) {
        Random rand = new Random(seed);
        int[] dizi = new int[n];
        for (int i = 0; i < n; i++) {
            dizi[i] = rand.nextInt(1000000); // 0-1M arasi sayilar
        }
        return dizi;
    }

    public static void istatistikleriYazdir(List<Long> adimlar, List<Double> sureler) {
        double toplamAdim = 0;
        double toplamSure = 0;
        for (long a : adimlar) toplamAdim += a;
        for (double s : sureler) toplamSure += s;

        double ortalamaAdim = toplamAdim / adimlar.size();
        double ortalamaSure = toplamSure / sureler.size();

        // Standart Sapma Hesabi
        double varyansSure = 0;
        for (double s : sureler) varyansSure += Math.pow(s - ortalamaSure, 2);
        double stSapmaSure = Math.sqrt(varyansSure / sureler.size());

        System.out.println("--- SONUCLAR ---");
        System.out.println("Ortalama Adim Sayisi: " + ortalamaAdim);
        System.out.println("Ortalama Calisma Suresi (ms): " + ortalamaSure);
        System.out.println("Sure Standart Sapmasi: " + stSapmaSure);
    }
}