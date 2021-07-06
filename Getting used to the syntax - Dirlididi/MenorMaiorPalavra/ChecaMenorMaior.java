public class ChecaMenorMaior {
    public String[] todas;
    public int contmenor;
    public String menor;
    public int contmaior;
    public String maior;

    public ChecaMenorMaior(String p1, String p2, String p3, String p4, String p5) {
        this.todas = new String[5];
        this.todas[0] = p1;
        this.todas[1] = p2;
        this.todas[2] = p3;
        this.todas[3] = p4;
        this.todas[4] = p5;
    }
    
    public void ChecarMenor() {
        this.contmenor = this.todas[0].length();
        this.menor = this.todas[0];
        for(int a = 0; a < this.todas.length; a++) {
            if(this.todas[a].length() < this.contmenor) {
                this.contmenor = this.todas[a].length();
                this.menor = this.todas[a];
            }
        }
    }
    public void ChecarMaior() {
        this.contmaior = this.todas[0].length();
        this.maior = this.todas[0];
        for(int b = 0; b < this.todas.length; b++) {
            if(this.todas[b].length() > this.contmaior) {
                this.contmaior = this.todas[b].length();
                this.maior = this.todas[b];
            }
        }
    }

    public String toString() {
        return this.menor + "\n" + this.maior;
    }

}