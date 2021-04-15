package bean;

public class SuggerimentiBean {
   private int id;
   private String titolo;
   private String testo;
   private String personaUsername;
public SuggerimentiBean(int id, String titolo, String testo, String personaUsername) {
	this.id = id;
	this.titolo = titolo;
	this.testo = testo;
	this.personaUsername = personaUsername;
}
   
public SuggerimentiBean() {}

public SuggerimentiBean(int id) {
	this.id=id;
}

// metodi GET
public int getId() {
	return id;
}

public String getTitolo() {
	return titolo;
}

public String getTesto() {
	return testo;
}

public String getPersonaUsername() {
	return personaUsername;
}

//metodi SET
public void setId(int id) {
	this.id = id;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public void setTesto(String testo) {
	this.testo = testo;
}

public void setPersonaUsername(String personaUsername) {
	this.personaUsername = personaUsername;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((personaUsername == null) ? 0 : personaUsername.hashCode());
	result = prime * result + ((testo == null) ? 0 : testo.hashCode());
	result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
	SuggerimentiBean other = (SuggerimentiBean) obj;
	if (id != other.id)
		return false;
	if (personaUsername == null) {
		if (other.personaUsername != null)
			return false;
	} else if (!personaUsername.equals(other.personaUsername))
		return false;
	if (testo == null) {
		if (other.testo != null)
			return false;
	} else if (!testo.equals(other.testo))
		return false;
	if (titolo == null) {
		if (other.titolo != null)
			return false;
	} else if (!titolo.equals(other.titolo))
		return false;
	return true;
}

@Override
public String toString() {
	return "SuggerimentiBean [id=" + id + ", titolo=" + titolo + ", testo=" + testo + ", personaUsername="
			+ personaUsername + "]";
}


	
}