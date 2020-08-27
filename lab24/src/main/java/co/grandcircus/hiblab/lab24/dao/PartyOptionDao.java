package co.grandcircus.hiblab.lab24.dao;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import co.grandcircus.hiblab.lab24.entity.PartyOption;


public interface PartyOptionDao extends JpaRepository<PartyOption, Long> {
	
//	@Query("from PartyOption where Name is not null")
//	List<PartyOption> findAll();
//	
//	@Query("from PartyOption where Votes is not 0")
//	List<PartyOption> findAllWithVotes();
//	
//	@Query("update PartyOption set Votes = votes + 1")
//	List<PartyOption> addVotes();
	}

