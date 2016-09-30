package controle;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ProgramaServidor {
	
	public static void main (String[] args) throws Exception {
		
		LocateRegistry.createRegistry(1099);
		ValidaCartao valida = new ValidaCartao();
		Naming.rebind("validaCartao", valida);
		System.out.println("Pronto para operar");
	}

}
