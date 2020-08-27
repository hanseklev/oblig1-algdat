package no.oslomet.cs;

import no.oslomet.cs.algdat.Oblig1;

public class Main {

    public static void main(String[] args) {
	// kjør statiske greier her

        int[] b = {5, 2, 8, 4, 7, 6};
        Oblig1.maks(b);

        Oblig1.ombyttinger(b);
       // System.out.println(Oblig1.ombyttinger(b));

        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(a);
        Oblig1.rotasjon(a,-2);
        System.out.println(a);
    }
}
