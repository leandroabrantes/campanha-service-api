package com.campanha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campanha.model.Time;

/**
 * Interface representa um Repository - Utiliza o Spring Data JPA
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */
public interface TimeRepository extends JpaRepository<Time, Long> {

	public List<Time> findByNomeLike(String nome);

}
