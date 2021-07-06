import java.util.Scanner;
public class PassouComMediaSete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nota1 = sc.nextLine();
        String nota2 = sc.nextLine();
        AvaliaNotas aprovacao = new AvaliaNotas(nota1, nota2);
        System.out.println(aprovacao);
    }
    
}