/* 115110267 - Raquel Rufino Costa da Paz: LAB 03 - Turma 1 */
package EconomizaP2;

public class Produto {

	private String nome;
	private String tipo;
	private double preco;
	private int estoque;

	// ------------------------------------- Construtor
	// --------------------------------------------------
	public Produto(String nome, String tipo, double preco, int estoque) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.estoque = estoque;
	}

	// -------------------------------------GETS---------------------------------------------------------
	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPreco() {
		return preco;
	}

	public int getEstoque() {
		return estoque;
	}

	// -------------------------------------SETS---------------------------------------------------------

	public void setPreco(double preco) {
		this.preco = preco;
	}

	// ------------

	public void aumentaEstoque(int quantidade) { // aumenta o estoque
		this.estoque += quantidade;
	}

	public void diminuiEstoque(int quantidade) // diminui o estoque

	{
		this.estoque -= quantidade;
	}

	// -------------- toString

	@Override
	public String toString() {

		return String.format("%s (%s).R$%.2f", this.getNome(), this.getTipo(),
				this.getPreco());
	}

	@Override
	public boolean equals(Object objeto) {

		if (objeto instanceof Produto) {
			Produto outroProduto = (Produto) objeto;

			if (this.getNome().equals(outroProduto.getNome())) {
				return true;
			}

		}

		return false;

	}
}
