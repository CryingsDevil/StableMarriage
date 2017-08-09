import java.util.Random;


public class HospitalResident {
	private Men[] men;
	private Hospital[] hospitals;
	private int size;
	private boolean finished = false;
	private int randomMin = 0;
	private int randomMax = 0;
	private int randomRange = 0;
	
	public HospitalResident(){
		Random rand = new Random();
		size = rand.nextInt(100);
		do{
			randomMin = rand.nextInt(size);
		}while(randomMin > (size / 4));
		do{
			randomMax = rand.nextInt(size / 2) + randomMin;
		}while(randomMax > size);
		System.out.println("Random size of " + size);
		men = new Men[size];
        hospitals = new Hospital[size];
        
        for(int i = 0; i < size; i++){
        	men[i] = new Men(i + 1,size);
        	men[i].randomPerList(size);
        }
        
        for(int i = 0; i < size; i++){
        	do{
        		randomRange = rand.nextInt(size / 4) + (randomMax - randomMin);
        	}while(randomRange > size);
        	hospitals[i] = new Hospital(i + 1, size, rand.nextInt(size));
        	hospitals[i].randomPerList(size);
        }
	}
	
	public HospitalResident(int size, Men[] men, Hospital[] hospitals){
		this.size = size;
		this.men = men;
		this.hospitals = hospitals;
	}
}
