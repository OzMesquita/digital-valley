package util;

public class TokenBuild {
	public static String buildToken() {
		int qtdeCaracteres = 60;
		String[] caracteres = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		StringBuilder token = new StringBuilder();
		for (int i = 0; i < qtdeCaracteres; i++) {
			int posicao = (int) (Math.random() * caracteres.length);
			token.append(caracteres[posicao]);
		}
		return token.toString();
	}
}
