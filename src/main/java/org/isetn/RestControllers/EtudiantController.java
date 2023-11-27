package org.isetn.RestControllers;

import java.util.List;
import java.util.Optional;

import org.isetn.entities.Etudiant;
import org.isetn.entities.Formation;
import org.isetn.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("etudiant")

public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;

	@PostMapping("/add")
	public Etudiant add(@RequestBody Etudiant etudiant ) {
		
		return etudiantRepository.save(etudiant);
	}

	@GetMapping("/all")
	public List<Etudiant> getAll() {
		return etudiantRepository.findAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id)
	{
		Etudiant c =  etudiantRepository.findById(id).get();
		etudiantRepository.delete(c);
	}
	
	@PutMapping("/update")
	public Etudiant update(@RequestBody Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@GetMapping("/findByClasseId/{id}")
	public List<Etudiant> getByClasseId(@PathVariable Long id) {
		return etudiantRepository.findByClasseCodClass(id);
	}

	@GetMapping("/get/{id}")
	public Optional<Etudiant> getById(@PathVariable Long id) {
		return etudiantRepository.findById(id);
	}

}
