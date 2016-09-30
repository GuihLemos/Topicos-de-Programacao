package controle;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCartao extends UnicastRemoteObject implements iValidaRemoto {
	String visa = "^4[0-9]{12}(?:[0-9]{3})";
	String master = "^5[1-5][0-9]{14}";
	String amex = "^3[47][0-9]{13}";
	String diners = "^3(?:0[0-5]|[68][0-9])[0-9]{11}";

	public ValidaCartao() throws RemoteException {

	}

	public String validaCartao(String numero) throws RemoteException {
		Pattern pattern = Pattern.compile(visa);
		Matcher matcher = pattern.matcher(numero);
		if (matcher.find())
			return "O cartao e valido, bandeira: Visa";
		else {
			pattern = Pattern.compile(master);
			matcher = pattern.matcher(numero);
			if (matcher.find())
				return "O cartao e valido, bandeira: Mastercard";
			else {
				pattern = Pattern.compile(amex);
				matcher = pattern.matcher(numero);
				if (matcher.find())
					return "O cartao e valido, bandeira: Amex";
				else {
					pattern = Pattern.compile(diners);
					matcher = pattern.matcher(numero);
					if (matcher.find())
						return "O cartao e valido, bandeira: Diners";
					else {
						return "O cartao é invalido! Digite outro numero.";
					}
				}
			}
		}

	}
}
