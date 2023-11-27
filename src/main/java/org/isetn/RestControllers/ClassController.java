package org.isetn.RestControllers;

import java.util.List;
import java.util.Optional;

import org.isetn.entities.Classe;
import org.isetn.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("class")

public class ClassController {
	@Autowired
	private ClasseRepository classeRepository;

	@PostMapping("/add")
	public Classe add(@RequestBody Classe classe) {
		System.out.println(classe.toString());
		return classeRepository.save(classe);
	}

	@GetMapping("/all")
	public List<Classe> getAll() {
		return classeRepository.findAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id)
	{
		Classe c =  classeRepository.findById(id).get();
		classeRepository.delete(c);
	}
	
	@PutMapping("/update")
	public Classe update(@RequestBody Classe classe) {
		return classeRepository.save(classe);
	}

	@GetMapping("/get/{id}")
	public Optional<Classe> getById(@PathVariable Long id) {
		return classeRepository.findById(id);
	}

}
