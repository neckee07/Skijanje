package skijanje;

public class Teska extends Deonica {
	
	

	public Teska(double duzina, double nagib) {
		super(duzina, nagib);
		this.oznaka = 'T';
		this.ubrzanje = (9.81 * Math.sin(Math.PI*nagib/180));
	}

	@Override
	public double brzina(double i)  {
		
		return Math.sqrt((2*ubrzanje*duzina) + (i*i));
	}




	@Override
	public double vreme(double i) {
		
		return (brzina(i)-i)/ubrzanje;
	}
	
	
	
	public static void main(String[] args) {
		
		Deonica t1 = new Teska(100.,10.);
		
		
		System.out.println(t1.oznaka());
		System.out.println(t1.duzina());
		System.out.println(t1.nagib());
		System.out.println(t1.ubrzanje());
		System.out.println(t1.brzina(0));
		System.out.println(t1.vreme(0));
		System.out.println(t1);
	}




	
}
