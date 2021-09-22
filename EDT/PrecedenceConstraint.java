package EDT;

/*creation d'une classe prenant deux activitees en attributs*/
public class PrecedenceConstraint extends BinaryConstraint {

	public PrecedenceConstraint (Activity first, Activity second) {
		super(first, second);
	}
	
	@Override
	public String toString(){
		return ""+this.first + " " +this.second ;
	}
	//"cette Classe est une contraite de precedance prenant deux activitees " + this.first + " et " + this.second
}
