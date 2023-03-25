package br.com.roberio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
						@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo
					 ) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String number) {
		if (number == null) return 0D;
		
		String n = number.replaceAll(",", ".");
		if (isNumeric(n)) return Double.parseDouble(n);
		
		return 0D;
	}

	private boolean isNumeric(String number) {
		if (number == null) return false;
		
		String n = number.replaceAll(",", ".");
		return n.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
