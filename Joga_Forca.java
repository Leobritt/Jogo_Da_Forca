package Joga_Forca;

import java.util.Scanner;

public class Joga_Forca {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String palavra_Chave = "Leonardo";

		String letras_Usadas = "";

		String palavra_advinhada = "";

		int numero_tentaivas_maximo = 8;

		for (int i = 0; i < palavra_Chave.length(); i++) {
			palavra_advinhada += "_";

			for (int j = 0;; j++) {
				if (j == numero_tentaivas_maximo) {
					System.out.println("Sinto muito! Número máximo de tentativas alcançado!");
					System.exit(0);
					// System.exit(0) sinalizar q o programa foi finalizado
				}

				System.out.printf("Rodada %d. Até agora advinhada: %s. Qual a próxima letra?%n", j, palavra_advinhada);

				char letraTentada = input.next().charAt(0);

				if (letras_Usadas.indexOf(letraTentada) >= 0) {
					// se encontrou letra tentada dentro de letras usadas
					System.out.println("Esse Letra já foi usada " + letraTentada);
				} else {
					letras_Usadas += letraTentada;
				}
				if (palavra_Chave.indexOf(letraTentada) >= 0) {
					palavra_advinhada = "";

					for (int k = 0; k < palavra_Chave.length(); k++) {
						if (letras_Usadas.indexOf(palavra_Chave.charAt(k)) >= 0) {
							// se encontrou letras usadas dentro de palavra chave
							// pegA palavra advinhada a palavra chave
							palavra_advinhada += palavra_Chave.charAt(k);
						} else
							palavra_advinhada += "_";
						// se não deixa o espaço cm "_"
					}
					if (palavra_advinhada.contains("_")) {
						System.out.println("Ainda tem letra(s) para ser advinhada(s): " + letraTentada);
					} else {
						System.out.println("Jogo finalizado! Palavra advinhada " + palavra_advinhada);
						System.exit(0);
					}
				}else {
					System.out.println("Letra não existe na palavra "+letraTentada);
					
				}

			}
		}
		input.close();
	}
}
