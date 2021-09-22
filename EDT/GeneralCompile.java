package EDT;

import java.lang.Object.*;
import scheduleio.*;
import java.util.*;
import java.io.*;


public class GeneralCompile{
	
	public static void main (String[] args){
		
		
		//args[0] =  activities;  args[1] = constraint//
		
		String activite = args[0];
		String constraint = args[1];
		
		Reader lecteur = new Reader(activite, constraint);	
		
		// creation du HashMap<String,Actvity> contenant les lignes du fichier activites.txt et rattrappant les erreurs, si
		//il y en a.
		try{
			lecteur.getActivities();

		}catch(FileNotFoundException e){

			System.err.print(e.getMessage());

		}catch(IOException e){

			System.err.print(e.getMessage());
		
		}
		
		//création de la liste des contraintes qui se base sur le fichier contraintes.txt
		try{
			lecteur.readConstraints();

		}catch(FileNotFoundException e){

			System.err.print(e.getMessage());

		}catch(IOException e){

			System.err.print(e.getMessage());
		
		}
		
		//creation d'un RandomScheduler et initialisation 
		RandomScheduler edt = new RandomScheduler();

		//initialisation des activite pour l'emploi du temps

		Collection<Activity> tmp = lecteur.read.values();

		for(Activity act: tmp){

			edt.addSet(act);
		}
		//initialisation des contraintes pour l'emploi du temps
		edt.constraint = lecteur.listeConstrict;
		
		//cree un grand nombre d'emploi du temps et selectionne le meilleur parmis ces emplois du temps.
		System.out.println(edt.bestEdt(10000));

	}


}
