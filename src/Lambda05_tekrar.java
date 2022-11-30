import java.util.stream.IntStream;

public class Lambda05_tekrar {

    public static void main(String[] args) {

        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(ciftTamSayi(5));
        System.out.println(ilk4CiftTamSayi(4));
        //System.out.println(ilk4CiftTamSayi2YOL(4));
        System.out.println(ilk4TekTamSayi2YOL(4));
        ikininKuvvetleri(3);
        System.out.println();
        //sayininKuvveti(2,3);
        System.out.println();
        //System.out.println(istenenSayiFactorial(5));
    }
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
    // tamsayilari toplayan bir program create ediniz.

    //Structered
    public static int topla(int x){
        int toplam =0;
        for (int i =0 ; i<=x ; i++){
            toplam +=i;
        }
        return toplam;
    }
    //FUNCTIONAL
    public static int toplaCincix(int x){
        return IntStream.range(1,x+1).sum();
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftTamSayi(int x){
        return IntStream.range(1,x).filter(t->t%2==0).sum();
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilk4CiftTamSayi(int x){
        return IntStream.range(2,(2*x)+1).filter(Lambda01::ciftBul).sum();

    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilk4TekTamSayi2YOL(int x){
        return IntStream.iterate(1,t->t+2).sum();
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininKuvvetleri(int x){
       IntStream.iterate(2, t -> t * 2).limit(x).forEach(Lambda01::yazdir);

    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void sayininKuvveti(int istenenSayi,int x){
       IntStream.iterate(istenenSayi,t->istenenSayi*t).limit(x).forEach(Lambda01::yazdir);

    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    // 5 --> 5*4*3*2     3 --> 3*2
    /*public static int istenenSayiFactorial(int x) {  // 5

    }*/
        }
