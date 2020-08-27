package no.oslomet.cs;

import no.oslomet.cs.algdat.Oblig1;

public class Main {

    public static void main(String[] args) {
	// kjør statiske greier her

        int[] c = {6, 5, 4, 3, 2, 1};
        Oblig1.maks(c);

        int[] b= {1, 2, 3, 4, 5};
        Oblig1.ombyttinger(b);


        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(a);
        Oblig1.rotasjon(a,-2);
        System.out.println(a);
    }
}
