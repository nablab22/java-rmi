package TP4_22_23;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface calc_mat_Interface extends Remote {
	
	public int[][] add(int[][] A, int[][] B)throws RemoteException;
	public int[][] sub(int[][] A, int[][] B)throws RemoteException;
	public int[][] multip(int[][] A, int[][] B)throws RemoteException;
	public int[][] transp(int[][] A)throws RemoteException;
	public String login(String identif, String mot_de_passe) throws RemoteException;
}

