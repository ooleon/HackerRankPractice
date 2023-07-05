package com.example.demo;

import java.util.ArrayList;
import java.util.List;

 class GigaShop {
    protected int  number=1;
    void metodo(){
        System.out.println("GigaShop");
    }

}

class MegaShop extends GigaShop {
    static protected int  number=56;

    void metodo(){
        System.out.println("MegaShop");
    }

}
class SuperShop extends MegaShop{
    protected int  number=42;
    void metodo(){
        System.out.println("SuperShop");
    }

}

public class Shop extends SuperShop {

    public static void main(String[] args) {
        System.out.println("version: " + Runtime.version());        
        
        Shop sp = new Shop() ;
        System.out.println(sp.getClass().getName());
        GigaShop gs1 = new GigaShop();
        GigaShop gs;
        gs = (GigaShop) sp;
        gs.metodo();
        System.out.println(gs1.getClass().getName());
        List<GigaShop> l = new ArrayList();
        l.add(gs1);
        l.add(gs);


/*
        MiLambda ml, ml1, ml2;
        ml2 = x -> System.out.println(x);

        ml1 =  (int x ) -> {
        };
        ml1 = (int x ) -> x+1;
        ml = (int x ) -> x+1;
        Shop sp = new Shop();
        sp.printN_Clases();
        System.out.println(ml2.pint(333));
        System.out.println(ml1.pint(3));
        System.out.println(ml.pordefecto(3));
*/
        //        sp.printN_conThis();
//        sp.printN_conSuper();
    }
    private void printN_Clases(){
        System.out.println( super.getClass().getSuperclass() );
    }

    public void printN_conThis(){
        System.out.println(this.number);
    }
    public void printN_conSuper(){System.out.println(super.number);}
    void metodo(){
        System.out.println("Shop");
    }




}
@FunctionalInterface
interface MiLambda{
    void pint(int x);

    default int pordefecto() {
        return pordefecto(0);
    }

    default int pordefecto(int x){
        return x*x;
    };
}

interface MiLambdaInt extends MiLambda{
    void pont(int x);

}
