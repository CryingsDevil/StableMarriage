import java.util.ArrayList;
import java.util.List;

public class Women extends People{
	private List offerList = new ArrayList();
	Women(){}
	
	Women(int id, int size){
		setID(id);
		setSize(size);
		
	}
	
	public void addOffer(int offer){
		offerList.add(offer);
	}
	
	public void chooseBest(){
		Object bestChoice = -1;
		int bestPer = -1;
		Object instantChoice = -1;
		int instantPer = -1;
		for(int i = 0; i < offerList.size(); i++){
			instantChoice = offerList.get(i);
			instantPer = getPer().indexOf(instantChoice);
			
			if(bestPer == -1 || bestPer > instantPer){
				bestChoice = instantChoice;
				bestPer = instantPer;
			}
					
		}
		
		if(bestPer != -1){
			setDate(true);
			setDateID((int)bestChoice);
		}
	}
}
