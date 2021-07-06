import java.util.Scanner;

public class InicioDaVogal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String primeira = sc.nextLine();
        String segunda = sc.nextLine();
        String terceira = sc.nextLine();
        String quarta = sc.nextLine();
        String quinta = sc.nextLine();

        ChecaVogal saida = new ChecaVogal(primeira, segunda, terceira, quarta, quinta); 
        System.out.println(saida.toString());
    }
    
}