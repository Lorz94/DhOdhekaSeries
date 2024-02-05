import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalcoloSerie {
	private List<Integer> serie;
	private List<Boolean> diesis;
	
	private List<List<Integer>> originale;
	private List<List<Integer>> retrogrado;
	private List<List<Integer>> inverso;
	private List<List<Integer>> retrogradoInverso;
	
	
	CalcoloSerie(List<String> serie) {
		stringToInt(serie);
		genera();
	}
	
	private void genera() {
		originale = calcoloSerie(serie);
		retrogrado = calcoloSerie(reverse(serie));
		inverso = calcoloSerie(calcoloInverso(serie));
		retrogradoInverso = calcoloSerie(reverse(calcoloInverso(serie)));
	}
	
	public List<List<String>> getOriginale() {
		return originale.stream().map(this::intToString).collect(Collectors.toList());
	}
	
	public List<List<String>> getRetrogrado() {
		Collections.reverse(diesis);
		var result = retrogrado.stream().map(this::intToString).collect(Collectors.toList());
		Collections.reverse(diesis);
		
		return result;
	}
	
	public List<List<String>> getInverso() {
		return inverso.stream().map(this::intToString).collect(Collectors.toList());
	}
	
	public List<List<String>> getRetrogradoInverso() {
		Collections.reverse(diesis);
		var result = retrogradoInverso.stream().map(this::intToString).collect(Collectors.toList());
		Collections.reverse(diesis);
		
		return result;
	}
	
	private List<List<Integer>> calcoloSerie(List<Integer> serie) {
		List <List<Integer>> result = new ArrayList<List<Integer>>();
				
		result.add(serie);
		
		for (int i = 1; i < 12; ++i) {
			List <Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < serie.size(); ++j)
				l.add((serie.get(j) + i) % 12);
			result.add(l);
		}
		
		return result;
		
	}
	
	private List<Integer> calcoloInverso(List<Integer> serie) {
		List<Integer> result = new ArrayList<Integer>();
		int diff = 0;
		int tempDiff = 0;
		int tmp = 0;
		
		result.add(serie.get(0));
		for (int i = 1; i < serie.size(); ++i) {
			diff = serie.get(i-1) - serie.get(i);
			tempDiff = result.get(i-1) + diff;
			
			if (tempDiff > 11) {
				tmp = tempDiff - 12;
				result.add(tmp);
			} else if (tempDiff < 0) {
				tmp = tempDiff + 12;
				result.add(tmp);
			} else {
				result.add(tempDiff);
			}
		}
		
		return result;
	}
	
	private void stringToInt(List<String> serie) {

		this.serie = new ArrayList<Integer>();
		this.diesis = new ArrayList<Boolean>();
	
		for(int i = 0; i < serie.size(); ++i) {
			switch (serie.get(i)) {
			case "do":
				this.serie.add(0);
				this.diesis.add(true);
				break;
			case "do#":
				this.serie.add(1);
				this.diesis.add(true);
				break;
			case "reb":
				this.serie.add(1);
				this.diesis.add(false);
				break;
			case "re":
				this.serie.add(2);
				this.diesis.add(true);
				break;
			case "re#":
				this.serie.add(3);
				this.diesis.add(true);
				break;
			case "mib":
				this.serie.add(3);
				this.diesis.add(false);
				break;
			case "mi":
				this.serie.add(4);
				this.diesis.add(true);
				break;
			case "fa":
				this.serie.add(5);
				this.diesis.add(true);
				break;
			case "fa#":
				this.serie.add(6);
				this.diesis.add(true);
				break;
			case "solb":
				this.serie.add(6);
				this.diesis.add(false);
				break;
			case "sol":
				this.serie.add(7);
				this.diesis.add(true);
				break;
			case "sol#":
				this.serie.add(8);
				this.diesis.add(true);
				break;
			case "lab":
				this.serie.add(8);
				this.diesis.add(false);
				break;
			case "la":
				this.serie.add(9);
				this.diesis.add(true);
				break;
			case "la#":
				this.serie.add(10);
				this.diesis.add(true);
				break;
			case "sib":
				this.serie.add(10);
				this.diesis.add(false);
				break;
			case "si":
				this.serie.add(11);
				this.diesis.add(true);
				break;
			}
			
		}
		
	}
	
	private List<String> intToString(List<Integer> serie) {
		
		List <String> result = new ArrayList<String>();
	
		for(int i = 0; i < serie.size(); ++i) {
			switch (serie.get(i)) {
			case 0:
				result.add("do");
				break;
			case 1:
				if (diesis.get(i)) {
					result.add("do#");
				}
				else {
					result.add("reb");
				}
				break;
			case 2:
				result.add("re");
				break;
			case 3:
				if (diesis.get(i)) {
					result.add("re#");
				} else {
					result.add("mib");
				}
				break;
			case 4:
				result.add("mi");
				break;
			case 5:
				result.add("fa");
				break;
			case 6:
				if (diesis.get(i)) {
					result.add("fa#");
				} else {
					result.add("solb");
				}
				break;
			case 7:
				result.add("sol");
				break;
			case 8:
				if (diesis.get(i)) {
					result.add("sol#");
				} else {
					result.add("lab");
				}
				break;
			case 9:
				result.add("la");
				break;
			case 10:
				if (diesis.get(i)) {
					result.add("la#");
				} else {
					result.add("sib");
				}
				break;
			case 11:
				result.add("si");
				break;
			}
			
		}
		
		return result;
		
	}

	private List<Integer> reverse(List<Integer> serie) {
		List<Integer> result = new ArrayList<Integer>(serie);
		
		Collections.reverse(result);
		
		return result;
	}
}
