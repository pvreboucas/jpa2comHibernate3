package cursoJPA.bean;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue
	private Long id;
	//chave estrangeira; relação (1,N)
	@ManyToOne
	private ContaBancaria conta;
	private String descricao;
	private Calendar data;
	private BigDecimal valor;
	//busca na classe enum o índice da sequência de enumerados,
	//porém EnumType retorna o tipo do enumerado
	@Enumerated(EnumType.STRING)
	private TipoMovto tipo;
	
	@Override
	public String toString() {
		return conta+" - "+"transação: "+id+" - "+tipo.name()+" - "+ descricao+" - "+data+" - "+valor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ContaBancaria getConta() {
		return conta;
	}
	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoMovto getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovto tipo) {
		this.tipo = tipo;
	}
	

}
