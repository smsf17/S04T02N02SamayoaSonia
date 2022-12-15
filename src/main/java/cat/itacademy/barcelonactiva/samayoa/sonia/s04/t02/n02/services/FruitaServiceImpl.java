package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.domain.Fruita;
import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.repository.FruitaRepo;

@Service
public class FruitaServiceImpl implements FruitaService {
	
	@Autowired
	FruitaRepo fruitaRepo;

	@Override
	public Fruita addFruita(Fruita fruita) {
		
		return fruitaRepo.save(fruita);
	}

	@Override
	public String updateFruita(Fruita fruitaUpdate) {
		
		int num = (int) fruitaUpdate.getId();
		
		if(fruitaRepo.findById(num).isPresent()) {
			Fruita fr = new Fruita();
			fr=fruitaRepo.findById(num).get();
			fr.setNom(fruitaUpdate.getNom());
			fr.setQuilos(fruitaUpdate.getQuilos());
			fruitaRepo.save(fr);
			return "Fruita modificada";
		}else {
		return "Fruita con Id: " +num+ " no encontrado!";
		}
	}

	@Override
	public String deleteFruita(int id) {
		
		if (fruitaRepo.findById(id).isPresent()) {
			fruitaRepo.deleteById(id);
			
			return "Fruita con Id: "+id+" eliminada";
		}
		return "Error! Fruita con Id:" +id+ " no existe";
	}

	@Override
	public Optional<Fruita> getOneFruita(int id) {
		
		return fruitaRepo.findById(id);
	}

	@Override
	public List<Fruita> getAllFruita() {
		
		return fruitaRepo.findAll();
	}

}
