/* 115110236 - Vinícius de Medeiros Soares: LAB 3 - Turma 1 */

package EconomizaP2;

import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args){
        
        Supermercado economiza = new Supermercado();
        Scanner scanner = new Scanner(System.in);   
        System.out.println("= = = = Bem‐vindo(a) ao EconomizaP2 = = = =");
        int opcao;
         
        do{
            System.out.print("\nDigite a opcao desejada: \n"
                    + "1 ‐ Cadastrar um Produto \n"
                    + "2 ‐ Vender um Produto \n"
                    + "3 ‐ Imprimir Balanco \n"
                    + "4 ‐ Sair \n\n"
                    + "Opcao: ");
             
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:
                    economiza.cadastraProduto();
                    break;
                case 2:
                    economiza.vendeProduto();
                    break;
                case 3:
                    economiza.imprimeBalanco();
                    break;
                case 4:
                    System.out.println("= = = = Programa Encerrado = = = =");
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }
        }while(opcao != 4);
    }
}