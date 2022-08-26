package com.uce.edu.demo.service.funcional.automovil;

public class AutomovilUnaryOperatorImpl implements IAutomovilUnaryOperator<String> {

	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		return arg1.concat(" AX ") + "2023";
	}

}
