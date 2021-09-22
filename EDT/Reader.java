
/*creation d'un package commun pour regrouper les feuilles*/
package EDT;
/*appelle d'une nouvelle classe java, utiliser javac -d "build" -cp "y/x.jar" monpackage/*.java*/
import java.lang.Object.*;
import scheduleio.*;
import java.util.*;
import java.io.*;



public class Reader {
	
	private String nom1;
	private String nom2;
	protected HashMap<String ,Activity> read = new HashMap<>();
	protected ArrayList<Constraint> listeConstrict = new ArrayList<>();
	protected ActivityReader readion;
	private ConstraintReader contRead; 

	public Reader (String nom1, String nom2) {
		this.nom1 = nom1;
		this.nom2 = nom2;
		this.read = read;
		this.readion = new ActivityReader(nom1);
		this.contRead = new ConstraintReader(nom2);
	}
	
	
	public HashMap<String, Activity> getActivities() throws FileNotFoundException, IOException{
	// throws est ici pour renvoyer les exceptions produites par le readAll()


		Map<String, ActivityDescription> readTmp = this.readion.readAll();
		
		for (Map.Entry<String, ActivityDescription> entry: readTmp.entrySet()){
			Activity a = new Activity(entry.getValue().getName(), entry.getValue().getDuration());
			this.read.put(entry.getKey(), a);
		}
		return this.read;
	}
	
	
	public PrecedenceConstraint getPrecedenceConstraint(String[] activite) throws IllegalArgumentException {
		
		for(int w = 0; w < 2; w++){
			if(!read.containsKey(activite[w])) {/*ici les accolade ne sont pas necessaire car une seul instruction*/
				throw new IllegalArgumentException("Veuillez choisir quelque chose present dans votre fichier");
			}
		}
		
		Activity first = read.get(activite[0]);
		Activity second = read.get(activite[1]);
		
		return new PrecedenceConstraint(first, second);
	}
	
	
	public PrecedenceConstraintWithGap getPrecedenceConstraintWithGap(String[] gapdeuxactiv) throws IllegalArgumentException{
		
		for(int w = 1; w < 3; w++){
			if(!read.containsKey(gapdeuxactiv[w])) {/*ici les accolade ne sont pas necessaire car une seul instruction*/
				throw new IllegalArgumentException("Veuillez choisir quelque chose present dans votre fichier");
			}
		}
		
		int gap = Integer.parseInt(gapdeuxactiv[0]);
		Activity first 	= read.get(gapdeuxactiv[1]);
		Activity second = read.get(gapdeuxactiv[2]);
		
		return new PrecedenceConstraintWithGap (first, second , gap);
	}
	
	
	public MeetConstraint getMeetConstraint(String [] deuxactiv) throws IllegalArgumentException{
		
		for(int w = 0; w < 2; w++){
			if(!read.containsKey(deuxactiv[w])) {/*ici les accolade ne sont pas necessaire car une seul instruction*/
				throw new IllegalArgumentException("Veuillez choisir quelque chose present dans votre fichier");
			}
		}
		
		Activity first 	= read.get(deuxactiv[0]);
		Activity second = read.get(deuxactiv[1]);
		
		return new MeetConstraint (first, second);
	}
	public MaxSpanConstraint getMaxSpanConstraint(String [] listedure) throws IllegalArgumentException{
		
		ArrayList <Activity> liste = new ArrayList <> ();
		
		int w = 0; 
		int duremax = 0;
		
		if (w == 0){
				duremax = Integer.parseInt(listedure[w]);
		}/*encore une fois pas util mais c'est joli*/
		
		for(w = 1; w < listedure.length; w++){
			
			liste.add(read.get(listedure[w]));
			
			if(!read.containsKey(listedure[w])) {/*ici les accolade ne sont pas necessaire car une seul instruction*/
				throw new  IllegalArgumentException("Veuillez choisir quelque chose present dans votre fichier");
			}
		}
		
		return new MaxSpanConstraint (liste, duremax);
	}
	
	
	public ArrayList<Constraint> readConstraints() throws FileNotFoundException, IOException{
	// throws est ici pour renvoyer les exceptions produites par le readAll()

		// creation liste de contrainte description
		List<ConstraintDescription> listeCont =  this.contRead.readAll();
		
		/*parcours des objts de type ConstraintDescription de la listCont: pour chaque objet de ce type,on regarde le KeyWord
		(type de contrainte) et on applique la methode correspondant a ce type de contrainte */
		for(ConstraintDescription constr: listeCont){


			Constraint c = null;
			
			if (constr.getKeyword().equals("PRECEDENCE")){

				try{

					c = getPrecedenceConstraint(constr.getArguments());

				}catch( IllegalArgumentException e) {
			 
				System.err.print("argument invalide" + e.getMessage());
			 
				}
				
			}
			
			if(constr.getKeyword().equals("PRECEDENCE_GAP")){

				try{

					c = getPrecedenceConstraintWithGap(constr.getArguments());
				
				}catch( IllegalArgumentException e) {
			 
					System.err.print("argument invalide" + e.getMessage());
			 
				}

			}
			
			if(constr.getKeyword().equals("MEET")){

				try{

					c = getMeetConstraint(constr.getArguments());

				}catch( IllegalArgumentException e) {
			 
					System.err.print("argument invalide" + e.getMessage());
			 
				}

			}
			
			if(constr.getKeyword().equals("MAX_SPAN")){
				try{

					c = getMaxSpanConstraint(constr.getArguments());
				
				}catch( IllegalArgumentException e) {
			 
					System.err.print("argument invalide" + e.getMessage());
			 
				}
			}
			
			if(c == null) {
				
				System.out.println("erreur de redaction dans le fichier contrainte.txt");
				continue ;
				
			}	
			
			this.listeConstrict.add(c) ;
		}	
		

		
		return this.listeConstrict ;
	}

}

