
/*creation d'un package commun pour regrouper les feuilles*/
package EDT;

/*importer une classe java */
import java.util.HashMap;

/*regrouper le commun entre precedenceConstraint et meetConstraint*/
public abstract class BinaryConstraint implements Constraint {
	
	protected Activity first;
	protected Activity second;
	
	public BinaryConstraint (Activity first, Activity second){
		this.first = first;
		this.second = second;
	}
	
	/*methode verifiant si les horaire ne se chevauche pas*/
	
	public boolean isSatisfied(int date1, int date2) {
		if ((this.first.getDuree() + date1*60) <= date2*60) {
			return true;
		} /*else' pas util*/
		return false;
	}
	
	public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> edt) {
		if ((edt.containsKey(this.first)) && (edt.containsKey(this.second))){
			return this.isSatisfied(edt.get(this.first), edt.get(this.second));
		} /*pas besoin du else ici*/
		return false;
	}
	
	public Activity getFirst(){
        return this.first;
    }

    public Activity getSecond(){
        return this.second;
    }

    public String toString(){
		return ""+this.first + " " +this.second ;
	}
}
