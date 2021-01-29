package edu.eci.arsw.primefinder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 1- El numero de nucleos que esta usando en mi sistema es 12
		 * 2- El numero de nucleos varia entre 18 y 22 nucleos
		 */
		//PrimeFinderThread pft=new PrimeFinderThread(0, 30000000);
		Scanner scanner = new Scanner(System.in);
		String entrada;
		PrimeFinderThread pft1=new PrimeFinderThread(0,9999999);
		PrimeFinderThread pft2=new PrimeFinderThread(10000000, 19999999);
		PrimeFinderThread pft3=new PrimeFinderThread(20000000, 30000000);
		
		//pft.start();
		pft1.start();
		pft2.start();
		pft3.start();
		try {
			Thread.sleep(5000);
			
			pft1.pausar();
			pft2.pausar();
			pft3.pausar();
			System.out.println("Press Enter key to continue...");
			 do{
			    entrada  = scanner.nextLine();	
			 }
			 while(!entrada.equals("")); 
			pft1.reanudar();
			pft2.reanudar();
			pft3.reanudar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
