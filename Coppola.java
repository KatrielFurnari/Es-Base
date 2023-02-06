public class Coppola {
	public static java.util.Scanner console = new java.util.Scanner(System.in);
	public static java.util.Random dado = new java.util.Random();

		public static final int NUMERO_CASE = 4;
		public static final int GRIFFINDOR = 0;
		public static final int SLYTHERIN = 1;
		public static final int RAVENCLAW = 2;
		public static final int HUFFLEPUFF = 3;
		public static final int RANDOM_ADD = 3;
		
	public static void main(String[] args){
	
	int numStud = askNumber("Inserisci il numero degli studenti:  ");
		int capienza = numStud / NUMERO_CASE;
		int rimanenti = numStud % NUMERO_CASE;
		
		String [][] houses = new String [NUMERO_CASE][capienza + (NUMERO_CASE/rimanenti) ];
		for (int i = 1; i <= capienza * NUMERO_CASE; i++ ){
		   	String nome = ask("inserisci il nome degli studenti: ");
		  	int hash = hashName(nome);  
		   	int ranNum = dado.nextInt(4);
		  	if (ranNum == 3){
		    		 hash += RANDOM_ADD;
		        }
			int pos = hash%NUMERO_CASE;
			if(!isHouseFull(pos, houses)) {
				addToHouse(pos,houses,nome);			
			}
		} printHouses(houses);
		
	}
	 
	
	public static String ask(String prompt){
		System.out.print(prompt + ": ");
		String answer = console.nextLine();  
		return answer;
	}  
	
	public static int askNumber(String prompt){
	 		System.out.print(prompt + ": ");
			String answer = console.nextLine(); 
			int n = Integer.parseInt(answer);
			return n;
	}
	
	public static int hashName(String name){
		String noSpace = name.replace(" ","").toLowerCase();
		int hash = 0;
		for(int i=0;i<noSpace.length();i++){                                           
			hash= hash + noSpace.codePointAt(i) * (int)Math.pow(7, i);
		}
		return hash;
	}
		
	public static boolean isHouseFull(int pos, String[][] houses){
		int capienza = houses[0].length;
		if (houses[pos][capienza-1] != null){
			return true;                                                                 
		}
			return false;                                   
	}
	
	public static void addToHouse(int position, String[][] houses, String nome){
		int temp = 0;
		for (int i = 0; i < houses.length; i++ ){
			if (houses[position][i] != null) {
				temp++;
			}
			 
		}
			houses[position][temp+1] = nome;				
	}
	
	public static void printHouses(String[][] houses) {
        for (int i = 0; i < houses.length; i++) {
            System.out.println("Casa " + i + ": ");
            for (int j = 0; j < houses[i].length; j++) {
                if (houses[i][j] != null)
                    System.out.println(houses[i][j]);
            }
        }
	}
}
