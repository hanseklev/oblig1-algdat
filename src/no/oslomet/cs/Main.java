package no.oslomet.cs;

import no.oslomet.cs.algdat.Oblig1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // kjør statiske greier her

        int [] abc = randPerm(25_000);
        //System.out.println(Arrays.toString(abc));
        long tid = System.currentTimeMillis();
        int [] sortert = Oblig1.indekssortering(abc);
        tid =  System.currentTimeMillis() - tid;
        System.out.println("TId: " + tid  + " ms");
        //System.out.println(Arrays.toString(sortert));


/*



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
