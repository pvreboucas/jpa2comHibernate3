package cursoJPA.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ContaBancaria {
	
	//@Id seleciona o atributo abaixo da annotation como valor da chave primária
	@Id
	//@GeneratedValue define a chave primária como icremental
	@GeneratedValue
	private Long id;
	private String titular;
	private BigDecimal saldo;
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

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
	public void setSaldo(BigDecimal i) {
		this.saldo = i;
	}
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
}
