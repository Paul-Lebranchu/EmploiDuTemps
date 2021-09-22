
/*creation d'un package commun pour regrouper les feuilles*/
package EDT;

/*classe qui fait que les deux activites se suivent*/
public class MeetConstraint extends BinaryConstraint{
	
	public MeetConstraint (Activity first, Activity second){
		super(first, second);/*rappel de ce qui a etais cree dans la classe mere*/
	}
	
	/*methode recuperee et transformee verifiant une parfaite suivi des activites*/
	@Override
	public boolean isSatisfied(int date1, int date2) {
		if ((this.first.getDuree() + date1*60) == date2*60) {
			return true;
		} /*else' pas util*/
		return false;
	}

	public String toString(){
		return ""+this.first + " " +this.second ;
	}
}