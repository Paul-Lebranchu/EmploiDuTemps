package EDT;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class RandomScheduler{

	protected HashSet<Activity> activities;
	protected ArrayList<Constraint> constraint;
	protected Random randomGenerator;

	public RandomScheduler(){
		this.activities = new HashSet<Activity>();
		this.constraint = new ArrayList<Constraint>();
		this.randomGenerator = new Random();
	}

	public void addSet(Activity act){
		this.activities.add(act);
	}

	public void addConst(Constraint contr){
		this.constraint.add(contr);
	}

	public HashMap<Activity,Integer> randomEdt(){
		HashMap<Activity,Integer> edtAleatoire = new HashMap<Activity,Integer>();
		for(Activity act: activities){
			edtAleatoire.put(act,randomGenerator.nextInt(23));
		}
		return edtAleatoire;
	}
	
	public int satisfaction (HashMap<Activity,Integer> edt){
		int compteur = 0;
		for(Constraint contr: this.constraint){
			if(contr.isSatisfiedBySchedule(edt)){
				compteur += 1;
			}
		}
		return compteur;
	}
	
	public HashMap<Activity,Integer> bestEdt(int n){
		HashMap<Activity, Integer> edt = new HashMap<Activity,Integer>();
		HashMap<Activity, Integer> meilleurEdt = new HashMap<Activity,Integer>();
		int cpt = 0;
		for (int i = 0; i<n ; i++){
			edt = randomEdt();
			if(satisfaction (edt) > cpt){
				cpt = satisfaction(edt);
				meilleurEdt = edt;
			}
		}
		
		return meilleurEdt;
	} 
}
