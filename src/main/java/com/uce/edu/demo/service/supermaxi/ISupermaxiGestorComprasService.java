package com.uce.edu.demo.service.supermaxi;

import java.util.List;

public interface ISupermaxiGestorComprasService {
	
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> codigo);
}
