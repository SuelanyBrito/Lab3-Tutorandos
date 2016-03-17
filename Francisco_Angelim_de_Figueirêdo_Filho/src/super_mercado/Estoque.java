/* Matricula: 115111033 - Nome Completo do Aluno: Francisco Angelim de Figueiredo Filho LAB 3 - Turma 03 */
package super_mercado;
import java.util.Arrays;

public class Estoque {
	private Produto[] produtos;
	private int tamanho;
	private final static int VALOR_INICIAL = 5;
	/*variavel tamanho eh utilizada para manter controle da quantidade de produtos inseridos no array */
	
	public Estoque(){
		produtos = new Produto[VALOR_INICIAL];
		tamanho = 0;
	}

	private void aumentaEstoque(){ // Dobra o tamanho do array de produtos
		Produto[] novoArray = new Produto[produtos.length*2];
		for(int i = 0; i < produtos.length;i++){
			novoArray[i] = produtos[i]; // passa os produtos do antigo array para o novo de tamanho dobrado.
		}
		produtos = novoArray; // produtos agora se refere ao novo array de tamanho dobrado.
	}
	private void adicionaProduto(Produto produto){
		if(this.tamanho == this.produtos.length){
			aumentaEstoque(); // O array esta cheio, seu tamanho sera dobrado.
		}
		produtos[this.tamanho] = produto; // adiciona produto no array
		tamanho += 1; // incrementa variavel de controle
	}
	public void cadastraProduto(String nome,double preco,String tipo,int quantidade){
		Produto novoProduto = new Produto(nome,preco,tipo,quantidade);
		adicionaProduto(novoProduto);	
	}
	
	public boolean inArray(String nome){ // Procura produto no estoque pelo nome passado por parametro.
		for(int i = 0; i < this.tamanho;i++){
			if(nome.equals(produtos[i].getNome())){
				return true;
			}
		}return false;
	}

	private Produto produtoInArray(int indice){ // Retorna o produto de indice desejado
		return produtos[indice];
	}
	
	public boolean checaQuantia(String nome,int quantidade){ // Checa se ha produtos suficientes para venda.
		Produto produto = getProduto(nome);
		if(produto.getQuantidade() >= quantidade){
			return true;
		}else{
			return false;
		}
	}
	public void atualizaQntProduto(String nome,int quantidade){ // Recebe o nome do produto vendido e a quantidade vendida.
		Produto produto = getProduto(nome);
		produto.novaQnt(quantidade); // Reduz a quantidade deste produto.
	}
	
	public double notArrecadado(){ // Calcula o dinheiro que ainda pode ser arrecadado,referente a venda dos produtos restantes no estoque.
		double notArrecadado = 0;
		for(int i = 0; i < this.tamanho; i ++){
			notArrecadado += (produtos[i].getPreco()) * (produtos[i].getQuantidade());
		}return notArrecadado;
	}
	public void verProdutos(){
		for(int i = 0;i < this.tamanho; i++){ // Imprime os produtos cadastrados no estoque, um por linha.
			System.out.println((i+1) + ")" + produtos[i]);
		}
	}
	
	public double infoPrecoProduto(String nome){ // Retorna preco do produto com nome passado por parametro.
		return getProduto(nome).getPreco(); 
	}
	
	public Produto getProduto(String nome){ 
	/* Busca um produto com nome igual ao passado por parametro 
	e o retorna se estiver contido no array */
		for(int i = 0; i < tamanho ; i++){
			if(nome.equals(produtos[i].getNome())){
				return produtos[i];
			}
		}return null;
	}
	public int getTamanho(){
		return tamanho;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(produtos);
		return result;
	}

	public boolean equals(Object objeto){
		if(objeto instanceof Estoque){ // Verifica se o objeto recebido eh do tipo Estoque
			Estoque estoque = (Estoque)objeto;
			if(estoque.tamanho == this.tamanho){ 
			/* Para dois estoques serem iguais,devem ter os mesmos produtos,
			ou seja,a mesma quantidade de produtos(tamanho).*/
				
				int iguais = 0; // Variavel para guardar a quantidade de produtos iguais no estoque
				for(int i = 0; i < this.tamanho; i++){
					for(int j = 0; j < estoque.tamanho; j++){
						if(estoque.produtoInArray(j).equals(produtos[i])){ // Verifica se os produtos sao iguais
							iguais += 1;
						}
					}
				}if(iguais == this.tamanho){
				// O estoque possui a mesma quantidade de produtos e os mesmos produtos.
				// Portanto,sao iguais.
					return true;
				}
			}
		}return false;
	}
	

	




}

