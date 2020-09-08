package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {
    }

    /**
     * OBLIG 1
     * Hans Erling Klevstad, s341872
     * Brian Banne, s329333
     *
     *
     *
     *
     * * * OPPGAVE 1 * * *
     * Naar blir det flest ombyttinger?
     *        -metoden vil ha flest ombyttinger nar arrayet er omvendt sortert synkede max -> min
     *
     * Naar blir det faerrest?
     *      det blir minst ombyttinger når metoden står i stigene rekkefolge
     *
     * Hvor mange blir det i gjennomsnitt?
     *           o(n^2)
     */

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new java.util.NoSuchElementException("Arrayet " + Arrays.toString(a) + " er tomt");
        }
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                int midlertidig = a[i];
                a[i] = a[i + 1];
                a[i + 1] = midlertidig;
            }
        }
        return a[a.length - 1];
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
            throw new IllegalStateException("\nArrayet må vaere sortert i stigende rekkefolge");
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

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int n) {
        n *= -1;//invertere rotasjonsretning
        int size = a.length;
        int j, m;
        char temp;

        if (size < 2) return;
        if ((n %= size) < 0) n += size;

        for (int i = 0; i < gcd(size, n); i++) {
            temp = a[i];
            j = i;
            while(true){
                m = j + n;
                if (m >= size) m = m - size;
                if (m==i) break;
                a[j] = a[m];
                j=m;
            }
            a[j] = temp;
        }
    }

    private static int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
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
        final int MAX_STRING_LENGDE = 30; // grense for hvor lang en string kan vaere
        char[] mergedArray = new char[getStringArrayLength(s)];
        int k = 0;

        for (int i = 0; i < MAX_STRING_LENGDE; i++) {
            for (String value : s) {
                char[] currentWord = value.toCharArray();
                if (currentWord.length <= i)
                    continue; //hopper til neste ord hvis det ikke er flere bokstaver igjen på gitt plass
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
        if (a.length == 0) {
            return new int [0];
        }

        //Kloner array og returner sortert
        int [] clone = a.clone();
        int [] index = new int[a.length];
        for (int n = clone.length; n > 1; n--)
        {
            for (int i = 1; i < n; i++)
            {
                if (clone[i - 1] > clone[i]){
                    int temp = clone[i-1];
                    clone[i-1] = clone[i];
                    clone[i] = temp;
                }
            }
        }

        int count = 0;
        int MAX = Integer.MAX_VALUE;
        index[a.length-1] = MAX; //setter siste verdi vaktpost

        //sammenligner verdier fra orig. array med sortert klone
        while(index[a.length-1] == MAX) {
            int j = 0;
            for (int i = j; i < a.length; i++) {
                if (a[i] == clone[count] && count < a.length - 1) {
                    index[count] = i;
                    count++;
                } else if (a[i] == clone[count]) {
                    index[count] = i;
                }
            }
        }
      return index;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        int n = a.length;
        if (n < 3) throw new NoSuchElementException("Array må ha minst 3 verdier");

        //Indeksvariabler
        int ia, ib, ic;

        int[] indexArr = new int[3];
        System.arraycopy(a, 0, indexArr, 0, 3);
        indexArr = indekssortering(indexArr);
        ia = indexArr[0];
        ib = indexArr[1];
        ic = indexArr[2];


        int va = a[ia], vb = a[ib], vc = a[ic]; //setter verdiene sorter for de tre forste ineksene

        for (int i = 3; i < n ; i++) {
            if (a[i] < vc){
                if (a[i] < vb){
                    if(a[i] < va){ //Setter ny verdi på alle tre hvis a[i] er storre enn alle tre
                        ic = ib; //c "arver" verdien fra b
                        vc = a[ic];

                        ib = ia; //b "arver" verdien fra a
                        vb = va;

                        ia = i;
                        va = a[ia];
                    } else {
                        ic = ib;
                        vc = a[ic];

                        ib = i;
                        vb = a[ib];
                    }
                } else {
                    ic = i;
                    vc = a[ic];
                }
            }
        }
       return new int[] {ia, ib, ic};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }
}
