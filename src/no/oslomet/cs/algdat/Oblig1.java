package no.oslomet.cs.algdat;

import java.util.Arrays;

public class Oblig1 {
    private Oblig1() {
    }


    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        sjekkarraylengde(a);
        int n = a.length;
        int teller = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                if (a[j] > a[j + 1]) {
                    int midlertidig = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = midlertidig;
                    teller++;
                }
            }
        }
        return a[a.length - 1];
        // metoden vil ha flest ombyttinger når arrayet er omvendt sortert.
        // altså størst først og minst sist

        // det blir minst ombyttinger når metoden står i stigene rekkefolge

        //o(n*n)
    }

    // dette er feil måte å ta avvik
    private static void sjekkarraylengde(int[] a) {
        if (a == null) {
            throw new java.util.NoSuchElementException("Arrayen " + Arrays.toString(a) + " er tom");
        }
    }

    // int[] e, f gir feil resultater
    // blir ikke riktig opptelling for a,c,d
    public static int ombyttinger(int[] a) {
        sjekkarraylengde(a);
        int n = a.length;
        int teller = 0;
        boolean bytt;


        for (int i = 0; i < n - 1; i++) {
            bytt = false;
            for (int j = 0; j < (n - i - 1); j++) {
                if (a[j] > a[j + 1]) {
                    int midlertidig = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = midlertidig;
                    bytt = true;
                    teller++;
                }
            }
            if (bytt = false) {
                break;
            }
        }
        return teller;
    }


    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        try {
            maks(a);
        } catch (Exception e) {
            throw new IllegalStateException("\nArrayet må være sortert i stigende rekkefolge");
        }
        int tallteller = 1;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                tallteller++;
            }
        }
        System.out.println(tallteller);
        return tallteller;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int talltaller = 1;
        int n = a.length;
        if (n == 0) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
            if (i == j) {
                talltaller++;
            }
        }
        return talltaller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length == 0) return; //hvis tabellen er tom returner metoden arrayet uten modifikasjoner
        char siste = a[a.length - 1];
        int j;
        for (j = a.length - 1; j > 0; j--) {
            a[j] = a[j - 1];
        }
        a[0] = siste;
    }

    //TODO: EFFECTIVE, (gcd)?

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        if (a.length == 0) return; //hvis tabellen er tom returner metoden arrayet uten modifikasjoner

        if (k > 0) roterHoyre(a, k);
        if (k < 0) roterVenstre(a, k);
/*
        char siste = a[a.length - 1];
        int j;
        for (j = a.length-1; j > 0 ; j--) {
            a[j]=a[j-1];
        }
        a[0] = siste;*/
    }

    private static void roterHoyre(char[] a, int antall) {
        for (int i = 0; i < antall; i++) {
            char siste = a[a.length - 1];
            int j;

            for (j = a.length - 1; j > 0; j--) {
                a[j] = a[j - 1];
            }
            a[0] = siste;
        }
    }

    private static void roterVenstre(char[] a, int antall) {
        int k = Math.abs(antall);
        for (int i = 0; i < k; i++) {
            char first = a[0];

            int j;
            for (j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = first;
        }

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] mergedArray = new char[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            mergedArray[k++] = a[i++];
            mergedArray[k++] = b[j++];
        }
        //Legger til i merged array det som er til overs
        while (j < b.length) mergedArray[k++] = b[j++];
        while (i < a.length) mergedArray[k++] = a[i++];

        return charArraytoString((mergedArray));
    }

    /// 7b)
    public static String flett(String... s) {
        final int MAX_STRING_LENGDE = 30; // grense for hvor lang en string kan være
        char[] mergedArray = new char[getStringArrayLength(s)];
        int k = 0;

        for (int i = 0; i < MAX_STRING_LENGDE; i++) {
            for (int j = 0; j < s.length; j++) {
                char[] currentWord = s[j].toCharArray();
                if (currentWord.length <= i) continue; //hopper til neste ord hvis det ikke er flere bokstaver igjen på gitt plass
                mergedArray[k++] = currentWord[i];
            }
        }
        return charArraytoString(mergedArray);
    }

    ///     Hjelpemetoder oppgave 7     ///
    private static String charArraytoString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char str : arr) sb.append(str);
        return sb.toString();
    }

    private static int getStringArrayLength(String... s) {
        int sum = 0;
        for (String str : s) {
            sum += str.chars().count();
        }
        return sum;
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
