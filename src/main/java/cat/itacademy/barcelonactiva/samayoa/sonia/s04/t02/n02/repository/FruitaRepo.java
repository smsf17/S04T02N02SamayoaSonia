package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.domain.Fruita;

@Repository
public interface FruitaRepo extends JpaRepository<Fruita, Integer> {
	
	List<Fruita> findByNom(String nom);
	
}
