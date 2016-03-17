/* Matricula: 115111033 - Nome Completo do Aluno: Francisco Angelim de Figueiredo Filho LAB 3 - Turma 03 */
package super_mercado;
import java.util.Scanner;

public class Menu {
	private Scanner scan;
	private Supermercado lojaoP2;
	private final static int CADASTRAR = 1;
	private final static int VENDER = 2;
	private final static int BALANCO = 3;
	private final static int SAIR = 4;
	
	public Menu(){
		scan = new Scanner(System.in);
		lojaoP2 = new Supermercado();
	}
	
	public void menu(){
		int opcao;
		do{
		System.out.println("= = = = Bem vindo(a) ao EconomizaP2 = = = = ");
		System.out.println("Digite a opcao desejada: ");
		System.out.println("1 - Cadastrar um produto");
		System.out.println("2 - Vender um produto");
		System.out.println("3 - Imprimir balanco");
		System.out.println("4 - Sair");
		opcao = lerInt("Opcao: ");
		
		switch(opcao){
			case CADASTRAR:
				cadastro();
				break;
			case VENDER:
				venda();
				break;
			case BALANCO:
				lojaoP2.balanco();
				break;
			case SAIR:
				System.out.println("-- Fim de execucao --");
				break;
			default:
				System.out.println("Numero invalido,digite um numero valido.");
			}
		}while(opcao != SAIR);
	}

	private void cadastro(){
		String cadastrar;
		do{
			System.out.println("= = = = Cadastro de Produtos = = = =");
			String nome = lerString("Digite o nome do produto: ");
			
			if(!lojaoP2.contemProduto(nome)){ /*O metodo retornar false,significa o que produto nao esta cadastrado*/
				double preco = lerDouble("Digite o preco unitario do produto: ");
				
				String tipo = lerString("Digite o tipo do produto: ");
				
				int quantidade = lerInt("Digite a quantidade no estoque: ");		
				
				lojaoP2.cadastra(nome, preco, tipo, quantidade);
				
				System.out.println(quantidade + " " + nome + "(s)" + " cadastrado(s) com sucesso.");
			}else{
				System.out.println("Produto ja cadastrado.");
			}
			
			cadastrar = lerString("Deseja cadastrar outro produto? ");
			
		}while(cadastrar.equalsIgnoreCase("sim"));
	}
	
	private void venda(){
		String opcao;
		do{
		System.out.println("= = = = Venda de Produtos = = = =");
		String nome = lerString("Digite o nome do produto: ");

		
		if(!lojaoP2.contemProduto(nome)){ /*O metodo retornar false,significa o que produto nao esta cadastrado*/
			System.out.println("--> "+ nome + " nao cadastrado no sistema");
		}else{
			lojaoP2.imprimeInfoProduto(nome); //toString do produto
			
			int quantidade = lerInt("Digite a quantidade que deseja vender: ");
			
			if(!lojaoP2.vende(nome, quantidade)){ // O metodo retornar false,significa que nao ha produtos suficientes.
				System.out.println("Nao eh possivel vender,pois nao ha " + nome +  " suficiente");
			}else{
				System.out.println("Produto vendido com sucesso!");
			}
		}
		
		opcao = lerString("Deseja vender outro produto? ");
		}while(opcao.equalsIgnoreCase("sim"));
	}
	
	private String lerString(String msg){
		System.out.print(msg);
		return scan.nextLine();
	}
	private int lerInt(String msg){
		System.out.print(msg);
		int valorInteiro = scan.nextInt();
		scan.nextLine();
		return valorInteiro;
	}
	private double lerDouble(String msg){
		System.out.print(msg);
		double valorFlutuante = scan.nextDouble();
		scan.nextLine();
		return valorFlutuante;
	}
	
	
}
