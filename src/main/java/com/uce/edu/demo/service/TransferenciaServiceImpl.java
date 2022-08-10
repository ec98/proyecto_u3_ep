package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		// Buscar la cuenta Origen y obtener el saldo.
		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaOrigen);
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		// 1. restar el monto a la cta Origen
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);

		// Buscar la cuenta Destino y obtener el saldo.
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaDestino);
		// 2. sumar el monto a la cta Destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.iCuentaBancariaRepository.actualizar(ctaDestino);

		// Insert transferencia
		Transferencia transferencia = new Transferencia();
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setCuentaOrigen(ctaOrigen);
		transferencia.setCuentaDestino(ctaDestino);
		transferencia.setMonto(monto);

		this.iTransferenciaRepository.insert(transferencia);
	}// commit

	@Override
	@Transactional(value = TxType.REQUIRED) // crea una transaccion
	public void realizrTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);

	}
}
