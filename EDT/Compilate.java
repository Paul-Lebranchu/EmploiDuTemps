
/*creation d'un package commun pour regrouper les feuilles*/
package EDT;

import java.util.ArrayList;
/*importer une classe java */
/*import java.util.HashMap;*/

/*test des classes code precedemment*/
public class Compilate {
	public static void main (String [] args) {
		
		Activity cafe = new Activity ("Boire un cafe", 3);
        Activity cours = new Activity ("Cours de POO", 75);
        Activity campus = new Activity ("Aller au campus", 75);
        Activity reveil = new Activity ("Se lever", 5);
        Activity douche = new Activity ("Se laver", 15);
        Activity cours2 = new Activity ("aller au deuxieme cours", 75);
        Activity manger1 = new Activity ("repas1", 60);
       
        MeetConstraint c1 = new MeetConstraint (reveil, douche);
        MeetConstraint c6 = new MeetConstraint (douche, cafe);
        MeetConstraint c2 = new MeetConstraint (cafe, campus);
        MeetConstraint c3 = new MeetConstraint (campus, cours);
        MeetConstraint c4 = new MeetConstraint (cours, cours2);
        MeetConstraint c5 = new MeetConstraint (cours2, manger1);
        
        ArrayList<Activity> ensemble = new ArrayList<> ();
		ensemble.add(cafe);
		ensemble.add(cours);
		ensemble.add(campus);
		ensemble.add(reveil);
		ensemble.add(douche);
		ensemble.add(cours2);
		ensemble.add(manger1);

		
		MaxSpanConstraint contrainteEnsemble = new MaxSpanConstraint(ensemble, 1440);
		
        RandomScheduler hazard = new RandomScheduler();
    
        hazard.addSet(reveil);
        hazard.addSet(douche);
        hazard.addSet(cafe);
        hazard.addSet(campus);
        hazard.addSet(cours);
        hazard.addSet(cours2);
        hazard.addSet(manger1);

       
        hazard.addConst(c1);
        hazard.addConst(c2);
        hazard.addConst(c3);
        hazard.addConst(c4);
        hazard.addConst(c5);
        hazard.addConst(c6);
        hazard.addConst(contrainteEnsemble);
       
        System.out.println(hazard.bestEdt(1000000000));

	}
}
