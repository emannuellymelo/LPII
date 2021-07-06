import java.util.Scanner;

public class MaiorMenor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int primeiro = sc.nextInt();
        int segundo = sc.nextInt();
        int terceiro = sc.nextInt();
        int quarto = sc.nextInt();
        int quinto = sc.nextInt();

        CalculaDiferenca diferenca = new CalculaDiferenca(primeiro, segundo, terceiro, quarto, quinto);
        System.out.println(diferenca.Diferenca());
    }
    
}