/* 115110236 - Vinícius de Medeiros Soares: LAB 3 - Turma 1 */

package EconomizaP2;

import java.util.Scanner;

public class Supermercado {

    Scanner scanner = new Scanner(System.in);
    Estoque estoque = new Estoque(5);
    private int posEstoque = 0;
    private String nomeProduto;
    private double totalGasto = 0.0;
    private double valorRestante = 0.0;
       
    public void cadastraProduto(){
           
        System.out.println("= = = = Cadastro de Produto = = = =");
        String opcaoContinuidade;
        do{
            estoque.confereEstoque(this.posEstoque);
               
            System.out.print("\nDigite o nome do produto: ");
            String nome = scanner.nextLine();
               
            int posProdutoAlterar = estoque.verificaProdutoEmEstoque(nome, posEstoque);
               
            if(posProdutoAlterar != -1){
                System.out.println("Produto ja cadastrado no estoque.");
                int opcaoAlterarProduto;
                do{
                    System.out.print("\nDigite a opcao desejada:\n"
                        + "1 - Alterar o preco\n"
                        + "2 - Alterar a quantidade em estoque\n"
                        + "3 - Finalizar alteracoes\n"
                        + "Opcao: "); 
                   
                    opcaoAlterarProduto = scanner.nextInt();
                    scanner.nextLine();
   
                    switch(opcaoAlterarProduto){
                        case 1:
                            atualizaPreco(posProdutoAlterar);
                            break;
                        case 2:
                            atualizaQuantidade(posProdutoAlterar);
                            break;
                        case 3:
                            System.out.println("Alteracao finalizada com sucesso.\n\n");
                            break;
                        default:
                            System.out.println("Opcao Invalida");
                    }
                }while(opcaoAlterarProduto != 3);
            }
               
            else{
                System.out.print("Digite o preco unitario do produto: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();
                       
                System.out.print("Digite o tipo do produto: ");
                String tipo = scanner.nextLine();
                   
                System.out.print("Digite a quantidade no estoque: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();
                   
                estoque.guardaProdutoNoEstoque(nome, preco, tipo, quantidade, this.posEstoque);
                this.posEstoque += 1;
                   
                System.out.print(quantidade+ " " + nome + "(s) cadastrado com sucesso.\n\n");
            }
               
            System.out.print("Deseja cadastrar outro produto? ");
            opcaoContinuidade = scanner.nextLine();
                   
        }while(!opcaoContinuidade.equals("Nao"));
    }
   
    public void vendeProduto(){
               
        System.out.println("= = = = Venda de Produtos = = = =");
        String opcao;
        do{
            System.out.print("\nDigite o nome do produto: ");
            this.nomeProduto = scanner.nextLine();
            int posProduto = estoque.verificaProdutoEmEstoque(nomeProduto, this.posEstoque);
                   
            if(posProduto != -1){
                System.out.println("==> " + estoque.getProduto(posProduto));
                       
                System.out.print("Digite a quantidade que deseja vender: ");
                int qtVenda = scanner.nextInt();
                scanner.nextLine();   
                   
                if(qtVenda > estoque.getQuantidadeProduto(posProduto)){
                    System.out.println("Nao eh possivel vender pois nao ha "+ estoque.getNomeProduto(posProduto)+" suficiente.");
                }
                   
                else{
                    estoque.setQuantidadeProduto((estoque.getQuantidadeProduto(posProduto) - qtVenda), posProduto);
                    this.totalGasto += qtVenda * estoque.getPrecoProduto(posProduto);
                    System.out.print("==> Total arrecadado: R$");
                    System.out.printf("%.2f", (qtVenda * estoque.getPrecoProduto(posProduto)));
                    System.out.println("");
                }
                   
            }
               
            else{
                System.out.println("==> "+this.nomeProduto+" nao cadastrado no sistema.");
            }
                   
                System.out.print("Deseja vender outro produto? ");
                opcao = scanner.nextLine();
                       
        }while(!opcao.equals("Nao"));
               
    }
           
    public void imprimeBalanco(){
               
        System.out.println("= = = = Impressao de Balanco = = = = ");
        System.out.println("Produtos cadastrados: ");
   
        for(int i = 0; i < this.posEstoque; i++){
            System.out.println("    " + (i+1) + ")" + estoque.getProduto(i));
            somaValorTotal(i);
        }
           
        System.out.print("\nTotal arrecadado em vendas: R$");
        System.out.printf("%.2f", this.totalGasto);
        System.out.print("\nTotal que pode ser arrecadado: R$");
        System.out.printf("%.2f", (this.valorRestante));
        System.out.println("");
    }
       
    //Utilizado em cadastraProduto()
    private void atualizaPreco(int posicaoEstoque){
        System.out.print("\nDigite o novo preco: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();
        estoque.setPrecoProduto(novoPreco, posicaoEstoque);
        System.out.println("Preco alterado com sucesso.");
    }
       
    //Utilizado em cadastraProduto()
    private void atualizaQuantidade(int posicaoEstoque){
        System.out.print("\nDigite a nova quantidade: ");
        int novaQuantidade = scanner.nextInt();
        scanner.nextLine();
        estoque.setQuantidadeProduto(novaQuantidade, posicaoEstoque);
        System.out.println("Quantidade alterada com sucesso.");
    }
   
    private void somaValorTotal(int posicaoEstoque){
        this.valorRestante += estoque.valorParcialProduto(posicaoEstoque);
    }
}

