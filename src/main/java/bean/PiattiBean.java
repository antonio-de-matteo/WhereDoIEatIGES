package bean;

public class PiattiBean {
   private int idPiatto;
   private String piatto;
   private String descrizione;
   private int attivitaIDAttivita;
   
   public PiattiBean() {}

   public PiattiBean(int idPiatto, String piatto, String descrizione, int attivitaIDAttivita) {
	 this.idPiatto = idPiatto;
	 this.piatto = piatto;
	 this.descrizione = descrizione;
	 this.attivitaIDAttivita = attivitaIDAttivita;
    }

   public PiattiBean(int idPiatto) {
	this.idPiatto=idPiatto;
}

	//metodi GET
    public int getIdPiatto() {
	  return idPiatto;
    }

    public String getPiatto() {
	  return piatto;
    }

    public String getDescrizione() {
	  return descrizione;
    }

    public int getAttivitaIDAttivita() {
	  return attivitaIDAttivita;
    }

    //metodi SET
    public void setIdPiatto(int idPiatto) {
	  this.idPiatto = idPiatto;
    }

    public void setPiatto(String piatto) {
	  this.piatto = piatto;
    }

    public void setDescrizione(String descrizione) {
	  this.descrizione = descrizione;
    }

    public void setAttivitaIDAttivita(int attivitaIDAttivita) {
	  this.attivitaIDAttivita = attivitaIDAttivita;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attivitaIDAttivita;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + idPiatto;
		result = prime * result + ((piatto == null) ? 0 : piatto.hashCode());
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
		PiattiBean other = (PiattiBean) obj;
		if (attivitaIDAttivita != other.attivitaIDAttivita)
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (idPiatto != other.idPiatto)
			return false;
		if (piatto == null) {
			if (other.piatto != null)
				return false;
		} else if (!piatto.equals(other.piatto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PiattiBean [idPiatto=" + idPiatto + ", piatto=" + piatto + ", descrizione=" + descrizione
				+ ", attivitaIDAttivita=" + attivitaIDAttivita + "]";
	}
    
    
      
   
}