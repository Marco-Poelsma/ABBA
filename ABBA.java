import java.text.Normalizer;
import java.util.Scanner;

public class ABBA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casos;
        String text;
        do {
            casos = input.nextInt();
            input.nextLine();
        } while (casos > 100);
        for (int i = 0; i < casos; i++) {
            text = input.nextLine();

            // Eliminar acentos y convertir a mayusculas
            text = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();

            // Sustituir i por comas
            text = text.replace(" I ", ", ");

            // Separar nombres por comas
            String[] noms = text.split(",\\s*");

            // Construir las iniciales de los nombres
            StringBuilder inicials = new StringBuilder();
            for (String nom : noms) {
                inicials.append(nom.charAt(0)); // Coger solo la primera letra
            }

            System.out.println(inicials.toString());
        }
    }
}