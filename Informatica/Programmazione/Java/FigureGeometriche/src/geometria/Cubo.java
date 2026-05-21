package geometria;

public class Cubo extends FiguraGeometrica {
	private float lato;
	private float peso;
	
	//costruttore
	public Cubo(float pesoSpecifico, float lato) {
		super(pesoSpecifico);
		this.lato=lato;
		this.peso=super.pesoSpecifico*this.calcolaVolume();
	}
	
	//costruttore di  copia
	public Cubo(Cubo A) {
		super(A.pesoSpecifico);
		this.lato = A.getLato();
		this.peso=A.getPeso();
	}
	
	public float getLato() {
		return lato;
	}
	
	public float getPeso() {
		return this.peso;
	}
	public void setLato(float lato) {
		this.lato=lato;
	}
	
	public float calcolaVolume() {
		return lato*lato*lato;
	}
	
	public float calcolaSuperficie() {
		return 6*lato*lato;
	}
	
	//toString
	public String toString() {
		return "Cubo\nLato:"+this.lato+"\nVolume: "+this.calcolaVolume()+"\nSuperficie: "+this.calcolaSuperficie()+"\nPeso: "+super.toString();
	}
}