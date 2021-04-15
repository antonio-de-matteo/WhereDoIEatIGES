package bean;

public class RecensioneBean {
	private int idRecensione;
    private int valutazione;
    private String commento;
    private String personaUsername;
    private int attivitaIDAttivita;
	public RecensioneBean(int valutazione, String commento, String personaUsername, int attivitaIDAttivita) {
		this.valutazione = valutazione;
		this.commento = commento;
		this.personaUsername = personaUsername;
		this.attivitaIDAttivita = attivitaIDAttivita;
	}
     
	public RecensioneBean() {}

	public RecensioneBean(String personaUsername2, int attivitaIDAttivita2) {
		this.attivitaIDAttivita=attivitaIDAttivita2;
		this.personaUsername=personaUsername2;
	}

	//metodi GET
	public int getIdRecensione() {
		return idRecensione;
	}
	public int getValutazione() {
		return valutazione;
	}

	public String getCommento() {
		return commento;
	}

	public String getPersonaUsername() {
		return personaUsername;
	}

	public int getAttivitaIDAttivita() {
		return attivitaIDAttivita;
	}

	//Metodi SET
	public void setIdRecensione(int idRecensione) {
		this.idRecensione=idRecensione;
	}
	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public void setPersonaUsername(String personaUsername) {
		this.personaUsername = personaUsername;
	}

	public void setAttivitaIDAttivita(int attivitaIDAttivita) {
		this.attivitaIDAttivita = attivitaIDAttivita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attivitaIDAttivita;
		result = prime * result + ((commento == null) ? 0 : commento.hashCode());
		result = prime * result + ((personaUsername == null) ? 0 : personaUsername.hashCode());
		result = prime * result + valutazione;
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
		RecensioneBean other = (RecensioneBean) obj;
		if (attivitaIDAttivita != other.attivitaIDAttivita)
			return false;
		if (commento == null) {
			if (other.commento != null)
				return false;
		} else if (!commento.equals(other.commento))
			return false;
		if (personaUsername == null) {
			if (other.personaUsername != null)
				return false;
		} else if (!personaUsername.equals(other.personaUsername))
			return false;
		if (valutazione != other.valutazione)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecensioneBean [valutazione=" + valutazione + ", commento=" + commento + ", personaUsername="
				+ personaUsername + ", attivitaIDAttivita=" + attivitaIDAttivita + "]";
	}
	
	
    
}