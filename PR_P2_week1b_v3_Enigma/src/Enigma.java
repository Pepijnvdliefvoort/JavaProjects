public class Enigma {

	public String code(String message) {		
		if (!validateMessage(message)) {
			return "Onjuiste characters opgegeven!";
		}

		String code = "";
		String[] words = message.split(" ");

		for (int i = 0; i < words.length; i++) {
			char[] word = words[i].toCharArray();
			for (int j = 0; j < word.length; j++) {
				StringBuffer hex = new StringBuffer();
				
				if(word[j] == '.') {
					hex.append(Integer.toHexString(word[j]));
					code += hex + " ";
					break;
				}
				
				char asciiChar = (char) (word[j] + (i + 1));
				asciiChar -= (j + 1);
				hex.append(Integer.toHexString((int)asciiChar));
				
				code += hex + " ";
			}

			if ((i + 1) < words.length) {
				code += "20 ";
			}
			
		}

		return code.toUpperCase();
	}

	public String decode(String codedMessage) {
		return "return";
	}

	public boolean validateMessage(String message) {
		char[] chars = message.toCharArray();

		for (char item : chars) {
			if ((item >= 'a' && item <= 'z') || (item >= 'A' && item <= 'Z') || (item == ' ') || (item == ',')
					|| (item == '.')) {
			} else {
				return false;
			}
		}
		return true;
	}

	
}
