package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Oblig1 {
    private Oblig1() {
    }


    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new java.util.NoSuchElementException("Arrayet " + Arrays.toString(a) + " er tomt");
        }
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i+1]) {
                int midlertidig = a[i];
                a[i] = a[i + 1];
                a[i + 1] = midlertidig;
            }
        }
        return a[a.length - 1];
        // metoden vil ha flest ombyttinger nar arrayet er omvendt sortert.
        // altsa størst forst og minst sist

        // det blir minst ombyttinger når metoden står i stigene rekkefolge

        //o(n*n)
    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new java.util.NoSuchElementException("Arrayet " + Arrays.toString(a) + " er tomt");
        }

        int n = a.length;
        int teller = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i+1]) {
                int midlertidig = a[i];
                a[i] = a[i + 1];
                a[i + 1] = midlertidig;
                teller++;
                }
        }
        return teller;
    }


    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        } else if (a.length== 1) {
            return 1;
        }

        if (a[a.length-1] < a[a.length-2]) {
            throw new IllegalStateException("\nArrayet må være sortert i stigende rekkefolge");
        }
        int tallteller = 1;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                tallteller++;
            }
        }
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
        if (a.length == 0) {
            return;
        }

        int oddetall = 0;
        int partall = a.length-1;

        //sorterer oddetall til venstre
        while (oddetall < partall) {

            while (oddetall < partall && a[oddetall] % 2 != 0) {
                oddetall++;
            }
            while (oddetall < partall && a[partall] % 2 == 0) {
                partall--;
            }
            if (oddetall < partall) {
                int temp = a[oddetall];
                a[oddetall] = a[partall];
                a[partall] = temp;
            }
        }
        if (partall == a.length-1) kvikksortering(a, 0, a.length-1);
        else {
            kvikksortering(a, 0, oddetall-1);
            kvikksortering(a, oddetall, a.length - 1);
        }
    }

    private static void kvikksortering(int[] a, int begin, int end)
    {
        if (begin < end) {
            int idx = partisjoner(a, begin, end);
            kvikksortering(a, begin, (idx - 1));
            kvikksortering(a, (idx + 1), end);
        }
    }

    private static int partisjoner(int[] a, int begin, int end){
        int pivot = a[end];
        int i = (begin - 1);

        for (int j = begin; j < end ; j++) {

            if (a[j] <= pivot){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[end];
        a[end] = temp;

        return i+1;
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
        int[] c={};
        if (a.length == 0) {
            return c;
        }

        int [] index = new int[a.length];

        int[] dettefunker = IntStream.range(0,a.length)
                .boxed().sorted((i,j) -> a[i] - a[j])
                .mapToInt(ele -> ele).toArray();

        return dettefunker;
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

    //Tut og kjor


}
