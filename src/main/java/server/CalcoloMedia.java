package server;

public class CalcoloMedia {
     private int id;
     private float media;
      
     public CalcoloMedia(int id, float media) {
    	 this.id=id;
    	 this.media=media;
     }
     
     public CalcoloMedia() {}

	public int getId() {
		return id;
	}

	public float getMedia() {
		return media;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMedia(float media) {
		this.media = media;
	}
     
     
}
