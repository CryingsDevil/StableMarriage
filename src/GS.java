import java.util.Random;



public class GS {
	private Men[] men;
	private Women[] women;
	private int size;
	private boolean finished = false;
	
	public GS(){
		Random rand = new Random();
		size = rand.nextInt(100);
		System.out.println("Random size of " + size);
		men = new Men[size];
        women = new Women[size];
        
        for(int i = 0; i < size; i++){
        	men[i] = new Men(i + 1,size);
        	men[i].randomPerList(size);
        }
        
        for(int i = 0; i < size; i++){
        	women[i] = new Women(i + 1, size);
        	women[i].randomPerList(size);
        }
	}
	
	public GS(int size, Men[] men, Women[] women){
		this.size = size;
		this.men = men;
		this.women = women;
	}
	
	public void solve(){
		int per = -1;
		while(!finished){
			for(int i = 0; i < size; i++){
				if(!men[i].isFinished()){
					women[(men[i].getPerIndexof(men[i].getofferIndex()) - 1)].addOffer(i);
					men[i].offerIndexPlus();
				}
				finished = finished & men[i].isFinished();
			}
			
			for(int i = 0; i < size; i++){
				if(women[i].hasOffer()){
					if(women[i].isDate()){
						men[women[i].getDateID()].setDate(false);
						men[women[i].getDateID()].setDateID(-1);
						women[i].chooseBest();
						men[women[i].getDateID()].setDate(true);
						men[women[i].getDateID()].setDateID(i);
					}else{
						women[i].chooseBest();
						men[women[i].getDateID()].setDate(true);
						men[women[i].getDateID()].setDateID(i);
					}
				}
				
				
			}
			
		}
		
		System.out.println("-----------------------------------------------");
		System.out.println("Men's final result: ");
		for(int i = 0; i < size; i++){
			men[i].printPer();
			men[i].printFinal();
		}
		
		System.out.println("Women's final result: ");
		for(int i = 0; i < size; i++){
			women[i].printPer();
			women[i].printFinal();
		}
	}
}
