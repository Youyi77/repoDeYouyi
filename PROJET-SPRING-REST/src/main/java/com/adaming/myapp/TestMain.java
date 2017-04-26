package com.adaming.myapp;

public class TestMain {

	public static void main(String[] args) {
		
		
		int [] data = get();
		long x = System.nanoTime();
		for(Integer i : data){
			System.out.println(i);
		}
		long y = System.nanoTime();
		long dif = y - x;
		System.out.println("forE"+dif);

	}
	
	public static int [] get(){
		int [] tab = new int[100000];
		for(int x = 0;x<tab.length;x++){
			tab[x] = x;
		}
		return tab;
	}

}
