package co.grandcircus.hiblab.lab24.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.hiblab.lab24.entity.Party;


public interface PartyDao extends JpaRepository<Party, Long>{
	
	}
	