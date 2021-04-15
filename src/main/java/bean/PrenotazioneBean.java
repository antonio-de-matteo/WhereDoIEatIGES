package bean;

import java.util.Date;

public class PrenotazioneBean {
	private int idPren;
    private String data;
    private int ora;
    private int numPosti;
    private String personaUsername;
    private int attivitaIDAttivita;
	
    public PrenotazioneBean(int idPren, String data, int ora, int numPosti, String personaUsername, int attivitaIDAttivita) {
		this.idPren=idPren;
    	this.data = data;
		this.ora = ora;
		this.numPosti = numPosti;
		this.personaUsername = personaUsername;
		this.attivitaIDAttivita = attivitaIDAttivita;
	}
    
    public PrenotazioneBean() {}

    public PrenotazioneBean(int idPren) {
		this.idPren=idPren;
	}

	//metodi GET
    public int getIdPren()  {
    	return idPren;
    }
    
	public String getData() {
		return data;
	}

	public int getOra() {
		return ora;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public String getPersonaUsername() {
		return personaUsername;
	}

	public int getAttivitaIDAttivita() {
		return attivitaIDAttivita;
	}

	//Metodi SET
	public void setIdPren(int idPren) {
		this.idPren=idPren;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public void setOra(int ora) {
		this.ora = ora;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
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
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + idPren;
		result = prime * result + numPosti;
		result = prime * result + ora;
		result = prime * result + ((personaUsername == null) ? 0 : personaUsername.hashCode());
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
		PrenotazioneBean other = (PrenotazioneBean) obj;
		if (attivitaIDAttivita != other.attivitaIDAttivita)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idPren != other.idPren)
			return false;
		if (numPosti != other.numPosti)
			return false;
		if (ora != other.ora)
			return false;
		if (personaUsername == null) {
			if (other.personaUsername != null)
				return false;
		} else if (!personaUsername.equals(other.personaUsername))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrenotazioneBean [idPren=" + idPren + ", data=" + data + ", ora=" + ora + ", numPosti=" + numPosti
				+ ", personaUsername=" + personaUsername + ", attivitaIDAttivita=" + attivitaIDAttivita + "]";
	}
    
	
	
}
