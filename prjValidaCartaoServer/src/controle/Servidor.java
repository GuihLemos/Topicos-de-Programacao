package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private ServerSocket sckServidor;
	private ValidaCartao2 valida;
	
	public Servidor() throws IOException {
		this.valida = new ValidaCartao2();
		this.sckServidor = new ServerSocket(4000);
		for (;;) {
			Socket requisicao = this.sckServidor.accept();
			InputStream cnlEntrada;
			OutputStream cnlSaida;
			BufferedReader entrada;
			PrintWriter saida;
			
			try{
				cnlEntrada = requisicao.getInputStream();
				cnlSaida = requisicao.getOutputStream();
				entrada = new BufferedReader(new InputStreamReader(cnlEntrada));
				saida = new PrintWriter(cnlSaida, true);
				saida.println("Requisicao aceita pelo servidor.");
				
				String numero = entrada.readLine();
				saida.println(valida.validaCartao(numero));
				
				requisicao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
