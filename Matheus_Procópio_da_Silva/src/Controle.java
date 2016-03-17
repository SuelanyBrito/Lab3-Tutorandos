/* 115110820 - Matheus Procopio da Silva: LAB 3 - Turma 3 */
public class Controle {
	
	private double totalArrecadado;
	private double totalPossivel;
	private Estoque estoque;
	
	public Controle(){
		this.totalArrecadado = 0;
		this.setTotalPossivel(0);
		this.estoque = new Estoque();
	}

	public double getTotalArrecadado() {
		return totalArrecadado;
	}

	public void setTotalArrecadado(double totalArrecadado) {
		this.totalArrecadado = totalArrecadado;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public double getTotalPossivel() {
		return totalPossivel;
	}

	public void setTotalPossivel(double totalPossivel) {
		this.totalPossivel = totalPossivel;
	}
	
	public boolean estoqueVazio(){
		if(this.estoque.getNumeroDeProdutos() == 0){
			return true;
		}
		return false;
	}
	
	public boolean estaNoEstoque(String nome){
		if(this.estoque.jaCadastrado(nome)){
			return true;
		}
		return false;
	}
	
	public void realizarCadastro(String nome, double preco, String tipo, int quantidade){
		this.estoque.inserirProduto(nome, preco, tipo, quantidade);
		this.setTotalPossivel(this.getTotalPossivel() + preco * quantidade);
	}

	public String imprimeProduto(String nome){
		String retorno = "";
		
		if(this.estoque.representacaoProduto(nome).equals("")){
			return retorno;
		}
		else{
			retorno = this.estoque.representacaoProduto(nome);
			return retorno;
		}
	}
	
	
	public boolean realizarVenda(String nome, int quantidade){
		
		double arrecadado = this.estoque.decrementaQuantidade(nome, quantidade);
		if(arrecadado != -1 && arrecadado != -2){
			this.totalArrecadado += arrecadado;
			this.totalPossivel -= arrecadado;
			return true;
		}
		return false;
		
	}

	public String imprimeBalanco(){
		
		String pulaLinha = System.getProperty("line.separator");
		
		String balanco = this.estoque.toString();
		balanco += pulaLinha + "Total arrecadado em vendas: R$" + this.getTotalArrecadado() + pulaLinha;
		balanco += "Total que pode ser arrecadado: R$" + this.getTotalPossivel() + pulaLinha;
		
		return balanco;
		
	}
	
}
