package bean;

public class FotoBean {
    private String foto;
    private int attivitaIDAttivita;
    
    public FotoBean() {}

	public FotoBean(String foto, int attivitaIDAttivita) {
		this.foto = foto;
		this.attivitaIDAttivita = attivitaIDAttivita;
	}

	public FotoBean(String foto) {
		this.foto=foto;
	}

	//metodi GET
	public String getFoto() {
		return foto;
	}

	public int getAttivitaIDAttivita() {
		return attivitaIDAttivita;
	}

	//metodi SET
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setAttivitaIDAttivita(int attivitaIDAttivita) {
		this.attivitaIDAttivita = attivitaIDAttivita;
	}

	@Override
	public String toString() {
		return "FotoBean [foto=" + foto + ", attivitaIDAttivita=" + attivitaIDAttivita + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attivitaIDAttivita;
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
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
		FotoBean other = (FotoBean) obj;
		if (attivitaIDAttivita != other.attivitaIDAttivita)
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		return true;
	}
	
	
    
}