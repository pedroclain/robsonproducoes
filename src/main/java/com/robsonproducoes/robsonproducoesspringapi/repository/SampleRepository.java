/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.repository;
import com.robsonproducoes.robsonproducoesspringapi.model.Category;
import com.robsonproducoes.robsonproducoesspringapi.model.Sample;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pedro
 */
public interface SampleRepository extends CrudRepository<Sample, Long> {
    @Override
    List<Sample> findAll();
    
//    @Query("SELECT s FROM Sample s WHERE s.category = ?1")
    List<Sample> findByCategory(Category category);
    
    @Override
    Optional<Sample> findById(Long id);
    
    @Override
    void delete(Sample sample);
    
    @Override
    Sample save(Sample sample);
}
