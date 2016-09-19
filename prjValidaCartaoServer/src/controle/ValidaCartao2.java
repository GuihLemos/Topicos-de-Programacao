package controle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCartao2 {

	/*
	 * Pattern visa = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})"); Pattern
	 * mastercard = Pattern.compile("^5[1-5][0-9]{14}"); Pattern amex =
	 * Pattern.compile("^3[47][0-9]{13}"); Pattern dinersClub =
	 * Pattern.compile("^3(?:0[0-5]|[68][0-9])[0-9]{11}");
	 */
	String visa = "^4[0-9]{12}(?:[0-9]{3})";
	String master = "^5[1-5][0-9]{14}";
	String amex = "^3[47][0-9]{13}";
	String diners = "^3(?:0[0-5]|[68][0-9])[0-9]{11}";

	public String validaCartao(String numero) {
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
