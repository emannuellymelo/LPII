import java.util.Scanner;

public class EstabilizaAviao {
    private int ideal;
    private int altura;
    private int aproximacao_anterior;
    
    public EstabilizaAviao(int alvo, int real) {
        this.ideal = alvo;
        this.altura = real;
        checaAproximacao();
        avaliaAltura();
    }

    public void avaliaAltura() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            this.setAltura(sc.nextInt());
            if (this.getAltura() == this.getIdeal()) {
                break;
            }
            if(this.getAproximacaoAnterior() < this.getAproximacaoAtual()) {
                System.out.println("PERIGO");
            } else {
                System.out.println("ADEQUADO");
            }
            checaAproximacao();
        }
        System.out.println("OK");
    }

    public void checaAproximacao() {
        this.setAproximacaoAnterior(this.getAproximacaoAtual());
    }

    public int getAproximacaoAtual() {
        return Math.abs(this.getIdeal() - this.getAltura());
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int alt) {
        this.altura = alt;
    }

    public int getIdeal() {
        return this.ideal;
    }

    public int getAproximacaoAnterior() {
        return this.aproximacao_anterior;
    }

    public void setAproximacaoAnterior(int apx) {
        this.aproximacao_anterior = apx;
    }
    
}