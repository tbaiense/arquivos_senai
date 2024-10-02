package org.thiago;

public class TesteMesmoPacote {
	
	static private class AninhadaStatica {
		public static int intStatica = 2;
		
		public static void metStatica() {
			System.out.print("Sou uma aninhada stática!");
		}
	}
	
	AninhadaStatica a = new AninhadaStatica();
	
	public static void main(String[] args) {
		
	
	}
}
