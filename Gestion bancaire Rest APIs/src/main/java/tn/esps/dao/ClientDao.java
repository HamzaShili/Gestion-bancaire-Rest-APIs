package tn.esps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esps.entities.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, String> {

}
