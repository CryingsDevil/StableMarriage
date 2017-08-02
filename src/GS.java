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
				if(!men[i].isDate() && !men[i].isFinished()){
					per = men[i].getPerIndexof(men[i].getofferIndex());
					men[i].offerIndexPlus();
					
					if(per != -1)women[per].addOffer(i);
				}
				if(!finished){
					if(men[i].isFinished())this.finished = true;
				}else{
					if(!men[i].isFinished())this.finished = false;
				}
			}
			
		}
	}
}
