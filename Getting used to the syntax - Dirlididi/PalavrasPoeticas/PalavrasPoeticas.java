import java.util.Scanner;

public class PalavrasPoeticas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra1 = sc.nextLine();
        String palavra2 = sc.nextLine();

        AvaliaPalavras checar = new AvaliaPalavras(palavra1, palavra2);
        checar.SeparaLetras();
        System.out.println(checar.toString());
        
    }
}