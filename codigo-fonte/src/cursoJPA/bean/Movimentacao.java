package cursoJPA.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue
	private Long id;
	//chave estrangeira; rela��o (1,N)
	@ManyToOne
	private ContaBancaria conta;
	private String descricao;
	private Calendar data;
	private BigDecimal valor;
	//Usar o Eager n�o � uma boa pr�tica. Prejudica o desempenho.
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Tag> tags = new ArrayList<Tag>();
	//busca na classe enum o �ndice da sequ�ncia de enumerados,
	//por�m EnumType retorna o tipo do enumerado
	@Enumerated(EnumType.STRING)
	private TipoMovto tipo;
	
	@Override
	public String toString() {
		return conta.toString()+"\n "+"transa��o: "+id+" - "+tipo.name()+" - "+ descricao+" - "+data+" - "+valor;
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	

}
