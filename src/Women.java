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
		if(this.isDate()){
			bestPer = getPer().indexOf(this.getDateID());
			bestChoice = this.getDateID();
		}
		if(!offerList.isEmpty()){
			for(int i = 0; i < offerList.size(); i++){
				instantChoice = offerList.get(i);
				instantPer = this.getPer().indexOf(instantChoice);
				
				if(bestPer == -1 || bestPer > instantPer){
					bestChoice = instantChoice;
					bestPer = instantPer;
				}
						
			}
		}
		if(bestPer != -1){
			this.setDate(true);
			this.setDateID((int)bestChoice);
		}
		
		this.offerList.clear();
	}
	
	public boolean hasOffer(){ return (!this.offerList.isEmpty());}
	
}
