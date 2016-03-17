/* 115110267 - Raquel Rufino Costa da Paz: LAB 03 - Turma 1 */
package EconomizaP2;

public class Estoque

// / ajeitar o aumentar produto
{
	private Produto[] listaProdutos = new Produto[5];
	private int indicador = 0;

	// Métodos de Cadastrar
	// ------------------------------------------------------------------------------------------

	// cria o produto
	public void recebeProduto(String nome, String tipo, double preco,
			int estoque) {
		Produto produto = new Produto(nome, tipo, preco, estoque);
		listaProdutos[indicador] = produto;
		indicador = indicador + 1;
		duplicaArray();
	}

	// encontar o indince

	public int encontrarIndice(String nome) {
		int i = 0;
		while (i < indicador) {
			if (listaProdutos[i].getNome().equals(nome)) {
				return i;
			}
			i = i + 1;
		}
		return -1;
	}

	// duplica o Array

	public Produto[] duplicaArray() {
		if (indicador == listaProdutos.length) {
			Produto[] novaLista = new Produto[indicador * 2];
			for (int i = 0; i < indicador; i++) {
				novaLista[i] = listaProdutos[i];
			}

			listaProdutos = novaLista;

		}
		return listaProdutos;
	}

	// Verifica se existe o produto

	public boolean seTem(String novoProduto)

	{
		for (int i = 0; i < indicador; i++) {
			if (listaProdutos[i].getNome().equals(novoProduto)) {
				return true;
			}
		}
		return false;

	}

	// Muda o preço
	public void mudarPreco(String nome, double preco) {
		int indice = encontrarIndice(nome);

		listaProdutos[indice].setPreco(preco);

	}

	// Aumenta o estoque

	public void adicionaProduto(int quantidade, String nome) {
		int indice = encontrarIndice(nome);

		listaProdutos[indice].aumentaEstoque(quantidade);

	}

	// Métodos de Vender
	// ------------------------------------------------------------------------------------------

	// Retorna a quantidade do estoque do produto solicitado
	public int quantidadeProduto(String nome) {
		int indice = encontrarIndice(nome);

		if (nome.equals(listaProdutos[indice].getNome())) {
			return listaProdutos[indice].getEstoque();
		}

		return 0;

	}

	// calcula o preço da venda
	public double calculaPreco(int quantidade, String nome) {
		int indice = encontrarIndice(nome);
		double valor = listaProdutos[indice].getPreco() * quantidade;
		return valor;

	}

	// diminui o estoque
	public void removeProduto(int quantidade, String nome) {
		int indice = encontrarIndice(nome);

		listaProdutos[indice].diminuiEstoque(quantidade);

	}

	// ---------------------------------------------------

	public String informacaoProduto(String nome) {
		int indice = encontrarIndice(nome);
		return listaProdutos[indice].toString();
	}

	// ---------------------------------------------------

	// Método de Imprimir balanço
	// ------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		String balanco = "";
		for (int i = 0; i < indicador; i++) {
			balanco += ("\t" + (i + 1) + ") " + listaProdutos[i] + " Restante:"
					+ listaProdutos[i].getEstoque() + "\n");
		}
		return balanco;

	}

	// calcula o possivel Arrecadamento
	public double possivelArrecadamento() {
		double possivelArrecadamento = 0.0;
		for (int i = 0; i < indicador; i++) {
			possivelArrecadamento = possivelArrecadamento
					+ (listaProdutos[i].getPreco() * listaProdutos[i]
							.getEstoque());
		}
		return possivelArrecadamento;

	}

}