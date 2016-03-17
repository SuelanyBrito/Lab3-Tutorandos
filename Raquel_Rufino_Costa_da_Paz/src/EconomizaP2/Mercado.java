/* 115110267 - Raquel Rufino Costa da Paz: LAB 03 - Turma 1 */
package EconomizaP2;

public class Mercado

{
	private Estoque estoque = new Estoque(); // cria o objeto estoque
	private Entrada entrada = new Entrada(); // cria o objeto entrada
	private double totalArrecadado = 0; // Total de tudo que foi vendido

	public void cadastra() { // Cadastra o Produto
		String opcao = " "; // opção para saber se o cliente quer cadastrar ou
		// atualizar de novo
		int quantidade; // quantidade do produto que vai cadastrar

		System.out.println("\n= = = = Cadastro de Produtos = = = =");

		do {
			opcao = " ";

			System.out.print("\nDigite o nome do produto: ");
			String nome = entrada.receberString(); // recebe o nome do produto

			if (estoque.seTem(nome)) { // Verifica se o produto já tem no
				// estoque

				atualiza(nome); // vai para o método que atualiza o produto
			}

			else {
				System.out.print("Digite o preço unitário do produto: ");
				double preco = entrada.receberDouble(); // recebe o preço do
				// produto
				System.out.print("Digite o tipo do produto: ");
				String tipo = entrada.receberString(); // recebe o tipo do
				// produto

				do { // verifica se a quantidade é maior que 0
					System.out.print("Digite a quantidade no estoque: ");
					quantidade = entrada.receberInteiro(); // recebe a
					// quantidade de
					// Produto
				} while (quantidade <= 0);

				estoque.recebeProduto(nome, tipo, preco, quantidade); // envia
				// as
				// informações
				// do
				// produto

				System.out.print(quantidade + " " + nome
						+ "(s) cadastrados com sucesso.\n");
			}

			while (verificarOpcao(opcao)) { // verifica se o cliente digitou uma
				// resposta válida
				System.out
						.println("\nDeseja cadastrar ou atualizar outro produto? ");
				opcao = (entrada.receberString()); // recebe a opção se continua
				// em cadastrar ou atualizar
				// produto
			}

		} while (opcao.equalsIgnoreCase("sim")); // continua no programa se a
		// resposta é igual a sim

	}

	// ------------> Atualiza Produto

	public void atualiza(String nome) {
		int quantidade = 0; // quantidade do produto que vai cadastrar

		System.out.print("Digite o preço unitário do produto: ");
		double preco = entrada.receberDouble(); // recebe o preço do produto
		estoque.mudarPreco(nome, preco); // vai mudar o preço do produto;

		do { // verifica se a quantidade é maior que 0
			System.out.print("Digite a quantidade no estoque: ");
			quantidade = entrada.receberInteiro(); // recebe a quantidade de
			// Produto
		} while (quantidade <= 0);

		System.out
				.print(quantidade + " " + nome + " atualizado com sucesso.\n");
		estoque.adicionaProduto(quantidade, nome); // aumenta o estoque

	}

	public void venda() { // Vende Produto

		String produtoSolicitado, opcao = " "; // Produto solicitado pelo
		// usuário ;opcao se deseja
		// comprar outro produto
		System.out.println("\n\t\t= = = = Venda de Produtos = = = = ");
		do {
			opcao = " ";

			System.out.println("\nDigite o nome do produto:");
			produtoSolicitado = entrada.receberString(); // recebe o nome do
			// produto
			// solicitado

			if (estoque.seTem(produtoSolicitado)) { // verifica se existe o
				// produto

				System.out.println("==> "
						+ estoque.informacaoProduto(produtoSolicitado));

				System.out.println("\nDigite a quantidade que deseja vender: ");
				int quantidade = entrada.receberInteiro(); // recebe a
				// quantidade que o
				// usuário quer
				// vender
				int armazenado = estoque.quantidadeProduto(produtoSolicitado); // recebe
				// a
				// quantidade
				// armazenada

				if (quantidade <= armazenado) { // verifica se tem estoque
					// suficiente para a venda

					double totalCompra = estoque.calculaPreco(quantidade,
							produtoSolicitado); // calcula o total da compra
					System.out.format("==> Total arrecadado: R$ %.2f\n",
							totalCompra);
					totalArrecadado = totalArrecadado + totalCompra; // atualiza
					// o
					// total
					// do
					// preço
					// arrecadado
					// das
					// vendas
					estoque.removeProduto(quantidade, produtoSolicitado); // diminui
					// o
					// estoque
					// do
					// Produto
				}

				else { // diz ao usuário que não há estoque suficiente
					System.out.println("Não é possível vender pois não há "
							+ produtoSolicitado + " suficiente. ");
				}

			}

			else { // diz ao usuário que não existe o produto no estoque
				System.out.println("==>" + produtoSolicitado
						+ " não cadastrada no sistema. ");
			}
			while (verificarOpcao(opcao)) { // verifica se a quantidade é maior
				// que 0
				System.out.println("\nDeseja vender outro produto?");
				opcao = entrada.receberString(); // recebe a opcao se deseja
				// vender outro produto

			}

		} while (opcao.equalsIgnoreCase("sim")); // continua no programa se a
		// resposta é igual a sim
	}

	public void balanco() { // Imprime o balanço

		System.out.println("\t= = = = Impressao de Balanco = = = = \n");
		System.out.println("Produtos cadastrados:");
		System.out.println(estoque); // imprimi o toString de estoque
		System.out.format("\nTotal arrecadado em vendas: R$%.2f ",
				totalArrecadado);
		System.out.format("\nTotal que pode ser arrecadado: R$%.2f \n",
				estoque.possivelArrecadamento());

	}

	public boolean verificarOpcao(String nome) { // esse método verifica se uma
		// resposta válida(Sim ou
		// Nao)
		if (nome.equalsIgnoreCase("sim") || nome.equalsIgnoreCase("nao")) {
			return false;
		}

		return true;
	}

}
