package cursoJPA.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContaBancaria {

	//@Id seleciona o atributo abaixo da annotation como valor da chave primária
	@Id
	//@GeneratedValue define a chave primária como icremental
	@GeneratedValue
	private Long id;
	private String titular;
	private double saldo;
	
	@Override
	public String toString() {
		return id+" - "+titular;
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
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
