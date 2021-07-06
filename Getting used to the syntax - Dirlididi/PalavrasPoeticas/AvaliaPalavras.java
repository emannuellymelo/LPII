public class AvaliaPalavras {
    public String p1;
    public String p2;
    public String[] letras1;
    public String[] letras2;
    public int i;

    public AvaliaPalavras(String palavra1, String palavra2) {
        this.p1 = palavra1;
        this.p2 = palavra2;
        this.i = 0;
        this.letras1 = new String[p1.length()];
        this.letras2 = new String[p2.length()];
    }

    public void SeparaLetras() {
        while(true) {
            for(String letra:p1.split("")){
                this.letras1[i] = letra;
                if(i == (letras1.length-1)) {
                    break;
                }
                i+=1;
            }
            i = 0;
            for(String letra:p2.split("")) {
                this.letras2[i] = letra;
                if(i == (letras2.length-1)) {
                    break;
                }
                i+=1;
            }
            break;
        }
        
    }

    public String toString() {
        if(letras1[0].equals(letras2[0]) && letras1[letras1.length-1].equals(letras2[letras2.length-1])){
            return "S";
        } else{
            return "N";
        }
    }
}