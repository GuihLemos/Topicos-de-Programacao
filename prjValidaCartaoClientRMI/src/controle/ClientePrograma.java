package controle;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientePrograma {

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		String urlServidor = "127.0.0.1";
		String nomeObjRemoto = "validaCartao";
		iValidaRemoto objValidaCartao = (iValidaRemoto) Naming.lookup("rmi://" + urlServidor + "/" + nomeObjRemoto);
		while(true){
			System.out.println("Digite um numero de cartão");
			String numCartao = input.next();
			String resultado = objValidaCartao.validaCartao(numCartao);
			System.out.println(resultado);
			
		}
	}

}
