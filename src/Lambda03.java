import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*DERS SIRASI SORULARI
  1-Argüman ve parametre arasında ki fark
*/
public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "güvec", "kokorec",
                "küşleme", "arabAşı", "waffle", "künefe", "güvec"));

        alfBykTekrsz(menu);
        chrSayisiTersSiraliUniq(menu);
        chrSayisiBykSirali(menu);
        harfSyisi7denAzKontrol(menu);
        wIleBaslayan(menu);
        xIleBiten(menu);
        chrSyisiEnBykElYazdir(menu);
    }

    //TASK-1: List elemanlarını alfabetik, byüyük harf ve tekrarsız print ediniz
    public static void alfBykTekrsz(List<String> yemek) {
        yemek.
                stream().
                map(String::toUpperCase).
                sorted().
                distinct().
                forEach(t -> System.out.print(t + " "));//ARABAŞI GÜVEC HAVUCDİLİM KOKOREC KÜNEFE KÜŞLEME TRİLEÇE WAFFLE
        System.out.println();
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSiraliUniq(List<String> ikram) {
        ikram.stream().
                map(String::length).  //akışı kelimelerin uzunluğuna çevirdim
                sorted(Comparator.reverseOrder()). //ters sıralı
                distinct(). // tekrarsız yaptık
                forEach(Lambda01::yazdir);
        System.out.println();

    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBykSirali(List<String> ikram) {
        ikram.stream().
                sorted(Comparator.comparing(String::length)). //String ifadeleri karakter sayılarına göre k>b sıraladık
                forEach(Lambda01::yazdir);
        System.out.println();

    }
// ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin hepdinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSyisi7denAzKontrol(List<String> ikram) {
        String s = ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanmları 7 ve daha az harften oluşuyor" : "list elemanları 7 harften büyük";
        System.out.println(s);
    }

    //// Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayan(List<String> ikram) {
        String s1 = ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile başlayan yok" : "w ile başlayan var";
        System.out.println(s1);
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBiten(List<String> ikram) {
        String s2 = ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten var" : "x ile biten yok";
        System.out.println(s2);
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void chrSyisiEnBykElYazdir(List<String> ikram) {
        Stream<String> s3 = ikram.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()). //Karakter sayısına göre tersten sıraladı
                        limit(1);// limit metodu kullanarak sadece ilk eleman çağrıldı. Limit()'in dönen data türü Stream'dir.
                        /*toString(); //ekrana yazdırmak için IntelliJ kendisi düzltme yaparak bu metodeu ekledi*/
        System.out.println(Arrays.toString(s3.toArray()));
        //s3.toArray()--> Stream sınıfından olan akış Array'a çevrildi.
        //Arrays.toString(s3.toArray()) --> Array'e çevriloen yapı String yapıya çevrildi.

    }
//TASK-8:List elemanlrını son harfine gçre sıralayıp ilk eleman hariç kalan elemanlrını print ediniz
    public static void task8(List<String> ikram){
        ikram.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). //son harfine göre alfabetik sıralandı
                skip(1). // akıştaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdir);
    }

}