package ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import contas.Compra;
import contas.Conta;

/**
 * Classe responsável por ordenar detalhes de uma compra a partir do criterio "Data".
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class OrdenaDatas {
	
	/**
	 * Mapa que armazena informacoes sobre as contas entre um cliente e um fornecedor.
	 * 
	 */
	private HashMap<String, Conta> contas;
	
	/**
	 * Lista que auxilia na ordenacao por data.
	 * 
	 */
	private ArrayList<String> listaAuxiliar;
	
	/**
	 * Lista que armazena informacoes sobre compras realizadas.
	 * 
	 */
	private ArrayList<Compra> listaCompras;
	
	/**
	 * Constrói uma listagem de compras a partir do criterio de "Data".
	 * 
	 * @param contas mapa com contas criadas entre clientes e fornecedores.
	 */
	public OrdenaDatas(HashMap<String, Conta> contas) {
		this.contas = contas;
		this.listaAuxiliar = new ArrayList<>();
		this.listaCompras = new ArrayList<>();
	}
	
	/**
	 * Realiza a ordenacao de informacoes das compras colocando a data em evidência e em ordem de compra mais antiga para mais recente.
	 * 
	 * @return representacao textual de informacoes das compras a partir do criterio "Data".
	 */
	public String ordenaDatas() {
		ArrayList<String> listaChavesContas = new ArrayList<>(this.contas.keySet());
		for(String chave : listaChavesContas) {
			this.listaCompras.addAll(this.contas.get(chave).getCompras());
		}
		Comparator<Compra> ordenaContaPelaData = Comparator.comparing(Compra::getAno).thenComparing(Compra::getMes).thenComparing(Compra::getDia).thenComparing(Compra::getNomeCliente).thenComparing(Compra::getNomeFornecedor).thenComparing(Compra::getDescricaoCompra);
		Collections.sort(listaCompras, ordenaContaPelaData);
		for(Compra compra : this.listaCompras) {
			listaAuxiliar.add(compra.getDataOriginal() + ", " + compra.getNomeCliente()+", "+ compra.getNomeFornecedor()+", "+compra.getDescricaoCompra() + " | ");
		}
		String saidaOrdenada = "";
		for(int e = 0; e < this.listaAuxiliar.size(); e++) {
			saidaOrdenada += this.listaAuxiliar.get(e);
		}
		int tamanho = saidaOrdenada.length();
		saidaOrdenada = saidaOrdenada.substring(0, tamanho-3);
		return saidaOrdenada;
		
	}

}
