package EDT;


/*importer une classe java */
import java.util.*;

public class InteractiveScheduling {
	public static void main (String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nombre d'activites pratiquees: ");
		int nbactprat = scanner.nextInt();
		
		HashMap<Activity, Integer> edt = new HashMap<Activity, Integer> ();
		Verifier verifieur = new Verifier();
		
		/*recuperation des activites*/
		for(int i = 0; i< nbactprat; i++){
			int j = i + 1;
			String nom =  "Nom de l'activite " + j + " : ";
			String duree =  "Duree de l'activite "+ j + " : ";
			String deb =  "Date de debut de l'activite "+ j + " : ";
			
			System.out.print(nom);
			String actname = scanner.nextLine();
			System.out.print(duree);
			Integer actime = scanner.nextInt();
			System.out.print(deb);
			Integer debut = scanner.nextInt();
			
			/*assemblage des activites*/
			Activity act = new Activity (actname, actime);
			edt.put(act, debut);
		}
		scanner.close();
		
		System.out.println("L'emploi du temps satisfait-il toutes les contraintes ? ");
		if (verifieur.verify(edt)) {
			System.out.println("Oui");
		} else {
			System.out.println("Non");
		}
	}
}
