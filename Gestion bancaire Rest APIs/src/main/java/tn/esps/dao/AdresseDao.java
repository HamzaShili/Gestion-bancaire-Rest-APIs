package tn.esps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esps.entities.Adresse;

@Repository
public interface AdresseDao extends JpaRepository<Adresse, Long> {

}
