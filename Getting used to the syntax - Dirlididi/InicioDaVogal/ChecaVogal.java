public class ChecaVogal {
    public String[] palavras;

    public ChecaVogal(String p1, String p2, String p3, String p4, String p5) {
        this.palavras = new String[5];
        this.palavras[0] = p1;
        this.palavras[1] = p2;
        this.palavras[2] = p3;
        this.palavras[3] = p4;
        this.palavras[4] = p5;
        avaliarPrimeira();
    }

    public void avaliarPrimeira() {
        for(int a = 0; a < this.palavras.length; a++){
            for(String letra:palavras[a].split("")) {
                if(letra.equals("a")) {
                    this.palavras[a] = "s";
                } else {
                    this.palavras[a] = "n";
                }
                break;
            }
        }
    }
    public String toString() {
        return this.palavras[0] + "\n" + this.palavras[1] + "\n" + this.palavras[2] + "\n" + this.palavras[3] + "\n" + this.palavras[4];
    }
    
}