/* 115110267 - Raquel Rufino Costa da Paz: LAB 03 - Turma 1 */

package EconomizaP2;

public class Main {

	private Mercado mercado = new Mercado();
	private Entrada entrada = new Entrada();

	final int CADASTRAR = 1;
	final int VENDER = 2;
	final int IMPRIMIR = 3;
	final int SAIR = 4;

	public static void main(String[] args) {

		Main main = new Main();
		main.menuPrincipal();
	}

	private void menuPrincipal() {
		int opcao;

		do {

			System.out.println("\n= = = = Bem-vindo(a) ao EconomizaP2 = = = =\n");
			System.out.println("Digita a opção desejada:\n");
			System.out.println("1 - Cadastrar/Atualizar um Produto");
			System.out.println("2 - Vender um Produto");
			System.out.println("3 - Imprimir Balanço");
			System.out.println("4 - Sair\n");
			System.out.print("Opção: \n");
			opcao = entrada.receberInteiro();

			switch (opcao) {

			case CADASTRAR:
				mercado.cadastra();
				break;

			case VENDER:
				mercado.venda();
				break;

			case IMPRIMIR:
				mercado.balanco();
				break;

			case SAIR:
				System.out.println("SAINDO...");
				System.out.println("VOLTE SEMPRE");
				break;

			default:
				break;

			}
		} while (opcao != SAIR);
	}
}