import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.println("Please input the size of reference");
       
        int size = in.nextInt();
//        System.out.println("Please input the number of men");
//        int menN = in.nextInt();
        System.out.println("For the basic GS-algorithm, the number of men and women are equal to size of reference.");
        int menN = size;
        System.out.println("For the basic GS-algorithm, the number of men and women are equal");
        int womenN = menN;
//        System.out.println("Please input the number of women");
//        int womenN = in.nextInt();
        
        
        
        Men[] men = new Men[menN];
        Women[] women = new Women[womenN];
        
        for(int i = 0; i < menN; i++){
        	men[i] = new Men(i + 1,womenN);
        	men[i].randomPerList(size);
        }
        
        for(int i = 0; i < womenN; i++){
        	women[i] = new Women(i + 1, menN);
        	women[i].randomPerList(size);
        }
        
        System.out.println("Check the data of men");
        for(int i = 0; i < menN; i++){
        	men[i].printPer();
        }
        
        System.out.println("Check the data of women");
        for(int i = 0; i < womenN; i++){
        	women[i].printPer();
        }
        
        GS gsa = new GS(size, men, women);
        gsa.solve();
        
    }
}
