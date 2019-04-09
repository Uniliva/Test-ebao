package br.com.uniliva.ebao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uniliva.ebao.entity.Bill;

@Repository
public interface BillRepository  extends  JpaRepository<Bill, Long>  {}
