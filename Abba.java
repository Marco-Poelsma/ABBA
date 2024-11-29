//Este programa arregla los problemas con casos de nombres que incluyen " i ".
import java.text.Normalizer;
import java.util.*;
import java.lang.String;

public class Abba {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int iteracions = scan.nextInt();
        String clearCache = scan.nextLine();
        for (int i = 0; i < iteracions; i++) {
            String input = scan.nextLine();
            String[] noms = input.split(", ");
            char[] inicials = new char[noms.length+1];
            for (int j = 0; j < noms.length - 1; j++) {
                inicials[j] = noms[j].charAt(0);
            }
            inicials[noms.length-1] = noms[noms.length-1].charAt(0);
            String ultimaInicial[] = noms[noms.length-1].split(" i ");
            inicials[noms.length] = ultimaInicial[ultimaInicial.length-1].charAt(0);
            for (int j = 0; j < inicials.length; j++) {
                inicials[j]= flattenToAscii(String.valueOf(inicials[j])).charAt(0);
                System.out.print(inicials[j]);
            }
            System.out.println();
        }
    }
    public static String flattenToAscii(String string) {
        StringBuilder sb = new StringBuilder(string.length());
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        for (char c : string.toCharArray()) {
            if (c <= '\u007F') sb.append(c);
        }
        return sb.toString();
    }
}
