import java.util.ArrayList;
import java.util.List;

public class Women extends People{
	private ArrayList<Integer> offerList = new ArrayList();
	Women(){}
	
	Women(int id, int size){
		this.setID(id);
		this.setSize(size);
		
	}
	
	public void addOffer(int offer){
		offerList.add(offer);
	}
	
	public void chooseBest(){
		int bestChoice = -1;
		int bestPer = -1;
		int instantChoice = -1;
		int instantPer = -1;
		
		if(this.isDate()){
			bestChoice = this.getDateID();
			bestPer = this.getPer().indexOf(bestChoice);
			//System.out.println("Dated: bestChoice is " + bestChoice + " bestPer is " + bestPer);
		}
		
		if(!offerList.isEmpty()){
//			System.out.print("OfferList is ");
//			for(int i = 0; i < offerList.size(); i++){
//				System.out.print(offerList.get(i) + " ");
//			}
//			System.out.println();
			for(int i = 0; i < offerList.size(); i++){
				instantChoice = offerList.get(i);
				instantPer = this.getPer().indexOf(instantChoice);
				
				if(bestPer == -1 || bestPer > instantPer){
					bestChoice = instantChoice;
					bestPer = instantPer;
				}
						
			}
		}
		if(bestPer != -1 && bestChoice != -1){
			//System.out.println("Resgin to bestChoice " + bestChoice + " bestPer is " + bestPer);
			this.setDate(true);
			this.setDateID(bestChoice);
		}
		
		this.offerList.clear();
	}
	
	public boolean hasOffer(){ return (!this.offerList.isEmpty());}
	
}
