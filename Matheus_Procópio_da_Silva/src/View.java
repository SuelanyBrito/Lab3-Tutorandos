/* 115110820 - Matheus Procopio da Silva: LAB 3 - Turma 3 */
import java.util.Scanner; 

public class View {
	
	private Controle controle = new Controle();
	private Scanner scanner = new Scanner(System.in);
	public static final int CADASTRAR = 1;
	public static final int VENDER = 2;
	public static final int BALANCO = 3;
	public static final int SAIR = 4;
	public static final String FIM_LINHA = System.getProperty("line.separator");
	
	public void menuPrincipal(){
		short opcao;
		do{
			
			System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =");
			System.out.println("Digite a opcao desejada:");
			System.out.println("1 - Cadastrar um Produto");
			System.out.println("2 - Vender um Produto");
			System.out.println("3 - Imprimir Balanço");
			System.out.println("4 - Sair" + this.FIM_LINHA);
			
			System.out.print("Opcao:");
			
			opcao = scanner.nextShort();
			
			switch (opcao) {
			
				case CADASTRAR:
					this.menuCadastro();
					break;
				case VENDER:
					this.menuVenda();
					break;
				case BALANCO:
					this.balanco();
					break;
				case SAIR:
					System.out.print(this.FIM_LINHA + "= = = = Obrigado pela preferencia = = = =");
					break;
				default:
					System.out.println(this.FIM_LINHA + "= = = = Informe uma opcao valida = = = =");
					break;
					
			}
		
		}while(opcao != SAIR);
	}

	public void menuCadastro(){
		
		String flag_saida = "";
		
		do{
			System.out.println(this.FIM_LINHA + "= = = = Cadastro de Produtos = = = =");
			System.out.print("Digite o nome do produto: ");
			String nome = this.scanner.next();
			
			if(this.controle.estaNoEstoque(nome)){
				System.out.println(nome + "já cadastrado." + this.FIM_LINHA);
			}else{
				
				System.out.print("Digite o preço unitario do produto: ");
				double preco = this.scanner.nextDouble();
				System.out.print("Digite o tipo do produto: ");
				String tipo = this.scanner.next();
				System.out.print("Digite a quantidade no estoque: ");
				int quantidade = this.scanner.nextInt();
				
				System.out.print(this.FIM_LINHA);
				
				this.controle.realizarCadastro(nome, preco, tipo, quantidade);
				System.out.println(quantidade + " "  + nome + "(s) cadastrado(s) com sucesso." + this.FIM_LINHA);
				
			}
			
			System.out.print("Deseja cadastrar outro produto? ");
			flag_saida = this.scanner.next();
			
			System.out.print(this.FIM_LINHA);
			
			
		}while(!flag_saida.equals("nao"));
		
	}
	
	public void menuVenda(){
		
		if(this.controle.estoqueVazio()){
			System.out.println(this.FIM_LINHA + "Estoque vazio, cadastre algum produto.");
		}else{
			String flag_saida = "";
			do{
				
				System.out.println("= = = = Venda de Produtos = = = =" + this.FIM_LINHA);
				System.out.println("Digite o nome do produto: ");
				String nome = this.scanner.next();
				
				if(this.controle.estaNoEstoque(nome)){
					
					System.out.println("==>" + this.controle.imprimeProduto(nome));
	
					System.out.println("Digite a quantidade que deseja vender: ");
					int quantidade = this.scanner.nextInt();
					
					boolean autorizada = controle.realizarVenda(nome, quantidade);
					
					if(autorizada){
						
						System.out.println("==> Total arrecadado: R$" + quantidade);
					}else{
						System.out.println("Quantidade insuficiente.");
					}
					
					System.out.println("Deseja vender outro produto? ");
					flag_saida = this.scanner.next();
					
				}else{
					System.out.println("==> "+ nome + " nao cadastrada no sistema.");
					System.out.println("Deseja vender outro produto? ");
					flag_saida = this.scanner.next();
				}
				
			}while(!flag_saida.equals("nao"));	
		}
	}
	
	public void balanco(){
		if(this.controle.estoqueVazio()){
			System.out.println("Estoque vazio, ainda nao ha um balanco para ser impresso." + this.FIM_LINHA);
		}else{
			System.out.println(this.controle.imprimeBalanco());
		}
	}
	
}
