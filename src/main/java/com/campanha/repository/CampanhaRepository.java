package com.campanha.repository;

/**
 * Inteface representa um Repository - Utiliza o Spring Data JPA
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campanha.model.Campanha;
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
  
	@Query("SELECT new com.campanha.model.Campanha"
			+ "(c.codigo,c.nome,c.time,c.dataInicio,c.dataFim) "
				+ "FROM Campanha c "
			+ "WHERE c.dataFim >= CURRENT_DATE() Order by c.dataFim ")
	public List<Campanha> listarCampanhaAtivas();
	
	@Query("SELECT new com.campanha.model.Campanha"
			+ "(c.codigo,c.nome,c.time,c.dataInicio,c.dataFim) "
				+ "FROM Campanha c "
			+ "WHERE c.dataInicio >= :dataInicio and c.dataFim <= :dataFim ")
	public List<Campanha> listarCampanhasAtivaPorPeriodo(@Param("dataInicio")Date dataInicio,@Param("dataFim")Date dataFim);
   
	@Query("SELECT new com.campanha.model.Campanha"
			+ "(c.codigo,c.nome,c.time,c.dataInicio,c.dataFim) "
				+ "FROM Campanha c "
			+ "WHERE c.time.codigo = :codigoTime and c.dataFim >= CURRENT_DATE() Order by c.dataFim ")
	public List<Campanha> consultaCampanhaPorTime(@Param("codigoTime")Long codigoTime);
	
	
}
