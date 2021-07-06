package lab2;

 /**
  * Representação de uma conta de laboratório que detém controle da quantidade de espaço utilizada pelo aluno.
  * 
  * @author Emannuelly Larissa Freitas de Melo - 119210167.
  *
  */

public class ContaLaboratorio {
	
	/**
	 * Identificação do laboratório em que terá as atividades do aluno registradas.
	 */
	private String nomeLab;
	
	/**
	 * Espaço destinado ao uso pelo aluno.
	 */
	private int cotaLab;
	
	/**
	 * Indica a quantidade de espaço que o aluno está utilizando.
	 */
	private int espaco;
	
	/**
	 * Define a cota padrão que o laboratório oferece.
	 */
	private final int COTA_PADRAO_LABORATORIO = 2000;
	
	/**
	 * Gera uma conta de laboratório a partir da identificação pelo seu nome e possui como padrão uma cota de 2000 megabytes. O espaço ocupado pelo aluno inicia zerado.
	 * 
	 * @param nomeLaboratorio identificação do laboratório em que o aluno terá suas atividades registradas.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLab = nomeLaboratorio;
		this.cotaLab = COTA_PADRAO_LABORATORIO;
	}
	
	/**
	 * Gera uma conta de laboratório a partir da identificação pelo seu nome e pela cota de espaço disponível para o aluno. O espaço utilizado pelo aluno inicia nulo.
	 * 
	 * @param nomeLaboratorio identificação do laboratório em que o aluno terá suas atividades registradas.
	 * @param cota quantidade de espaço destinada para a utilização do aluno.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLab = nomeLaboratorio;
		this.cotaLab = cota;
	}
	
	/**
	 * Controla a quantidade de espaço que foi consumida pelo aluno.
	 * 
	 * @param mbytes identificação em megabytes do espaço utilizado.
	 */
	public void consomeEspaco(int mbytes) {
		this.setEspaco(this.getEspaco() + mbytes);
	}
	
	/**
	 * Controla o espaço que foi liberado pelo usuário da conta do laboratório.
	 * 
	 * @param mbytes identificação em megabytes do espaço a ser liberado.
	 */
	public void liberaEspaco(int mbytes) {
		this.setEspaco(this.getEspaco() - mbytes);
	}
	
	/**
	 * Informa se a cota de armazenamento foi alcançada pelo aluno.
	 * 
	 * @return true, caso o espaço máximo tenha sido utilizado, ou false, se ainda existir espaço livre a ser utilizado.
	 */
	public boolean atingiuCota() {
		if(this.getEspaco() >= this.getCota()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma String que informa o nome do laboratório e a relação entre o espaço utilizado pelo usuário e a cota total de armazenamento disponível.
	 */
	public String toString() {
		return this.getNomeLab() + " " + this.getEspaco() + "/" + this.getCota();
	}
	
	/**
	 * Retorna o nome do laboratório em que o registro da quantidade de armazenamento do aluno será realizada.
	 * 
	 * @return nome do laboratório.
	 */
	public String getNomeLab() {
		return this.nomeLab;
	}
	
	/**
	 * Retorna a cota disponibilizada para usufruto do usuário.
	 * 
	 * @return cota do laboratório.
	 */
	public int getCota() {
		return this.cotaLab;
	}
	
	/**
	 * Retorna a quantidade de espaço que foi utilizada pelo aluno.
	 * 
	 * @return espaço utilizado.
	 */
	public int getEspaco() {
		return this.espaco;
	}
	 /**
	  * Atribui o nome ao laboratório que será gerado.
	  * 
	  * @param n nome do laboratório.
	  */
	public void setNomeLab(String n) {
		this.nomeLab = n;
	}
	
	/**
	 * Atualiza a quantidade de espaço utilizada pelo aluno.
	 * 
	 * @param e espaço total usufruído pelo usuário.
	 */
	public void setEspaco(int e) {
		this.espaco = e;
	}

}