
/*creation d'un package commun pour regrouper les feuilles*/
package EDT;

/*importer une classe java */
import java.util.*;

/*creation d'une classe ou on a une liste d'activitee et, une duree maximum qui ne doit 
 * pas etre depasser entre le debut de la 1ere activitee et la fin de la derniere*/
public class MaxSpanConstraint implements Constraint {
	
	private ArrayList <Activity> liste;
	private int duremax;
	
	public MaxSpanConstraint (ArrayList <Activity> liste, int duremax) {
		this.liste = liste;
		this.duremax = duremax;
	}

	public boolean dureJournee(){
		
		int compteur = 0;
		
		for(int i = 0; i< this.liste.size(); i++){
			compteur += this.liste.get(i).getDuree();
		}
		if (this.duremax >= compteur){
			return true;
		}return false;
	}
	
	public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> edt) {
		if ((edt.containsKey(this.liste.get(0))) && (edt.containsKey(this.liste.get(1)))){
			return this.dureJournee();
		}return false;
	}
}
