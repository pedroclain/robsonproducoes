/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.repository;

import com.robsonproducoes.robsonproducoesspringapi.model.Category;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pedro
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
  
  Optional<Category> findByName(String name);
}
