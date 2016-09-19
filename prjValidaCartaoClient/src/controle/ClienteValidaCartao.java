package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteValidaCartao {

	public static void main(String[] args) {
		Socket sckClient;
		InputStream cnlEntrada;
		OutputStream cnlSaida;
		BufferedReader entrada;
		PrintWriter saida;
		Scanner leia = new Scanner(System.in);

		try {
			sckClient = new Socket("127.0.0.1", 4000);
			cnlEntrada = sckClient.getInputStream();
			cnlSaida = sckClient.getOutputStream();
			entrada = new BufferedReader(new InputStreamReader(cnlEntrada));
			saida = new PrintWriter(cnlSaida, true);
			System.out.println("Digite um numero de cartao");
			String numero = leia.nextLine();
			saida.println(numero);

			for (;;) {
				String s = entrada.readLine();
				if (s == null)
					break;
				System.out.println(s);
			}
			// Termino a conexão com o servidor

			sckClient.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
