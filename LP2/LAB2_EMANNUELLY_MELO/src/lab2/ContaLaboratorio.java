package lab2;

 /**
  * Representa��o de uma conta de laborat�rio que det�m controle da quantidade de espa�o utilizada pelo aluno.
  * 
  * @author Emannuelly Larissa Freitas de Melo - 119210167.
  *
  */

public class ContaLaboratorio {
	
	/**
	 * Identifica��o do laborat�rio em que ter� as atividades do aluno registradas.
	 */
	private String nomeLab;
	
	/**
	 * Espa�o destinado ao uso pelo aluno.
	 */
	private int cotaLab;
	
	/**
	 * Indica a quantidade de espa�o que o aluno est� utilizando.
	 */
	private int espaco;
	
	/**
	 * Define a cota padr�o que o laborat�rio oferece.
	 */
	private final int COTA_PADRAO_LABORATORIO = 2000;
	
	/**
	 * Gera uma conta de laborat�rio a partir da identifica��o pelo seu nome e possui como padr�o uma cota de 2000 megabytes. O espa�o ocupado pelo aluno inicia zerado.
	 * 
	 * @param nomeLaboratorio identifica��o do laborat�rio em que o aluno ter� suas atividades registradas.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLab = nomeLaboratorio;
		this.cotaLab = COTA_PADRAO_LABORATORIO;
	}
	
	/**
	 * Gera uma conta de laborat�rio a partir da identifica��o pelo seu nome e pela cota de espa�o dispon�vel para o aluno. O espa�o utilizado pelo aluno inicia nulo.
	 * 
	 * @param nomeLaboratorio identifica��o do laborat�rio em que o aluno ter� suas atividades registradas.
	 * @param cota quantidade de espa�o destinada para a utiliza��o do aluno.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLab = nomeLaboratorio;
		this.cotaLab = cota;
	}
	
	/**
	 * Controla a quantidade de espa�o que foi consumida pelo aluno.
	 * 
	 * @param mbytes identifica��o em megabytes do espa�o utilizado.
	 */
	public void consomeEspaco(int mbytes) {
		this.setEspaco(this.getEspaco() + mbytes);
	}
	
	/**
	 * Controla o espa�o que foi liberado pelo usu�rio da conta do laborat�rio.
	 * 
	 * @param mbytes identifica��o em megabytes do espa�o a ser liberado.
	 */
	public void liberaEspaco(int mbytes) {
		this.setEspaco(this.getEspaco() - mbytes);
	}
	
	/**
	 * Informa se a cota de armazenamento foi alcan�ada pelo aluno.
	 * 
	 * @return true, caso o espa�o m�ximo tenha sido utilizado, ou false, se ainda existir espa�o livre a ser utilizado.
	 */
	public boolean atingiuCota() {
		if(this.getEspaco() >= this.getCota()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma String que informa o nome do laborat�rio e a rela��o entre o espa�o utilizado pelo usu�rio e a cota total de armazenamento dispon�vel.
	 */
	public String toString() {
		return this.getNomeLab() + " " + this.getEspaco() + "/" + this.getCota();
	}
	
	/**
	 * Retorna o nome do laborat�rio em que o registro da quantidade de armazenamento do aluno ser� realizada.
	 * 
	 * @return nome do laborat�rio.
	 */
	public String getNomeLab() {
		return this.nomeLab;
	}
	
	/**
	 * Retorna a cota disponibilizada para usufruto do usu�rio.
	 * 
	 * @return cota do laborat�rio.
	 */
	public int getCota() {
		return this.cotaLab;
	}
	
	/**
	 * Retorna a quantidade de espa�o que foi utilizada pelo aluno.
	 * 
	 * @return espa�o utilizado.
	 */
	public int getEspaco() {
		return this.espaco;
	}
	 /**
	  * Atribui o nome ao laborat�rio que ser� gerado.
	  * 
	  * @param n nome do laborat�rio.
	  */
	public void setNomeLab(String n) {
		this.nomeLab = n;
	}
	
	/**
	 * Atualiza a quantidade de espa�o utilizada pelo aluno.
	 * 
	 * @param e espa�o total usufru�do pelo usu�rio.
	 */
	public void setEspaco(int e) {
		this.espaco = e;
	}

}