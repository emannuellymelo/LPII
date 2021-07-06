import java.util.Scanner;

public class MenorMaiorPalavra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String primeira = sc.nextLine();
        String segunda = sc.nextLine();
        String terceira = sc.nextLine();
        String quarta = sc.nextLine();
        String quinta = sc.nextLine();

        ChecaMenorMaior saida = new ChecaMenorMaior(primeira, segunda, terceira, quarta, quinta);
        saida.ChecarMenor();
        saida.ChecarMaior();
        System.out.println(saida.toString());
    }
    
}