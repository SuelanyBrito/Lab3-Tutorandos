/* 115110820 - Matheus Procopio da Silva: LAB 3 - Turma 3 */
public class Produto {
	
	private String nome;
	private double preco;
	private String tipo;
	private int quantidade;
	
	
	public Produto(String nome, double preco, String tipo, int quantidade){
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getQuantidade(){
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	
	public String toString(){
		String representacao = "";
		representacao = this.getNome() + "(" + this.getTipo() + ")." + this.getPreco() + " Restante:" + this.getQuantidade();
		return representacao;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public boolean equals(Object objeto){
		if(objeto instanceof Produto){
			Produto outroProduto = (Produto) objeto;
			if(outroProduto.getNome().equals(this.getNome()) && outroProduto.getTipo().equals(this.getTipo())){
				return true;
			}
			return false;
		}
		return false;
	}
	

}
