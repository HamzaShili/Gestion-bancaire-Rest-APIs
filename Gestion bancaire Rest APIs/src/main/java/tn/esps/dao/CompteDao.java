package tn.esps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esps.entities.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, Long> {

}
