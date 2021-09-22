
/*creation d'un package commun pour regrouper les feuilles*/
package EDT;

/* creation d'une classe creant un laps de temps entre deux cours ex:30minutes*/
public class PrecedenceConstraintWithGap extends PrecedenceConstraint{

	private int gap;
	
	public PrecedenceConstraintWithGap (Activity first, Activity second, int gap){
		super( first, second);
		this.gap = gap;
	}
	
	@Override
    public boolean isSatisfied(int date1, int date2) {
        if ((this.first.getDuree() + date1*60) <= date2*60 - this.gap) {
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		return "cette Classe est une contraite de precedance prenant deux activitees et leurs temps " + this.first + " et " + this.second + " ainsi qu'un temps de " + this.gap;
	}
	
	
}
