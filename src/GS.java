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
		int finish = 0;
		int per = -1;
		while(!finished){
			for(int i = 0; i < size; i++){
				if(!men[i].isFinished()){
					women[(men[i].getPerIndexof(men[i].getofferIndex()))].addOffer(i);
					men[i].offerIndexPlus();
				}else{
					finish++;
				}
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
			if(finish == size - 1)finished = true;
			finish = 0;
			//System.out.println("111");
		}
		
		solveContinue();
		
		System.out.println("-----------------------------------------------");
		System.out.println("Men's final result: ");
		for(int i = 0; i < size; i++){
			men[i].printPer();
			men[i].printFinal();
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Women's final result: ");
		for(int i = 0; i < size; i++){
			women[i].printPer();
			women[i].printFinal();
		}
	}
	
	public void solveContinue(){
		int failedM = 0;
		int failedMN = 0;
		int failedW = 0;
		int failedWN = 0;
		for(int i = 0; i < size; i++){
			if(men[i].getDateID() == -1){
				failedM++;
				failedMN = i;
			}
		}
		if(failedM == 1){
			for(int i = 0; i < size; i++){
				if(women[i].getDateID() == -1){
					failedW++;
					failedWN = i;
				}
			}
			if(failedM == failedW){
				men[failedMN].setDate(true);
				men[failedMN].setDateID(failedWN);
				women[failedWN].setDate(true);
				women[failedWN].setDateID(failedMN);
			}
		}
	}
}
