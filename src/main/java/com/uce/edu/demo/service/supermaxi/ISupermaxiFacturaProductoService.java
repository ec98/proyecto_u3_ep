package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.util.List;

public interface ISupermaxiFacturaProductoService {

	public BigDecimal compraProducto(String cedula, String numero, List<String> codigo);

}
