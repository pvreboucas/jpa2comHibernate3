package cursoJPA.valueObject;

public class ValorPorMes {
	
	private int mes;
	private Double valor;
	
	public ValorPorMes(int mes, Double valor) {
		this.mes = mes;
		this.valor = valor;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
