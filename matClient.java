//Nom : LARBAOUI
//Prénom: Nabila
//Spécialité:  M1_RSSI  Groupe:1
package TP4_22_23;
import java.rmi.Naming;
import java.util.Scanner;

	public class matClient {
		
	    private static void AfficherMat(int[][] C) {
	        for (int i = 0; i < C.length; i++) {
	            for (int j = 0; j < C[i].length; j++) {
	                System.out.print(C[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	public static void main(String[] args) {
	    	int A[][] = {{1,2,0},{4,3,-1}};
		    int B[][] = {{5,1},{2,3},{3,4}};
		    
	        int[][] A1 = { {1, 5, 3}, {2, 4, 1} , {9, 6, 0}};
	        int[][] B1 = { {2, 7, 3}, {0, 9, 3} , {8, 2, 7}};

	    	
	    	    try {
	    	    	
	    	    calc_mat_Interface stub = (calc_mat_Interface) Naming.lookup("rmi://localhost:4242/serverImpl");

	            Scanner scan= new Scanner(System.in);
	            System.out.print("Username: ");
	            String identif = scan.nextLine();
	            System.out.print("Password: ");
	            String mot_de_passe = scan.nextLine();

	            String reponse = stub.login(identif, mot_de_passe);
	            System.out.println(reponse);

	            if (reponse.startsWith("Bienvenue")) {
	            System.out.println("Choisir l'operation à faire: ");
	     	    System.out.println(" 1. Addition\n 2. Soustraction\n 3. Multiplication\n 4. Transposée de matrice");
	     	    int choix =scan.nextInt();
	   	        scan.nextLine();
	   	        
	   	        switch(choix){
	   	        case 1: 
	   	        	int[][] resultadd = stub.add(A1,B1);
	   	        	System.out.println("---Addition---");
	   	        	AfficherMat(resultadd);
	   	        	break;
	   	        case 2:
	   	        	int[][] resultsub = stub.sub(A1,B1);
	   	        	System.out.println("---Soustraction---");
	   	        	AfficherMat(resultsub);
	   	        	break;
	   	        case 3:
	   	        	int[][] resultmultip = stub.multip(A,B);
	   	        	System.out.println("---Multiplication---");
	   	        	AfficherMat(resultmultip);

	   	        	break;
	   	        case 4:
	   	        	int[][] resultransp = stub.transp(A);
	   	    		System.out.println("---Transposée de matrice---");
	   	        	AfficherMat(resultransp);
	   	        	break;
	   	        default:
	   	         System.out.println("Choix incorrect");
	   	         break;
	   	         }
	   	        }
	            }
	    	    catch (Exception e) {
	        	System.out.println("Erreur Client"+e);}
	        }
}
