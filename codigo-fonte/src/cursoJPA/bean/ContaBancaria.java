package cursoJPA.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContaBancaria {

	//@Id seleciona o atributo abaixo da annotation como valor da chave prim�ria
	@Id
	//@GeneratedValue define a chave prim�ria como icremental
	@GeneratedValue
	private Long id;
	private String titular;
	private BigDecimal saldo;
	
	@Override
	public String toString() {
		return "Conta: "+id+" - "+titular;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
}
