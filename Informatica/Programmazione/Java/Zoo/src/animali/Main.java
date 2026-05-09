package animali;

public class Main {
	public static void main(String[] args) {
		// creare un animale, un cane e un gatto
		Animali A = new Animali("Bob", 5.0f, 50f, 7);
		Cane C = new Cane("Sousage", 7f, 60f, 5, "Bassotto", "nero");
		Cane C1 = new Cane(A, "Bassotto", "nero");
		Gatto G = new Gatto("Micio", 3.0f, 40f, 2, "Siamese", "bianco");
		Gatto G1 = new Gatto(A, "Siamese", "bianco");

		System.out.println(A.toString());
		System.out.println(C.toString());
		System.out.println(C1.toString());
		System.out.println(G.toString());
		System.out.println(G1.toString());

		System.out.println(A.verso());
		System.out.println(C.verso());
		System.out.println(G.verso());
	}
}           