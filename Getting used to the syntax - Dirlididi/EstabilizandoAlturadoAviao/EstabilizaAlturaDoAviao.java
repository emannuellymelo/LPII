import java.util.Scanner;
public class EstabilizaAlturaDoAviao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int altura_ideal = sc.nextInt();
        int altura_real = sc.nextInt();
        EstabilizaAviao avia1 = new EstabilizaAviao(altura_ideal,altura_real);
    }
}