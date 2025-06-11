package com.store.mysqlsampledatabase.repository;

import com.store.mysqlsampledatabase.model.Product;
import com.store.mysqlsampledatabase.model.Productline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepository extends JpaRepository<Productline, Integer> {
}
