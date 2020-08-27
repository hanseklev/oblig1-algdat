package no.oslomet.cs;

import no.oslomet.cs.algdat.Oblig1;

public class Main {

    public static void main(String[] args) {
	// kjør statiske greier her
        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(a);
        Oblig1.rotasjon(a,-2);
        System.out.println(a);
    }
}
