package controle;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidaCartao2 valida = new ValidaCartao2();
		Scanner input = new Scanner(System.in);
		System.out.println("Digite um numero de cartao: ");
		String numero = input.next();
		System.out.println(valida.validaCartao(numero));
		
	}

}
