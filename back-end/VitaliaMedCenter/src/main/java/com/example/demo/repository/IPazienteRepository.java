package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Paziente;

@Repository
public interface IPazienteRepository extends CrudRepository<Paziente, Integer> {

}
