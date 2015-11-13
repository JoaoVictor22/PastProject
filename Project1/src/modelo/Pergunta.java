package modelo;

public class Pergunta {
	
	private String pergunta;
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private String resposta4;
	private String resposta5;
	private String respostacerta;
	private int codigo;
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		
		return codigo;
	}

	public String getPergunta() {
		return pergunta;
	}
	@Override
	public String toString() {
		return "Pergunta [pergunta=" + pergunta + ", resposta1=" + resposta1 + ", resposta2=" + resposta2
				+ ", resposta3=" + resposta3 + ", resposta4=" + resposta4 + ", resposta5=" + resposta5
				+ ", respostacerta=" + respostacerta + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pergunta == null) ? 0 : pergunta.hashCode());
		result = prime * result + ((resposta1 == null) ? 0 : resposta1.hashCode());
		result = prime * result + ((resposta2 == null) ? 0 : resposta2.hashCode());
		result = prime * result + ((resposta3 == null) ? 0 : resposta3.hashCode());
		result = prime * result + ((resposta4 == null) ? 0 : resposta4.hashCode());
		result = prime * result + ((resposta5 == null) ? 0 : resposta5.hashCode());
		result = prime * result + ((respostacerta == null) ? 0 : respostacerta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		if (resposta1 == null) {
			if (other.resposta1 != null)
				return false;
		} else if (!resposta1.equals(other.resposta1))
			return false;
		if (resposta2 == null) {
			if (other.resposta2 != null)
				return false;
		} else if (!resposta2.equals(other.resposta2))
			return false;
		if (resposta3 == null) {
			if (other.resposta3 != null)
				return false;
		} else if (!resposta3.equals(other.resposta3))
			return false;
		if (resposta4 == null) {
			if (other.resposta4 != null)
				return false;
		} else if (!resposta4.equals(other.resposta4))
			return false;
		if (resposta5 == null) {
			if (other.resposta5 != null)
				return false;
		} else if (!resposta5.equals(other.resposta5))
			return false;
		if (respostacerta == null) {
			if (other.respostacerta != null)
				return false;
		} else if (!respostacerta.equals(other.respostacerta))
			return false;
		return true;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta1() {
		return resposta1;
	}
	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
	}
	public String getResposta2() {
		return resposta2;
	}
	public void setResposta2(String resposta2) {
		this.resposta2 = resposta2;
	}
	public String getResposta3() {
		return resposta3;
	}
	public void setResposta3(String resposta3) {
		this.resposta3 = resposta3;
	}
	public String getResposta4() {
		return resposta4;
	}
	public void setResposta4(String resposta4) {
		this.resposta4 = resposta4;
	}
	public String getResposta5() {
		return resposta5;
	}
	public void setResposta5(String resposta5) {
		this.resposta5 = resposta5;
	}
	public String getRespostacerta() {
		return respostacerta;
	}
	public void setRespostacerta(String respostacerta) {
		this.respostacerta = respostacerta;
	}

	
	
	
}
