package modelo;

public class Usuario {
	private String nick;
	private String email;
<<<<<<< HEAD
	private String senha;
	
=======
>>>>>>> e4d73cd9a207b9908c19a2b75676076ad17f5229
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
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	
=======
	private String senha;
>>>>>>> e4d73cd9a207b9908c19a2b75676076ad17f5229
	

}