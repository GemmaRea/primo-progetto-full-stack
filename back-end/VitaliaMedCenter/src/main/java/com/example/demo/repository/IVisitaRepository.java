package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Visita;

@Repository
public interface IVisitaRepository extends CrudRepository<Visita, Integer> {

}
