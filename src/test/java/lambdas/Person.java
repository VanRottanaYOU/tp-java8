package lambdas;

public class Person {
	
	private String nom;
	private double Solde;
	
	public double getSolde() {
		return Solde;
	}

	public void setSolde(double solde) {
		Solde = solde;
	}

	public Person(Double solde) {
		this.Solde=solde;
	}

}
