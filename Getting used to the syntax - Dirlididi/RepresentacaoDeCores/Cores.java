import java.util.Scanner;

public class Cores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada_r = sc.nextInt();
        int entrada_g = sc.nextInt();
        int entrada_b = sc.nextInt();

        ChecagemCor entrada = new ChecagemCor(entrada_r, entrada_g, entrada_b);
        System.out.println(entrada.toString());
        
    }
}