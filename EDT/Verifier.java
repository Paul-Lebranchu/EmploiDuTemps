
/*creation d'un package commun pour regrouper les feuilles*/
package EDT;

/*importer une classe java */
import java.util.*;

public class Verifier {
	
	private ArrayList <Constraint> liste;
	
	public Verifier () {
		this.liste = new ArrayList<>();
	}

	public void add(Constraint c){
		this.liste.add(c);
	}

	public boolean verify(HashMap<Activity, Integer> edt) {
		/*parcourir la liste contraintes good pour emplois du temps appeler 
		issatified si tout vrai donc vrai*/
		
		ArrayList<Boolean> vraux = new ArrayList<Boolean>();
		Constraint valeur;
		
		for(int i = 0; i< this.liste.size(); i++){
			valeur = this.liste.get(i);
			if (!valeur.isSatisfiedBySchedule(edt)){
				System.out.println(valeur);
			}
			vraux.add(valeur.isSatisfiedBySchedule(edt));
		}
		for(int i = 0; i< vraux.size(); i++){
			if (vraux.get(i)==false){
				System.out.println(vraux);
				return false;
			}
		}return true;
	}
}
