
public class Men extends People{
	private int offerIndex = 0;

	Men(){}
	
	Men(int id, int size){
		setID(id);
		setSize(size);
	}
	
	public int getofferIndex(){return this.offerIndex;}
	
	public void offerIndexPlus(){this.offerIndex++;}
	
	public boolean isOfferEnd(){
		if(this.offerIndex == this.getSize()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFinished(){return (this.isDate() || isOfferEnd());}
}
