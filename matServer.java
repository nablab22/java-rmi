//Nom : LARBAOUI
//Prénom: Nabila
//Spécialité:  M1_RSSI  Groupe:1
package TP4_22_23;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class matServer {
	
    public static void main(String argv[]){
		    	
			try
			    {
				matImpl calculmatImpl=new matImpl();
				LocateRegistry.createRegistry(4242);
			    Naming.rebind("rmi://localhost:4242/serverImpl", calculmatImpl);
				System.out.println("Serveur en attente" );
				
			    }
			catch (Exception e)
			    {
				System.out.println("Erreur Serveur: "+e);
			    }
		    }
	}