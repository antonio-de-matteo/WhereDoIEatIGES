package bean;

public class PreferitiBean {
	private int idPref;
    private String personaUsername;
    private int attivitaIDAttivita;
    
    public PreferitiBean() {}

	public PreferitiBean(String personaUsername, int attivitaIDAttivita) {
		this.personaUsername = personaUsername;
		this.attivitaIDAttivita = attivitaIDAttivita;
	}

	//metodi GET
	public int getIdPref() {
		return idPref;
	}
	
	public String getPersonaUsername() {
		return personaUsername;
	}

	public int getAttivitaIDAttivita() {
		return attivitaIDAttivita;
	}

	//metodi SET
	public void setPersonaUsername(String personaUsername) {
		this.personaUsername = personaUsername;
	}

	public void setAttivitaIDAttivita(int attivitaIDAttivita) {
		this.attivitaIDAttivita = attivitaIDAttivita;
	}
	public void setIdPref(int id) {
		this.idPref=id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attivitaIDAttivita;
		result = prime * result + idPref;
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
		PreferitiBean other = (PreferitiBean) obj;
		if (attivitaIDAttivita != other.attivitaIDAttivita)
			return false;
		if (idPref != other.idPref)
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
		return "PreferitiBean [idPref=" + idPref + ", personaUsername=" + personaUsername + ", attivitaIDAttivita="
				+ attivitaIDAttivita + "]";
	}

	
    
	
    
}