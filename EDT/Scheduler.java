package EDT;

import java.util.List;
import java.util.HashMap;

public class Scheduler{
	
	/*creation d'un HashMap (equivalement du dictionnaire python) contenant les activitees (comme etant des clees)
	 et les contraintes (comme etant les valeurs)*/
	
	public HashMap<Activity,Integer> initNbPreds(List<PrecedenceConstraint> constraints){
		HashMap<Activity, Integer> activitePrec = new HashMap<Activity, Integer>();
		for (PrecedenceConstraint c: constraints) {	
			
	/*met toutes les activitees dans le HashMap et initialise le nombre d'activite precedente a 0
	 les deux premiers if s'occupent de la premiere contrainte (activite 1 et activite 2) 
	 puis le else permet 'ajouter la suite des contraintes (on n'utilise que getsecond car getSecond d'une contrainte
	 = getFirst de la contrainte suivante.*/
			
			if (! activitePrec.containsKey(c.getFirst())){
				activitePrec.put(c.getFirst(),0);
			}
			if (! activitePrec.containsKey(c.getSecond())){
				activitePrec.put(c.getSecond(),1);
			}
			else{
				activitePrec.put(c.getSecond(),activitePrec.get(c.getSecond())+1);
			}
		}
		return activitePrec;
	}
	
	/*scheduleActivity est une methode qui permet d'ajouter une nouvelle activite sur un plan partiel*/
	
	public void scheduleActivity(Activity act , int heure , List<PrecedenceConstraint> constraints, HashMap<Activity,Integer>  planPartiel , HashMap<Activity,Integer> nbprecedesseur ){
		planPartiel.put(act,heure);
		nbprecedesseur.remove(act);
		for(PrecedenceConstraint c: constraints){
			if(c.getFirst() == act){
				nbprecedesseur.put(c.getSecond(),nbprecedesseur.get(c.getSecond())-1);
			}
		}
	}
	
	/*computeSchedule est une methode qui permet de creer un plan COHERENT, c'est a dire qui respecte les contraintes*/
	
	public HashMap<Activity,Integer> computeSchedule(List<PrecedenceConstraint> constraints){
		
	/*On creer le HashMap qu'on va retourner, a savoir l'emploi du temps*/	
		
		HashMap<Activity,Integer> edt =new HashMap<Activity,Integer>();
		
	/*On creer le HashMap qui contient les differentes contraintes*/
		
		HashMap<Activity,Integer> precede = initNbPreds(constraints);
		int heure = 0;
		while(! precede.isEmpty()){
			Activity a = null;
			for (Activity edtpart: precede.keySet() ){
				
	//retourne liste avec toute les activitees

				if(precede.get(edtpart) == 0){
					a = edtpart;
					break;
				}
			}

	/*si y a pas d'activite avec 0 predecesseur, alors il manque un morceau de l'emploi du temps,
	on retourne donc null*/
			if(a == null){
				System.out.println("Il manque des elementspour creer un emploi du temps coherent");
				return null;
			}
			scheduleActivity(a,heure,constraints,edt,precede);
			heure += a.getDuree();

		}
		return edt;
	}

}
	
