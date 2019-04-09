package br.com.uniliva.ebao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uniliva.ebao.entity.Adjustment;

@Repository
public interface AdjustmentRepository extends  JpaRepository<Adjustment, Long>  {
	List<Adjustment> findByStatus(String status);
	List<Adjustment> findByCreateDate(Date date);

} 