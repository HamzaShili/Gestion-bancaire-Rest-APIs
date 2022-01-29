package tn.esps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esps.entities.Agence;

@Repository
public interface AgenceDao extends JpaRepository<Agence, Long> {

}
