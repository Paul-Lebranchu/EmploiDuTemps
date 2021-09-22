package EDT;

import java.util.HashMap;

/*Ici, on instencie l'interface Constraint, qui est reutilisee dans les differentes classes comportant Constraint.*/
public interface Constraint{
	public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> edt);

}
