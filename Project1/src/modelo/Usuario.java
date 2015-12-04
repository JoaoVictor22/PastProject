package modelo;

public class Usuario {
	private String nick;
	private String email;
	private String senha;
	private int codigo;
	
	public Usuario() {
		
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String i) {
		this.nick = i;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "usuario [nick=" + nick + ", email=" + email + ", senha="
				+ senha + "]";
	}
	public Usuario(String nick, String email, String senha) {
		super();
		
		this.nick = nick;
		this.email = email;
		this.senha = senha;
	}
		public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	

}