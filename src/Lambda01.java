import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
                             //1.GÜN
public class Lambda01 {
    public static void main(String[] args) {
        /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

*/

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        printElStructured(sayi);
        System.out.println(); // boşluk için bırakıldı
        printElFunctional(sayi);
        System.out.println(); // boşluk için bırakıldı
        printElFunctional1(sayi);
        System.out.println(); // boşluk için bırakıldı
        printElFunctional2(sayi);
        System.out.println(); // boşluk için bırakıldı
        printCiftElFunctional(sayi);
        System.out.println(); // boşluk için bırakıldı
        printCiftElStructural(sayi);
        System.out.println(); // boşluk için bırakıldı
        printCiftOtcKckFunctional(sayi);
        System.out.println(); // boşluk için bırakıldı
        printCiftOtBykFunctional(sayi);
    }

    //-------------------------------------------------------------------------------------------
    /*TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda
                  aralarında bosluk olacak sekilde print ediniz.*/
    public static void printElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }

    //---------------------------------------------------------------------------------------
    ////TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer> sayim) {
        sayim.
                stream().
                forEach((t) -> System.out.print(t + " ")); // Lambda expression --> tercihen kullanılmaz
    }

    public static void printElFunctional1(List<Integer> sayim) {
        sayim.
                stream().
                forEach(System.out::print);  //method referance --> Tercihen bu kullanılmalıdır
    }

    public static void yazdir(int a) {
        System.out.print(a + " ");
    }
    public static void yazdir(String a) {
                                     System.out.print(a + " ");
                                 }

    public static void yazdir(double a) {
                                     System.out.print(a + " ");
                                 }

    public static void printElFunctional2(List<Integer> sayim) {
        sayim.
                stream().
                forEach(Lambda01::yazdir);  //method referance

    }
    //----------------------------------------------------------------------------

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer> sayim) {
        sayim.
                stream().
                filter(t -> t % 2 == 0). // Lambda expression
                forEach(Lambda01::yazdir);//34 22 16 20 44 66 64 38

    }

    // Yukarıdaki TAsk filter() kısmını method referenca ile yapınız
    public static boolean ciftBul(int a) {
        return a % 2 == 0;
    }
    public static void printCiftElFunctional1(List<Integer> sayim) {
        sayim.
                stream().
                filter(Lambda01::ciftBul). //
                forEach(Lambda01::yazdir);
    }


    //--------------------------------------------------------------------------------

    //TASK  : structural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructural(List<Integer> sayim) {
        for (Integer w : sayim) {
            if (w % 2 == 0) {
                System.out.print(w + " "); //34 22 16 20 44 66 64 38
            }
        }
    }

    //------------------------------------------------------------------------------------------------------
    // TASK  : functional Programming ile list elemanlarinin 34den küçük cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftOtcKckFunctional(List<Integer> sayim) {
        sayim.
                stream().
                filter(t -> t % 2 == 0 && t < 34).
                forEach(Lambda01::yazdir);//22 16 20
    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtBykFunctional(List<Integer> sayim) {
        sayim.
                stream().
                filter(t -> t % 2 == 0 || t > 34).
                forEach(Lambda01::yazdir); //34 22 16 35 20 63 65 44 66 64 81 38
    }

}
