
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02_TEKRAR {  //2.GÜN
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
        sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).forEach(t -> System.out.print(" " + t));
    }

    /* Task-2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir
     fazlasini ayni satirda aralarina bosluk birakarak print edi*/
    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 != 0).map(t -> (t * t * t) + 1).forEach(Lambda01::yazdir);
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0).map(t -> t * t).forEach(Lambda01::yazdir);
    }

    //Task-4 : Listin en büyük elemanını yazdırınız
    public static void enBuyukEleman(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Integer::max));
    }

    //TASK-5 : Listin çifti elemanlrının  karelerinin en büyüğünü print ediniz,
    public static void cifElKareEnBuyugu(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max));
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Integer::sum));
        System.out.println(sayi.stream().reduce(0, (a, b) -> a + b));
    }

    //TAsk -7: Listtteki çift elemanların çarpımını bul
    public static void ciftCarp(List<Integer> sayi) {
        int d = sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> a * b);
        System.out.println(d);

    }

    public static void ciftCarp2(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
    }

    //TASK -8: listteki elemanlardan en küçüğünü yazınız

    //1.yol
    public static void minBul(List<Integer> sayi) {
        Optional<Integer> d1 = sayi.stream().reduce(Integer::min);
        System.out.println(d1);

        //2.yol

    }

    public static int byErdemMin(int a, int b) {
        return a < b ? a : b;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void besBuyukEnKucukTek(List<Integer> sayi) {
        sayi.stream().filter(t -> t > 5 && t % 2 != 0).reduce(Math::min);
        System.out.println(sayi.stream().filter(t -> (t > 5) && (t % 2 != 0)).reduce(Math::min));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareSirala(List<Integer> sayi) {

    }

}
