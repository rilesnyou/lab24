package co.grandcircus.hiblab.lab24.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.grandcircus.hiblab.lab24.entity.Party;


public interface PartyDao extends JpaRepository<Party, Long>{
	  @Query("from Party where name like %:prefix% ")
	  List<Party> findPartyByName(@Param("prefix") String name);
	
	}
	