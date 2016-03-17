/* 115110267 - Raquel Rufino Costa da Paz: LAB 03 - Turma 1 */
package EconomizaP2;

import java.util.Scanner;

public class Entrada {

	private Scanner teclado;

	public Entrada() {
		teclado = new Scanner(System.in);
	}

	public double receberDouble() {
		double numero;
		numero = teclado.nextDouble();
		teclado.nextLine();
		return numero;
	}

	public int receberInteiro() {
		int numero;
		numero = teclado.nextInt();
		teclado.nextLine();
		return numero;
	}

	public String receberString() {
		String word = teclado.nextLine();
		return word;

	}

}