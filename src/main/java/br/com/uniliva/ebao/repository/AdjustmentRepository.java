package br.com.uniliva.ebao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.uniliva.ebao.entity.Adjustment;
import br.com.uniliva.ebao.enums.Status;

@Repository
public interface AdjustmentRepository extends  JpaRepository<Adjustment, Long>  {
	List<Adjustment> findByStatus(Status status);
	@Query("SELECT adj FROM  TBL_ADJUSTMENT adj WHERE adj.status =  ?1 and adj.createDate = ?2")
	List<Adjustment> findByFilters(Status status, Date Date);

} 