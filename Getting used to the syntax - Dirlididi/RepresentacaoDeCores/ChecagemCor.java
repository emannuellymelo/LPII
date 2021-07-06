public class ChecagemCor {
    public int r;
    public int g;
    public int b;

    public ChecagemCor(int er, int eg, int eb) {
        this.r = er;
        this.g = eg;
        this.b = eb;
    }

    public String toString() {
        if((this.r & this.g & this.b) >= 128) {
            return "BRANCO";
        } else {
            return "PRETO";
        }
    }

}