import java.util.Collections;  
import java.util.List;
import java.util.ArrayList;

public class People {
//	private class preference{  
//        private int per;  
//        private preference next = null;  
//          
//        preference(int obj){  
//            this.per = obj;  
//        }  
//    }  
//	private preference start;
//	private preference instat;
	
	private int id;
	private int size;
	private int dateID = -1;
	private boolean date = false;
	private ArrayList<Integer> list = new ArrayList();
	
	public void randomPerList(int size){
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		Collections.shuffle(list);
		
	}
	
	People(){}
	
	People(int id, int size){
		this.id = id;
		this.size = size;
	}
	
	public int getID(){return this.id;}
	
	public int getSize(){return this.size;}
	
	public boolean isDate(){return this.date;}
	
	public int getDateID(){return this.dateID;}
	
	public ArrayList<Integer> getPer(){return this.list;}
	
	public int getPerIndexof(int index){return this.list.get(index);}
	
	public void setID(int id){this.id = id;}
	
	public void setSize(int size){this.size = size;}
	
	public void setDate(boolean date){this.date = date;}
	
	public void setDateID(int dateID){this.dateID = dateID;}
	
	public void printPer(){
		int pSize = list.size();
		System.out.println("ID: " + this.id + " Perference list: ");
		for(int i = 0; i < pSize; i++){
			System.out.print(list.get(i)+ " ");
		}
		System.out.println("");
	}
	
	public void printFinal(){System.out.println("Final choice: " + this.dateID);}
}
