package br.com.roberio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
						@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo
					 ) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(
				@PathVariable(value = "numberOne") String numberOne,
				@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
	
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
	
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}	
	
	@GetMapping("/average/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
	
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	}		
	
	@GetMapping("/square/{number}")
	public Double square(
			@PathVariable(value = "number") String number
		) throws Exception {
	
		if (!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return Math.sqrt(convertToDouble(number));
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
