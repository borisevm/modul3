package jwd17_3.model;

public class Manifestacija {
	
	protected int id;
	protected String nazivMan;
	protected int brPos;
	protected Grad grad;
	
	public Manifestacija(int id, String nazivMan, int brPos, Grad grad) {		
		this.id = id;
		this.nazivMan = nazivMan;
		this.brPos = brPos;
		this.grad = grad;
	}

	@Override
	public String toString() {
		return "Manifestacija [id=" + id + ", nazivMan=" + nazivMan + ", brPos=" + brPos + ", grad=" + grad + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivMan() {
		return nazivMan;
	}

	public void setNazivMan(String nazivMan) {
		this.nazivMan = nazivMan;
	}

	public int getBrPos() {
		return brPos;
	}

	public void setBrPos(int brPos) {
		this.brPos = brPos;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}
}
