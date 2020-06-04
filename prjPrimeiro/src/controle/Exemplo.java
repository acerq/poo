package controle;

import java.util.Scanner;

public class Exemplo {
	/**
	 * Trechos de código para exemplificar aspectos de Java
	 */
	public static void exemplo() {
		
		String str1 = "abc";
		System.out.println(str1 + "->" + str1.hashCode());
		
		String str2 = "abc";
		System.out.println(str1 + "->" + str1.hashCode());

		String str3 = new String("abc");
		System.out.println(str3 + "->" + str3.hashCode());

		if(str1 == str2)
			System.out.println("(1) str1 == str2");
		if(str1.equals(str2))
			System.out.println("(1) str1 equals str2");		
		if(str1.equalsIgnoreCase(str2))
			System.out.println("(1) str1 equalsIgnoreCase str2");
		
		str1.toUpperCase();
		System.out.println(str1 + "->" + str1.hashCode());

		if(str1 == str2)
			System.out.println("(2) str1 == str2");
		if(str1.equals(str2))
			System.out.println("(2) str1 equals str2");		
		if(str1.equalsIgnoreCase(str2))
			System.out.println("(2) str1 equalsIgnoreCase str2");
		
		str1 = str1.toUpperCase();
		System.out.println(str1 + "->" + str1.hashCode());
		
		if(str1 == str2)
			System.out.println("(3) str1 == str2");
		if(str1.equals(str2))
			System.out.println("(3) str1 equals str2");		
		if(str1.equalsIgnoreCase(str2))
			System.out.println("(1) str1 equalsIgnoreCase str2");
		
		System.out.println("Alô Mundo"); // ; demarca uma instrução
		System.out.println("Tudo bem?");

		int i; // instrução com declaração de uma variável
		for (i = 0; i < 5; i++) {
			// Comando for contendo uma única instrução (System.out.println)
			System.out.print("O Valor de i = ");
			System.out.println(i);
			if (i % 2 == 0)
				System.out.println(i + " é um número par");
			else
				System.out.println(i + " é um número ímpar");
		}

		// Exemplos de Literais char
		char c = '\'';
		System.out.println(c);
		c = '\\';
		System.out.println(c);
		System.out.println(); // sysout e CTRL+ESPAÇO expande para System.out.println

		// Exemplo do Módulo 2 (e repetido no módulo 3)
		// OBSERVAÇÃO -> Tornei Pessoa uma Classe Abstrata. Assim, não podemos dar 'new' agora 
		//Pessoa p1, p2, p3;
		//p1 = new Pessoa("123.456.789-09", "José da Silva"); // presença de 2 operadores
		//p2 = new Pessoa("098.765.432-10", "Maria de Souza");
		//p3 = p1;

		//String exemplo = "Concatenção com p1: " + p1;
		//System.out.println(exemplo);

		//System.out.println(p1.getCpf());
		//System.out.println(p2.getCpf());
		//System.out.println();

		// Exemplo de Switch
		int valor;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Entre com um número: ");
		String aux = teclado.nextLine();
		
		try {
			valor = Integer.parseInt(aux); // Converte a String lida em um número inteiro
		}
		catch(NumberFormatException e) {
			System.out.println("Eu pedi um número inteiro!!!");
			valor = 789;
		}
		
		switch (valor) {
		case 0:
			System.out.println("O valor foi 0");
			break;
		case 3:
			System.out.println("O valor foi 3");
			break;
		case 7:
			System.out.println("O valor foi 7");
			break;
		default:
			System.out.println("O valor é diferente de 0, 3 e 7");
			break;
		}
	}

}
//
//Configuração para o DEBUG
//
//[Window][Preferences][Java][Debug][Step Filtering]
//Marcar todos os pacotes
//