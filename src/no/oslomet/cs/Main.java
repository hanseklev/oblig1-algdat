package no.oslomet.cs;

import no.oslomet.cs.algdat.Oblig1;

import java.util.Arrays;
import java.util.Random;

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


        int [] d = {11, 9, 1, 15, -3};
        System.out.println(Arrays.toString(d));
        long tid = System.currentTimeMillis();
        Oblig1.delsortering(d);
        //Oblig1.kvikksortering(d , 0, d.length-1);

        tid = System.currentTimeMillis() - tid;
        System.out.println(Arrays.toString(d));
        System.out.println("Tid:" + tid);




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

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall
        for (int i = 0; i < n; i++)
            a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k

            int temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }

        return a;                        // permutasjonen returneres
    }
}
