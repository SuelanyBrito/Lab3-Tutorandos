/* 115110820 - Matheus Procopio da Silva: LAB 3 - Turma 3 */
public class Estoque {
	
	private int numeroDeProdutos;
	private Produto[] arrayDeProdutos;
	public static final int TAMANHO_INICIAL = 5;
	
	public Estoque(){
		this.setNumeroDeProdutos(0);
		this.setArrayDeProdutos(new Produto[this.TAMANHO_INICIAL]);
	}

	public int getNumeroDeProdutos() {
		return numeroDeProdutos;
	}

	public void setNumeroDeProdutos(int numeroDeProdutos) {
		this.numeroDeProdutos = numeroDeProdutos;
	}

	public Produto[] getArrayDeProdutos() {
		return arrayDeProdutos;
	}

	public void setArrayDeProdutos(Produto[] arrayDeProdutos) {
		this.arrayDeProdutos = arrayDeProdutos;
	}
	
	public void duplicaArray(){
		Produto[] novoArray = new Produto[this.getNumeroDeProdutos()*2];
		
		for(int i = 0; i < this.getNumeroDeProdutos(); i++){
			novoArray[i] = this.arrayDeProdutos[i];
		}
		
		this.setArrayDeProdutos(novoArray);
	}
	
	public boolean jaCadastrado(String nome){
		
		for(int i = 0; i < this.getNumeroDeProdutos(); i++){
			Produto produto = this.arrayDeProdutos[i];
			if(produto.getNome().equals(nome)){
				return true;
			}
		}
		return false;
		
	}
	
	public String representacaoProduto(String nome){
		String retorno = "";
		
		if(this.jaCadastrado(nome)){
			
			for(int i = 0; i < this.getNumeroDeProdutos(); i++){
				Produto produto = this.arrayDeProdutos[i];
				if(produto.getNome().equals(nome)){
					retorno = produto.toString();
				}
			}
			
		}
		return retorno;
	}
	
	public Produto findProduto(String nome){
		
		for(int i = 0; i < this.getNumeroDeProdutos(); i++){
			Produto produto = this.arrayDeProdutos[i];
			if(produto.getNome().equals(nome)){
				return produto;
			}
		}
		return null;
	}
	
	public void inserirProduto(String nome, double preco, String tipo, int quantidade){
		
		Produto novoProduto = new Produto(nome, preco, tipo, quantidade);
		this.arrayDeProdutos[this.getNumeroDeProdutos()] = novoProduto;
		this.numeroDeProdutos++;
		
		if(this.getNumeroDeProdutos() == this.getArrayDeProdutos().length){
			this.duplicaArray();
		}
		
	}

	//Este método retorna um double para ser adicionado no totalArrecadado, caso retorne -2 -> sinifica que o produto nao encontrado, caso -1 -> quantidade insuficiente.
	public double decrementaQuantidade(String nome, int aSerDecrementado){
		Produto produto = this.findProduto(nome);
		if(produto == null){
			return -2;
		}else{
			if(produto.getQuantidade() >= aSerDecrementado){
				produto.setQuantidade(produto.getQuantidade() - aSerDecrementado);
				return aSerDecrementado * produto.getPreco();
			}
			return -1;
		}
		
	}
	
	public String toString(){
		
		String pulaLinha = System.getProperty("line.separator");
		String representacao = "Produtos cadastrados:" + pulaLinha;
		
		for(int i = 0; i < this.getNumeroDeProdutos(); i++){
			Produto produto = this.arrayDeProdutos[i];
			representacao += "   " + (i+1) + ") " + produto + pulaLinha;
		}
		
		return representacao;
	}
	
}
