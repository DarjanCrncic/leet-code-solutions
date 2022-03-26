package test;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {

		if (n == 1) {
			return "1";
		}
		if (n == 2) {
			return "11";
		}
		String current = countAndSay(n - 1);

		int charCounter = 1;

		StringBuilder str = new StringBuilder();
		for (int i = 1; i < current.length(); i++) {
			if (current.charAt(i) == current.charAt(i-1)) {
				charCounter++;
			} else {
				str.append(charCounter).append(current.charAt(i-1));
				charCounter = 1;
			}
			if (i == current.length()-1) {
				str.append(charCounter).append(current.charAt(i));
			}
		}
		
		return str.toString();

	}
}
