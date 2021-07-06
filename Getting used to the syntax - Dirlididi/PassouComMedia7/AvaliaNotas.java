public class AvaliaNotas {
    private float n1;
    private float n2;
    private float media;

    public AvaliaNotas(String nota1, String nota2) {
        this.n1 = Float.parseFloat(nota1);
        this.n2 = Float.parseFloat(nota2);
        calculaMedia();
    }

    public void calculaMedia() {
        this.media = (this.getNota1() + this.getNota2())/2;
        toString();
    }

    public String toString() {
        if(this.getMedia() >= 7f) {
            return "pass: True!";
        } else {
            return "pass: False!";
        }
    }

    public float getNota1() {
        return this.n1;
    }

    public float getNota2() {
        return this.n2;
    }

    public float getMedia() {
        return this.media;
    }
    
}