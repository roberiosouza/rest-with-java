package br.com.roberio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberio.converts.NumberConvert;
import br.com.roberio.exceptions.UnsupportedMathOperationException;
import br.com.roberio.math.SimpleMath;

@RestController
public class MathController {

	private SimpleMath math = new SimpleMath();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
						@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo
					 ) throws Exception {
		if (!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		
		return math.sum(NumberConvert.convertToDouble(numberOne),NumberConvert.convertToDouble(numberTwo));
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(
				@PathVariable(value = "numberOne") String numberOne,
				@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if (!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return math.sub(NumberConvert.convertToDouble(numberOne),NumberConvert.convertToDouble(numberTwo));
	}
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
	
		if (!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return math.mult(NumberConvert.convertToDouble(numberOne),NumberConvert.convertToDouble(numberTwo));
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
	
		if (!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return math.division(NumberConvert.convertToDouble(numberOne),NumberConvert.convertToDouble(numberTwo));
	}	
	
	@GetMapping("/media/{numberOne}/{numberTwo}")
	public Double media(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception {
	
		if (!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return math.media(NumberConvert.convertToDouble(numberOne),NumberConvert.convertToDouble(numberTwo));
	}		
	
	@GetMapping("/square/{number}")
	public Double square(
			@PathVariable(value = "number") String number
		) throws Exception {
	
		if (!NumberConvert.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a number value!");
		}
		return math.square(NumberConvert.convertToDouble(number));
	}


}
