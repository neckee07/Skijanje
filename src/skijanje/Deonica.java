package skijanje;



public abstract class Deonica {

	protected double duzina;
	protected double nagib;
	protected char oznaka;
	protected double ubrzanje;
	//protected double brzina;
	//protected double vreme;
	
	
	
	
	public Deonica(double duzina, double nagib) {
		super();
		this.duzina = duzina;
		this.nagib = nagib;
		this.oznaka = 'O';
		
	}
	
	
	public double duzina() {
		return duzina;
	}
	public double nagib() {
		return nagib;
	}
	
	public char oznaka() {
		return oznaka;
	}
	
	public double ubrzanje() {
		return ubrzanje;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		
		sb.append(oznaka).append("(").append(duzina).append(",").append(nagib).append(")");
		
		return sb.toString();
	}

	
	
	
	public double brzina(double i) {
		
		return Math.sqrt((2*ubrzanje*duzina) + (i*i));
	}


	public double vreme(double i) {
		
		return (brzina(i)-i)/ubrzanje;
	}
	
	
	
}
