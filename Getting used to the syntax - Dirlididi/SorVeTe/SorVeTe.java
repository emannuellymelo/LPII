import java.util.Scanner;

public class SorVeTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int v1 = sc.nextInt();
        int s2 = sc.nextInt();
        int v2 = sc.nextInt();
        int t = sc.nextInt();

        CalculaDistancia corpos = new CalculaDistancia(s1,v1,s2,v2,t);
        System.out.println(corpos.Distancia());
           
    }
}