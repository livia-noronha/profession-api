package com.livia.profession.controller;

import com.livia.profession.modelo.Profession;
import com.livia.profession.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/profession")
public class ProfessionController {

	@Autowired
	ProfessionService professionService;

	@GetMapping
	public ResponseEntity<List<Profession>> findAll() {
		List<Profession> userList = professionService.findAll();
		return ResponseEntity.ok().body(userList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Profession> findById(@PathVariable Long id) {
		Profession obj = professionService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Profession> insert(@RequestBody Profession obj) {
		obj = professionService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		professionService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Profession> update(@PathVariable Long id, @RequestBody Profession obj) {
		obj = professionService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}