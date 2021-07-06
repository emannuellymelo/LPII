import java.util.Scanner;

public class ColetaDados {
    private String dados;
    private String[] banco;
    private int quantidade;
    private int nota;
    private int soma;
    private int maior;
    private int menor;
    private int acima;
    private int abaixo;

    public ColetaDados() {
        this.banco = new String[100];
        this.quantidade = 0;
        this.soma = 0;
        coletarEntrada();
    }

    public void coletarEntrada() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            this.dados = sc.nextLine();
            if(this.dados.equals("-")) {
                break;
            } else {
                aumentaBanco();
                for(String info:this.dados.split(" ")) {
                    this.banco[this.getQuantidade()] = info;
                    this.setQuantidade(this.getQuantidade() + 1);
                }
            }
        }
        coletarNotas();
    }

    public void coletarNotas() {
        this.maior = Integer.parseInt(this.banco[1]);
        this.menor = Integer.parseInt(this.banco[1]);
        for(int a = 0; a < this.getQuantidade(); a++) {
            if(a%2 != 0) {
                this.nota = Integer.parseInt(this.banco[a]);
                this.setSoma(this.getSoma() + this.getNota());
        
                if(this.getNota() > this.getMaior()) {
                    this.setMaior(this.getNota());
                }
                if(this.getNota() < this.getMenor()) {
                    this.setMenor(this.getNota());
                }
                if(this.getNota() >= 700) {
                    this.setAcima(this.getAcima() + 1);
                } 
                if(this.getNota() < 700) {
                    this.setAbaixo(this.getAbaixo() + 1);
                }
            }
        }
    }

    public void aumentaBanco() {
        if(this.quantidade == this.banco.length) {
            String[] novoBanco = new String[2 * banco.length];
            for(int c = 0; c < this.banco.length; c++ ) {
                novoBanco[c] = this.banco[c];
            }
            this.banco = novoBanco;
        }
    }
    
    public String toString() {
        return "maior: " + this.getMaior() + "\nmenor: " + this.getMenor() + "\nmedia: " + this.getMedia() + "\nacima: " + this.getAcima()+ "\nabaixo: " + this.getAbaixo();
    }

    public int getMedia() {
        return this.getSoma()/(this.getQuantidade()/2);
    }

    public int getSoma() {
        return this.soma;
    }

    public void setSoma(int n) {
        this.soma = n;
    }
    public int getMaior() {
        return this.maior;
    }
    public void setMaior(int m) {
        this.maior = m;
    }
    public int getMenor() {
        return this.menor;
    }
    public void setMenor(int mnr) {
        this.menor = mnr;
    }
    public int getNota() {
        return this.nota;
    }
    public int getAcima() {
        return this.acima;
    }
    public void setAcima(int acmedia) {
        this.acima = acmedia;
    }
    public int getAbaixo() {
        return this.abaixo;
    }
    public void setAbaixo(int abmedia) {
        this.abaixo = abmedia;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(int q) {
        this.quantidade = q;
    }
}