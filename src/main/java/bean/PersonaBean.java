package bean;

public class PersonaBean {
	 private String username;
	 private String nome;
	 private String cognome;
	 private String email;
	 private String telefono;
	 private String citta;
	 private int tipo;
	 private String comune;
	 private String password;
	 
     public PersonaBean() {}
     
     public PersonaBean(String username, String nome, String cognome, String email, String telefono, String citta, int tipo, String comune, String password) {
    	 this.username=username;
    	 this.nome=nome;
    	 this.cognome=cognome;
    	 this.email=email;
    	 this.telefono=telefono;
    	 this.citta=citta;
    	 this.tipo=tipo;
    	 this.comune= comune;
    	 this.password=password;
     }
     
     public PersonaBean( String username) {
    	 this.username=username;
     }
     
     
     public PersonaBean(String usr, String psw) {
		this.username=usr;
		this.password=psw;
	}

	// metodi GET
	public String getUsername() {
		return username;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCitta() {
		return citta;
	}

	public int getTipo() {
		return tipo;
	}

	public String getComune() {
		return comune;
	}

	public String getPassword() {
		return password;
	}

	//metodi SET
	public void setUsername(String username) {
		this.username = username;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PersonaBean [username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", telefono=" + telefono + ", citta=" + citta + ", tipo=" + tipo + ", comune=" + comune
				+ ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + tipo;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		PersonaBean other = (PersonaBean) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (comune == null) {
			if (other.comune != null)
				return false;
		} else if (!comune.equals(other.comune))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipo != other.tipo)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
     
	
    
}