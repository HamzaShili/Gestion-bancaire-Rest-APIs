package tn.esps.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esps.entities.Operation;

@Repository
public interface OperationDao extends JpaRepository<Operation, Long> {
	@Query("select o from Operation o where o.compte.rib=:x order by o.dateOperation desc")
	List<Operation> findAllByRib(@Param("x") Long rib, Pageable pageable);

}
