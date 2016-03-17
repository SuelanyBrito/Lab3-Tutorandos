/* Matricula: 115111033 - Nome Completo do Aluno: Francisco Angelim de Figueiredo Filho LAB 3 - Turma 03 */
package super_mercado;

public class Supermercado {
	private Estoque estoque;
	private double arrecadado;
	
	public Supermercado(){
		estoque = new Estoque();
		arrecadado = 0;
	}


	public void cadastra(String nome,double preco,String tipo,int quantidade){
		estoque.cadastraProduto(nome,preco,tipo,quantidade);
	}
	
	public boolean contemProduto(String nome){ // verifica se o array contem um produto com nome igual ao passado por parametro.
		boolean inArray = estoque.inArray(nome);
		return inArray;
	}
	
	public boolean vende(String nome,int quantidade){
		if(!estoque.checaQuantia(nome,quantidade)){ // Nao ha produtos suficientes.
			return false;
		}else{
			estoque.atualizaQntProduto(nome,quantidade); // atualiza a quantidade restante deste produto.
			registrarLucros(quantidade,estoque.infoPrecoProduto(nome)); // faz alteracoes no dinheiro que ainda pode ser arrecadado e no que ja foi arrecadado.
			return true;
		}
		
	}
	
	private void registrarLucros(int quantidade,double preco){
		this.arrecadado = this.arrecadado + (quantidade*preco); // dinheiro arrecadado com a venda do produto.
	}
	
	public void balanco(){
		System.out.println("==== Impressao de Balanco ====");
		System.out.println("Produtos Cadastrados:");
		estoque.verProdutos(); // Imprime os produtos do estoque,um por linha.
		
		System.out.println();
		
		System.out.println(String.format("Total arrecadado em vendas: R$ %.2f", arrecadado));
		System.out.println(String.format("Total que ainda pode ser arrecadado: R$ %.2f", estoque.notArrecadado()));
		System.out.println();
	}

	public void imprimeInfoProduto(String nome){ // imprime o toString do produto de nome equivalente ao passado por parametro.
		System.out.println(estoque.getProduto(nome));
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		return result;
	}
	public boolean equals(Object objeto){
		if(objeto instanceof Supermercado){
			Supermercado mercado = (Supermercado)objeto;
			if(mercado.estoque.equals(this.estoque)){
				return true;
			}
		}return false;
	}

}

