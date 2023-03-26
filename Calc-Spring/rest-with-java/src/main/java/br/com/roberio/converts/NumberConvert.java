package br.com.roberio.converts;

public class NumberConvert {
	public static Double convertToDouble(String number) {
		if (number == null) return 0D;
		
		String n = number.replaceAll(",", ".");
		if (isNumeric(n)) return Double.parseDouble(n);
		
		return 0D;
	}

	public static boolean isNumeric(String number) {
		if (number == null) return false;
		
		String n = number.replaceAll(",", ".");
		return n.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
