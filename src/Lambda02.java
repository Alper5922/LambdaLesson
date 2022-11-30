import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {  //2.GÜN
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println();
        tekKupBirFazlaPrint(sayi);
        System.out.println();
        ciftKarekokPrint(sayi);
        System.out.println();
        enBuyukEleman(sayi);
        cifElKareEnBuyugu(sayi);
        elTopla(sayi);
        ciftCarp(sayi);
        ciftCarp2(sayi);
        minBul(sayi);
        besBuyukEnKucukTek(sayi);
        ciftKareSirala(sayi);
    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.stream().
                filter(Lambda01::ciftBul). //Akıştaki çift sayıları filtreledim 4,2,6
                map(t -> t * t). // 16,4,36  -- map()--> Streamdeki akışı başka tiplere dönüştürüyor
                forEach(Lambda01::yazdir);//16 4 36
    }

    // Task-2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir
    // fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.stream().
                filter(t -> t % 2 != 0).
                map(t -> (t * t * t) + 1).
                forEach(Lambda01::yazdir);//1332 -124 344 28 3376
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t -> System.out.print(t + " "));//2.0 1.4142135623730951 2.449489742783178
    }

    //Task-4 : Listin en büyük elemanını yazdırınız
    public static void enBuyukEleman(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.     // Integer'a null değer atanma ihtimaline karşı Java CTE verdive otomatik olarak Optional yaptı
                stream().
                reduce(Math::max); // Eğer result tek bir değer ise o zaman reduce terminal operatorü kullanlır
        System.out.println(maxSayi);
    }

    //TASK-5 : Listin çifti elemanlrının  karelerinin en büyüğünü print ediniz,
    public static void cifElKareEnBuyugu(List<Integer> sayi) {
        Optional<Integer> maxSayi2 = sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Math::max); //Math::max yerine Integer::max yaparsak daha hızlı çalışır
        System.out.println("task-5 "+maxSayi2);//Optional[36]
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);  //reduce(Integer::sum); bu da olabilir
        System.out.println("toplam = " + toplam);//toplam = 43
    }

    //TAsk -7: Listtteki çift elemanların çarpımını bul
    public static void ciftCarp(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); // akıştaki tüm elemanlrı çarpar   //Optional[48]
    }

    public static void ciftCarp2(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b)); // akıştaki tüm elemanlrı çarpar
    }

    //TASK -8: listteki elemanlardan en küçüğünü yazınız

    //1.yol
    public static void minBul(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                reduce(Math::min));  // .reduce(Integer::min); --> Bu da olabilir //Optional[-5]
        //2.yol
        System.out.println(sayi.stream().reduce(Lambda02::byErdemMin));
    }

    public static int byErdemMin(int a, int b) {
        return a < b ? a : b;
    }
// Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void besBuyukEnKucukTek(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(t -> t > 5 && t % 2 != 0).
                reduce(Integer::min));
    }
    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareSirala(List<Integer> sayi){
        sayi.stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().forEach(Lambda01::yazdir);
    }

}
