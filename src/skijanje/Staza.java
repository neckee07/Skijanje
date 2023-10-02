package skijanje;

import java.util.ArrayList;

public class Staza {

	private ArrayList<Deonica> deonice;
	private String ime;
	
	
	public Staza(String ime) {
		this.ime = ime;
		deonice = new ArrayList<>();
	}


	public void dodaj(Deonica deo) {
		deonice.add(deo);
		
	}


	public int broj() {
		
		return deonice.size();
	}


	public double duzina() {
		double ukduzina = 0;
		
		for(Deonica d: deonice) {
			ukduzina += d.duzina();
		}
		
		return ukduzina;
	}


	public double nagib() {
		double maxnagib = 0;
		
		for(Deonica d: deonice) {
			if(d.nagib() > maxnagib) {
				maxnagib = d.nagib();
			}
		}
		
		return maxnagib;
	}


	public char oznaka() throws GOznaka{
		//char oznakas = deonice.get(0).oznaka();
		char oznakas = 't';
		int j = 0;
		int max = 0;
		int brmax= 0;
		ArrayList<Character> nizc = new ArrayList<>();
		ArrayList<Integer> nizi = new ArrayList<>();
		if(deonice.isEmpty())
			throw new GOznaka("Nema deonica");
		
		for(Deonica d: deonice) {
			if(nizc.contains(d.oznaka())) {
				j = nizi.get(nizc.indexOf(d.oznaka())) + 1;
				nizi.set(nizc.indexOf(d.oznaka()), j);
			}else {
				nizc.add(d.oznaka());
				nizi.add(1);
			}
		}
		for(Integer i : nizi) {
			if(i > max) {
				max = i;
			}
		}
		for(Integer i : nizi) {
			if(i == max) {
				brmax++;
			}
		}
		//if(brmax >0) {
			//oznakas = deonice.get(0).oznaka();
		//}else
			oznakas = nizc.get(nizi.indexOf(max));
		return oznakas;
	}


	public double brzina(double i) {
		double krajnjabrzina = i;
		
		for(Deonica d:deonice) {
			krajnjabrzina = d.brzina(krajnjabrzina);
		}
		
		return krajnjabrzina;
	}


	public double vreme(double i) {
		double krajnjevreme = 0;
		double pocetnabrzina = i;
		for(Deonica d: deonice) {
			
			krajnjevreme += d.vreme(pocetnabrzina);
			pocetnabrzina = d.brzina(pocetnabrzina);
		}
		return krajnjevreme;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime).append("|").append(broj()).append("|").append(duzina()).append("|").append(nagib()).append("\n").append("[");
		for(int i = 0; i<broj(); i++) {
			sb.append(deonice.get(i));
			if(i != broj()-1) {
				sb.append(",");
			}
			
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		double broj = 0;
		double broj1 =0;
		Staza s = new Staza("Novak");
		Deonica d1 = new Teska(100.0, 10.0);
		Deonica d2 = new Teska(500.,5.);
		s.dodaj(d1);
		s.dodaj(d2);
		System.out.println(s.nagib());
		
		System.out.println(d1.brzina(d2.brzina(0)));
		System.out.println(s.brzina(0));
		System.out.println(d1.vreme(0));
		System.out.println(d2.vreme(d1.brzina(0)));
		broj = d1.vreme(0);
		broj1 = d2.vreme(d1.brzina(0));
		System.out.println(broj);
		System.out.println(broj1);
		broj += broj1;
		System.out.println(broj);
		System.out.println(s.vreme(0));
		
		broj = d1.brzina(0);
		System.out.println(broj);
		broj1 = d2.brzina(broj);
		System.out.println(broj1);
		System.out.println(s.brzina(0));
		System.out.println(s);
		//System.out.println(d2.vreme(0));
		//System.out.println(d1.vreme(d2.vreme(0)));
		
		
	}
}
