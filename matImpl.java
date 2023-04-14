package TP4_22_23;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

	public class matImpl extends UnicastRemoteObject implements calc_mat_Interface {

		    
		    private ArrayList<Utilisateur> Clients = new ArrayList<>();

		    public matImpl() throws RemoteException {
		        super();
		        Clients.add(new Utilisateur("Amina", "isi"));
		        Clients.add(new Utilisateur("Bachir", "rssi"));
		        Clients.add(new Utilisateur("Yacine", "wic"));
		    }
		   
		        
		    public String login(String id, String pass) throws RemoteException {
		    	
		        for (int i = 0; i < Clients.size(); i++) {
		            if (id.equals(Clients.get(i).id)) {
		                if (pass.equals(Clients.get(i).pass)) {
		                	 System.out.print("Utilisateur Identifié ");
		                     return "Bienvenue";
		                     }
		                else {
		                    return "invalid password";}
		                }
		            }
		        Clients.add(new Utilisateur(id, pass));
		        System.out.print("Utilisateur enregistré ");
		        return "Bienvenue";
		    }
			public int[][] add(int[][] A, int[][] B)
		    {   

			       int l = A.length;
			       int c = A[0].length;
			       int [][] C = new int[l][c];
				   for (int i=0; i<l;i++) {
					   for (int j=0; j<c;j++) {
					         C[i][j] = A[i][j] + B[i][j];
					       }
				   }
				   return C;
			  }
		    public int[][] sub(int[][] A, int[][] B) throws RemoteException {
		    	
		    	int l = A.length;
			       int c = A[0].length;
			       int[][] C = new int[l][c];
				   for (int i=0; i<l;i++) {
					   for (int j=0; j<c;j++) {
					         C[i][j] = A[i][j] - B[i][j];
					         
					   }
				   }
			         return C; 

	 	    }
		    public  int[][] multip(int[][] A, int[][] B)throws RemoteException 
		    {   
		       int la = A.length;
		       int lb = B.length;
		       int cb = B[0].length;
		       int [][] C = new int[la][cb];
			   for (int i=0; i<la;i++) {
				   for (int j=0; j<cb;j++) {
				        C[i][j] = 0;
				         for (int k=0;k<lb;k++) {
		    	           C[i][j] += A[i][k] * B[k][j];
				         }
				   }
			   }
	 		   return C;
		    }
			public int[][] transp(int[][] A)throws RemoteException{
				
				   int la = A.length;
			       int ca = A[0].length;
			       int [][] C = new int[ca][la];
				   for (int i=0; i<ca;i++) {
					   for (int j=0; j<la;j++) {
			    	           C[i][j] = A[j][i];
			    	           }
				   }
				   return C;
				   }
}
		 		   
		 	  
