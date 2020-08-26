package no.oslomet.cs.algdat;

public class Oblig1 {
    private Oblig1(){}


    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        throw new UnsupportedOperationException();
    }

    public static int ombyttinger(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length == 0) return; //hvis tabellen er tom returner metoden arrayet uten modifikasjoner
        char siste = a[a.length-1];
        int j;
        for (j = a.length-1; j > 0 ; j--) {
            a[j]=a[j-1];
        }
        a[0] = siste;
    }

    //TODO: EFFECTIVE, (gcd)?

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        if (a.length == 0) return; //hvis tabellen er tom returner metoden arrayet uten modifikasjoner

        if (k > 0) roterHoyre(a, k);
        if (k< 0) roterVenstre(a, k);
/*
        char siste = a[a.length - 1];
        int j;
        for (j = a.length-1; j > 0 ; j--) {
            a[j]=a[j-1];
        }
        a[0] = siste;*/
    }

    private static void roterHoyre(char[] a, int antall){
        for (int i = 0; i < antall; i++) {
            char siste = a[a.length-1];
            int j;

            for (j = a.length-1; j > 0 ; j--) {
                a[j]=a[j-1];
            }
            a[0] = siste;
        }
    }

    private static void roterVenstre(char[] a, int antall){
        int k = Math.abs(antall);
        for (int i = 0; i < k; i++) {
            char first = a[0];

            int j;
            for (j = 0; j < a.length -1 ; j++) {
                a[j] = a[j + 1];
            }
            a[a.length-1] = first;
        }

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

    //Tut og kjør



}
