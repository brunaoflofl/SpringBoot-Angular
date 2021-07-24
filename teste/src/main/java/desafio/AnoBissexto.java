package desafio;

public class AnoBissexto {

	private static final String Boolean = null;

	public static void main(String[] args) {
		/*
		 * Um determinado ano é bissexto se:



    O ano for divisível por 4, mas não divisível por 100, exceto se ele for também divisível por 400.



Exemplos:*/ 
		Integer ano;
		
		Boolean IsAnoBissexto() {
			if((ano/4 = 0 && ano/100 != 0) && (ano/400 = 0)) {
				return true;
				} else {
					return false;
			}
			
		}

	}

}
