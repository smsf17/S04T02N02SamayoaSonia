package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruites")
public class Fruita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "quantitatQuilos")
	private int quilos;

	public Fruita() {
	}

	public Fruita(String nom, int quilos) {
		this.nom = nom;
		this.quilos = quilos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuilos() {
		return quilos;
	}

	public void setQuilos(int quilos) {
		this.quilos = quilos;
	}

	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quilos=" + quilos + "]";
	}
	
	


}
