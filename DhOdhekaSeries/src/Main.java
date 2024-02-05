import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		List<String> inputList = new ArrayList<String>();
		List<String> inputValidi = Arrays.asList("do", "do#", "reb", "re", "re#", "mib", "mi", "fa", "fa#", "solb", "sol", "sol#", "lab", "la", "la#", "sib", "si");
		
		System.out.println("Inserisci 12 note, una per volta. Le note devono appartenere alla seguente lista:" + "\n");
		System.out.println(inputValidi + "\n");
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i=1; i <= 12; ++i) {
			System.out.println("Inserisci la nota numero " + i);
			String tmp = scanner.nextLine();
			if (!inputValidi.contains(tmp)) {
				System.out.println("Nota non valida, inseriscila di nuovo!" + "\n");
				--i;
			} else {
				inputList.add(tmp);
			}
		}
		System.out.println("\n");
		
		CalcoloSerie result = new CalcoloSerie(inputList);
		
		List<List<String>> originale = result.getOriginale();
		List<List<String>> retrogrado = result.getRetrogrado();
		List<List<String>> inverso = result.getInverso();
		List<List<String>> retrogradoInverso = result.getRetrogradoInverso();
		
		System.out.println("SERIE ORIGINALE" + "\n");
		for (int i = 0; i < originale.size(); ++i) {
			System.out.println("O" + i + " = " + originale.get(i) + "\n");
		}
		
		System.out.println("RETROGRADO" + "\n");
		for (int i = 0; i < retrogrado.size(); ++i) {
			System.out.println("R" + i + " = " + retrogrado.get(i) + "\n");
		}
		
		System.out.println("INVERSO" + "\n");
		for (int i = 0; i < inverso.size(); ++i) {
			System.out.println("I" + i + " = " + inverso.get(i) + "\n");
		}
		
		System.out.println("RETROGRADO DELL'INVERSO" + "\n");
		for (int i = 0; i < retrogradoInverso.size(); ++i) {
			System.out.println("RI" + i + " = " + retrogradoInverso.get(i) + "\n");
		}
		
		new java.util.Scanner(System.in).nextLine();
		
	}
}
