package co.grandcircus.hiblab.lab24.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.hiblab.lab24.entity.RSVP;


	public interface RSVPdao extends JpaRepository<RSVP, Long> {
	
}
