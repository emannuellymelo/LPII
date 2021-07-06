import java.util.Scanner;
public class ProcuraWally {
    private String[] nomes;
    private int quantidade;
    private String suspeito;
    private boolean aviso;

    public ProcuraWally() {
        this.nomes = new String[100];
    }

    public void analisaNomes() {
        Scanner sc = new Scanner(System.in);
        this.setSuspeito("");
        while(true) {
            this.setQuantidade(0);
            String entrada = sc.nextLine();
            for(String nome:entrada.split(" ")){
                if(nome.equals("wally")) {
                    this.aviso = true;
                } else {
                    this.nomes[this.getQuantidade()] = nome;
                    this.setQuantidade(this.getQuantidade()+1);
                }
            }
            if(this.aviso) {
                break;
            }
            for(int a = 0; a < this.getQuantidade(); a++) {
                if(this.nomes[a].length() == 5) {
                    this.setSuspeito(this.nomes[a]);
                } else if(this.getSuspeito().length() == 0) {
                    this.setSuspeito("?");
                }
            }
            System.out.println(this.getSuspeito());
        }
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int qtd) {
        this.quantidade = qtd;
    }

    public String getSuspeito() {
        return this.suspeito;
    }

    public void setSuspeito(String susp) {
        this.suspeito = susp;
    }
       
}