/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.repository;
import com.robsonproducoes.robsonproducoesspringapi.model.Category;
import com.robsonproducoes.robsonproducoesspringapi.model.Production;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pedro
 */
public interface ProductionRepository extends CrudRepository<Production, Long> {
    @Override
    List<Production> findAll();
    
//    @Query("SELECT p FROM Production p WHERE p.category = ?1")
    List<Production> findByCategory(Category category);
    
    @Override
    Optional<Production> findById(Long id);
    
    @Override
    void delete(Production p);
    
    @Override
    Production save(Production production);
}
