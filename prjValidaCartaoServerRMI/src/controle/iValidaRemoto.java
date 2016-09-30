package controle;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iValidaRemoto extends Remote{

	public String validaCartao (String numero) throws RemoteException;		
	
}
