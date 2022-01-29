package tn.esps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esps.entities.TypeCompte;

@Repository
public interface TypeCompteDao extends JpaRepository<TypeCompte, Long> {

}
