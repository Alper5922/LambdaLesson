import java.util.*;
import java.util.stream.Collectors;

public class Lambda04_tekrar {

    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */
    public static void main(String[] args) {
        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bilg muh", 1080, 77);
        Universite u05 = new Universite("odtu", "gemi mh", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println(matBolVarMi(unv));
        System.out.println(unvSirala(unv));
        System.out.println("mathBolSayisi  "+mathBolSayisi(unv));
        System.out.println("ogrSays550  "+ogrSays550(unv));
        System.out.println("ogrSays1050  "+ogrSays1050(unv));
    }

    //task 01--> Bütün üniversitelerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {
        return unv. stream(). map(t->t.getNotOrt()).allMatch(t-> t>74);
    }


     /* TASK-2: Üniversitelerin herhangibirinde matematik olup olmadığını kontrol eden kod yazın
     */
    public static boolean matBolVarMi(List<Universite> unv) {
        return unv.stream().map(t->t.getBolum()).anyMatch(t->t=="matematik");
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> unvSirala(List<Universite> unv) {
        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrSyisi).reversed()).
                collect(Collectors.toList());
    }

    //TASK-4 : MAtematik bölümlerinin sayılarını print ediniz
    public static long mathBolSayisi(List<Universite> unv) {
        return unv.stream().map(t->t.getBolum()).count();

    }
    //TASK 5 : Öğrenci sayıları 550 den fazla aolan üni lerin en büyük notORT bulunuz
    public static OptionalInt ogrSays550(List<Universite> unv){
        return unv.stream().
                filter(t->t.getOgrSyisi()>550).
                mapToInt(t->t.getOgrSyisi()).max();
    }

    //TASK 6 : Öğrenci sayıları 1050 den az aolan üni lerin en küçük notORT bulunuz
    public static OptionalInt ogrSays1050(List<Universite> unv){
        return unv.stream().
                filter(t->t.getOgrSyisi()<1050).
                mapToInt(t->t.getNotOrt()).
                min();
    }
}
