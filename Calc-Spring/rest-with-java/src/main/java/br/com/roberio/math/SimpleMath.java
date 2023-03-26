package br.com.roberio.math;

public class SimpleMath {
	
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}
	
	public Double sub(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}
	
	public Double mult(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}
	
	public Double division(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}	
	
	public Double media(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}		
	
	public Double square(Double number) {
		return Math.sqrt(number);
	}
}
