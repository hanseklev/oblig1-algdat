package no.oslomet.cs;

import no.oslomet.cs.algdat.Oblig1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // kjør statiske greier her

/*
        int[] c = {};
        Oblig1.maks(c);

        int[] b= {1, 2, 3, 4, 5};
        Oblig1.ombyttinger(b);
        int[] d = {1, 2, 3, 4, 5};
        Oblig1.antallUlikeSortert(d);

 */
        int [] d = {9,5,2,4,2,7,-2,-5, 3, 1, 10};
        System.out.println(Arrays.toString(d));
        Oblig1.delsortering(d);
        System.out.println(Arrays.toString(d));



       /*    char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(a);
        Oblig1.rotasjon(a,-2);
        System.out.println(a);


        //int[] e = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int [] b = {5, 3};
        System.out.print(Oblig1.antallUlikeUsortert(b));


        System.out.println(Oblig1.flett("AM ", "L", "GEDS", "ORAKTRR", "", "R TRTE", "IO", "TGAUU"));

*/
    }
}
