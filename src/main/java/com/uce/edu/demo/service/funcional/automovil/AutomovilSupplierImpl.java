package com.uce.edu.demo.service.funcional.automovil;

import java.math.BigDecimal;

public class AutomovilSupplierImpl implements IAutomovilSupplier<BigDecimal> {

	@Override
	public BigDecimal getCosto() {
		// TODO Auto-generated method stub
		return new BigDecimal("20000");
	}

}
