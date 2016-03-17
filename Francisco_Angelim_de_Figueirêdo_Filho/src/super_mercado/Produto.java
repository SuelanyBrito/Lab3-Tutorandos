/* Matricula: 115111033 - Nome Completo do Aluno: Francisco Angelim de Figueiredo Filho LAB 3 - Turma 03 */
package super_mercado;

public class Produto {
	private String nomeProduto;
	private double precoProduto;
	private String tipoProduto;
	private int quantidadeProduto;
	
	public Produto(String nome,double preco,String tipo,int quantidade){
		this.nomeProduto = nome;
		this.precoProduto = preco;
		this.tipoProduto = tipo;
		this.quantidadeProduto = quantidade;
	}
	
	public void novaQnt(int quantidade){ // Metodo utilizado para atualizar a quantidade de produtos
		this.quantidadeProduto -= quantidade;
	}
	
	public String getNome(){
		return this.nomeProduto;
	}
	public double getPreco(){
		return this.precoProduto;
	}
	public String getTipo(){
		return this.tipoProduto;
	}
	public int getQuantidade(){
		return this.quantidadeProduto;
	}
	
	public String toString(){
		return "--> " + getNome()  + "("+ getTipo() + "): R$"+ getPreco() + " Restante: " + getQuantidade();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		return result;
	}

	public boolean equals(Object objeto){
		if(objeto instanceof Produto){
			Produto p1 = (Produto)objeto;
			if(p1.getNome().equals(this.nomeProduto)){
				return true;
			}
		}return false;
	}
	

}