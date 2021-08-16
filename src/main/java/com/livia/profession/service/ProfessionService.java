package com.livia.profession.service;

import com.livia.profession.modelo.Profession;
import com.livia.profession.repository.ProfessionRepository;
import com.livia.profession.service.exceptions.DatabaseException;
import com.livia.profession.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionService {

    @Autowired
    private ProfessionRepository repository;


    public List<Profession> findAll() {
        return repository.findAll();
    }

    public Profession findById(Long id) {
        Optional<Profession> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Profession insert(Profession obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Profession update(Long id, Profession obj) {
        try {
            Profession entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Profession entity, Profession obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
    }
}
