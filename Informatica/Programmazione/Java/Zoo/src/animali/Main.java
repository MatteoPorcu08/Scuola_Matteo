package animali;

public class Main {
	public static void main(String[] args) {
		// creare un animale, un cane e un gatto
		Animali A = new Animali("Bob", 5.0f, 50f, 7);
		Cane C = new Cane("Sousage", 7f, 60f, 5, "Bassotto", "nero");
		Cane C1 = new Cane(A, "Bassotto", "nero");

		System.out.println(A.toString());
		System.out.println(C.toString());
		System.out.println(C1.toString());

		System.out.println(A.verso());
		System.out.println(C.verso());
	}
}