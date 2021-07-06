public class CalculaDistancia {
    public int pos1;
    public int vel1;
    public int pos2;
    public int vel2;
    public int tempo;
    public int distancia1;
    public int distancia2;

    public CalculaDistancia(int s1, int v1, int s2, int v2, int t) {
        this.pos1 = s1;
        this.vel1 = v1;
        this.pos2 = s2;
        this.vel2 = v2;
        this.tempo = t;
    }

    public int Distancia() {
        distancia1 = pos1 + vel1 * tempo;
        distancia2 = pos2 + vel2 * tempo;
        return Math.abs(distancia2 - distancia1);
    }
}