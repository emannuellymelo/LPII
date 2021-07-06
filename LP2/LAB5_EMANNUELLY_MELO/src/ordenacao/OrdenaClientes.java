package ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import contas.Compra;
import contas.Conta;

/**
 * Classe responsável por ordenar detalhes de uma compra a partir do criterio "Cliente".
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class OrdenaClientes {
	
	/**
	 * Mapa que armazena informacoes sobre as contas entre um cliente e um fornecedor.
	 * 
	 */
	private HashMap<String, Conta> contas;
	
	/**
	 * Lista que armazena informacoes sobre compras realizadas.
	 * 
	 */
	private ArrayList<Compra> listaCompras;
	
	/**
	 * Constrói uma listagem de compras a partir do criterio de "Cliente".
	 * 
	 * @param contas mapa com contas criadas entre clientes e fornecedores.
	 */
	public OrdenaClientes(HashMap<String, Conta> contas) {
		this.contas = contas;
		this.listaCompras = new ArrayList<>();
	}
	
	/**
	 * Realiza a ordenacao de informacoes das compras colocando o cliente em evidência e em ordem alfabetica.
	 * 
	 * @return representacao textual de informacoes das compras a partir do criterio "Cliente"
	 */
	public String ordenacaoClientes() {
		ArrayList<String> listaChavesContas = new ArrayList<>(this.contas.keySet());
		for(String chave : listaChavesContas) {
			this.listaCompras.addAll(this.contas.get(chave).getCompras());
		}
		Comparator<Compra> ordenaContaPeloCliente = Comparator.comparing(Compra::getNomeCliente).thenComparing(Compra::getNomeFornecedor).thenComparing(Compra::getDescricaoCompra);
		Collections.sort(listaCompras, ordenaContaPeloCliente);
		String saidaOrdenada = "";
		for(Compra compra : this.listaCompras) {
			saidaOrdenada += compra.getNomeCliente()+", "+ compra.getNomeFornecedor()+", "+compra.getDescricaoCompra()+", "+compra.getDataOriginal()+" | ";
		}
		int tamanho = saidaOrdenada.length();
		saidaOrdenada = saidaOrdenada.substring(0, tamanho-3);
		return saidaOrdenada;
	}
	

}
