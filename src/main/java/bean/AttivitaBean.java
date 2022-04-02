package bean;

public class AttivitaBean {
    private int idAttivita;
    private String nome;
    private String comune;
    private int oraApertura;
    private int oraChiusura;
    private String giornoChiusura;
    private String indirizzo;
    private String telefono;
    private int numPosti;
    private String mappa;
    private String personaUsername;
    private String categoria;

	public AttivitaBean(int idAttivita, String nome, String comune, int oraApertura, int oraChiusura,
			String giornoChiusura, String indirizzo, String telefono, int numPosti, String mappa,
			String personaUsername) {
		this.idAttivita = idAttivita;
		this.nome = nome;
		this.comune = comune;
		this.oraApertura = oraApertura;
		this.oraChiusura = oraChiusura;
		this.giornoChiusura = giornoChiusura;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.numPosti = numPosti;
		this.mappa = mappa;
		this.personaUsername = personaUsername;
	}


	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public AttivitaBean(int idAttivita, String nome, String comune, int oraApertura, int oraChiusura, String giornoChiusura, String indirizzo, String telefono, int numPosti, String mappa, String personaUsername, String categoria) {
		this.idAttivita = idAttivita;
		this.nome = nome;
		this.comune = comune;
		this.oraApertura = oraApertura;
		this.oraChiusura = oraChiusura;
		this.giornoChiusura = giornoChiusura;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.numPosti = numPosti;
		this.mappa = mappa;
		this.personaUsername = personaUsername;
		this.categoria = categoria;
	}

	public AttivitaBean() {

	}

	public AttivitaBean(int idAttivita) {
	     this.idAttivita=idAttivita;
	}

	//metodi GET 
	public int getIdAttivita() {
		return idAttivita;
	}

	public String getNome() {
		return nome;
	}

	public String getComune() {
		return comune;
	}

	public int getOraApertura() {
		return oraApertura;
	}

	public int getOraChiusura() {
		return oraChiusura;
	}

	public String getGiornoChiusura() {
		return giornoChiusura;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public String getMappa() {
		return mappa;
	}

	public String getPersonaUsername() {
		return personaUsername;
	}

	//metodi SET
	public void setIdAttivita(int idAttivita) {
		this.idAttivita = idAttivita;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public void setOraApertura(int oraApertura) {
		this.oraApertura = oraApertura;
	}

	public void setOraChiusura(int oraChiusura) {
		this.oraChiusura = oraChiusura;
	}

	public void setGiornoChiusura(String giornoChiusura) {
		this.giornoChiusura = giornoChiusura;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public void setMappa(String mappa) {
		this.mappa = mappa;
	}

	public void setPersonaUsername(String personaUsername) {
		this.personaUsername = personaUsername;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((giornoChiusura == null) ? 0 : giornoChiusura.hashCode());
		result = prime * result + idAttivita;
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((mappa == null) ? 0 : mappa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numPosti;
		result = prime * result + oraApertura;
		result = prime * result + oraChiusura;
		result = prime * result + ((personaUsername == null) ? 0 : personaUsername.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		AttivitaBean other = (AttivitaBean) obj;
		if (comune == null) {
			if (other.comune != null)
				return false;
		} else if (!comune.equals(other.comune))
			return false;
		if (giornoChiusura == null) {
			if (other.giornoChiusura != null)
				return false;
		} else if (!giornoChiusura.equals(other.giornoChiusura))
			return false;
		if (idAttivita != other.idAttivita)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (mappa == null) {
			if (other.mappa != null)
				return false;
		} else if (!mappa.equals(other.mappa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numPosti != other.numPosti)
			return false;
		if (oraApertura != other.oraApertura)
			return false;
		if (oraChiusura != other.oraChiusura)
			return false;
		if (personaUsername == null) {
			if (other.personaUsername != null)
				return false;
		} else if (!personaUsername.equals(other.personaUsername))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttivitaBean [idAttivita=" + idAttivita + ", nome=" + nome + ", comune=" + comune + ", oraApertura="
				+ oraApertura + ", oraChiusura=" + oraChiusura + ", giornoChiusura=" + giornoChiusura + ", indirizzo="
				+ indirizzo + ", telefono=" + telefono + ", numPosti=" + numPosti + ", mappa=" + mappa
				+ ", personaUsername=" + personaUsername + ", categoria=" + categoria + "]";
	}    
    
}