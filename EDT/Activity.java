package EDT;

/* creation d'une classe representant des Activitees, constituees  d'un nom et d'une duree*/
public class Activity {

	private String activitee;
	private int duree;

	public Activity (String activitee, int duree) {
		this.activitee = activitee;
		this.duree = duree;
	}
	
	public int getDuree() {
		return this.duree;
	}
	
	
	public String toString(){
		return this.activitee;
	}
}
