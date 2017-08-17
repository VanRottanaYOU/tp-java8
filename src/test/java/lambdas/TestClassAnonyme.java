package lambdas;

public class TestClassAnonyme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Mapper mapper = new Mapper() {
//			public Person map(CompteCourant compte) {
//				return new Person(compte.getSolde());
//			}
//		};
		
//		Mapper mapper = (CompteCourant compte) -> {
//			return new Person(compte.getSolde());
//		}
//	;
		
//		Mapper mapper = (CompteCourant compte) -> new Person(compte.getSolde());

		Mapper mapper = compte -> new Person(compte.getSolde());
		
		CompteCourant cc = new CompteCourant();
		cc.setSolde(150.00);
		Person person = mapper.map(cc);
		System.out.println(person.getSolde());
	}

}
