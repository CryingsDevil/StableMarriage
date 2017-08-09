import java.util.ArrayList;


public class Hospital extends People{
	private int capability;
	private ArrayList<Integer> offerList = new ArrayList();
	private ArrayList<Integer> offerAccept = new ArrayList();
	
	Hospital(){}
	
	Hospital(int id, int size, int capa){
		this.setID(id);
		this.setSize(size);
		this.setCapa(capa);
	}
	
	public void addOffer(int offer){
		offerList.add(offer);
	}
	
	public int getCapa(){return this.capability;}
	
	public ArrayList<Integer> getOfferAccept(){return this.offerAccept;}
	
	public ArrayList<Integer> getOfferList(){return this.offerList;}
	
	public void setCapa(int capability){this.capability = capability;}
	
	public void chooseBest(){
		int choices = 0;
		if(!offerAccept.isEmpty()){
			for(int i = 0; i < offerAccept.size(); i++){
				offerList.add(offerAccept.get(i));
			}
			offerAccept.clear();
		}
		ArrayList<Integer> instantPer = new ArrayList<Integer>(this.getPer());
		for(int i = 0; i < this.getSize(); i++){
			if(!offerList.contains(instantPer.get(i))){
				instantPer.remove(i);
			}
		}
		
		if(offerList.size() != instantPer.size())System.out.println("Something wrong here!");
		
		for(int i = capability; i < instantPer.size(); i++)instantPer.remove(i);
			
		offerAccept.addAll(instantPer);
		
		instantPer.clear();
		offerList.clear();
	}
	
	public void printHospital(){
		int pSize = this.getPer().size();
		System.out.println("ID: " + this.getID() +" Capability: " 
						+  this.capability +" Perference list: ");
		for(int i = 0; i < pSize; i++){
			System.out.print(this.getPer().get(i)+ " ");
		}
		System.out.println("");
	}
	
	
	
	

}
