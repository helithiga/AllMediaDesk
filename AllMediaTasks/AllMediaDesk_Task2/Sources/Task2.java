import java.util.Scanner;

public class Task2 {
//	public static void main(String[] args) {
//		Scanner myObj = new Scanner(System.in);
//		System.out.println("Enter number:");
//		int inputNum = myObj.nextInt();
//		System.out.println(getHelithi(inputNum, 0, 0, 0));
//	}
	
	public static int getHelithi(int number, int indice, int lastChiffre, int nbTry) {
	
		int len = String.valueOf(number).length();
    
		if(indice == len){
			if(nbTry <= number){
				return nbTry;
			}
        return 0;
		}else{
			int chif = 9;
			while (chif >= lastChiffre){
				int newTry = nbTry * 10 + chif;
				int res = getHelithi(number, indice+1, chif, newTry);
				if(res>0){
					return res;
				}
            chif--;
			}
        
		}
		return 0;
    
}
}

