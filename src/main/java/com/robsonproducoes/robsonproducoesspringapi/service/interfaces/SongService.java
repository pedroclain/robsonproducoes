/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.service.interfaces;

import com.robsonproducoes.robsonproducoesspringapi.model.Category;
import com.robsonproducoes.robsonproducoesspringapi.model.Production;
import com.robsonproducoes.robsonproducoesspringapi.model.Sample;
import com.robsonproducoes.robsonproducoesspringapi.model.Song;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.ProductionSaveDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.ProductionUpdateDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleSaveDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleUpdateDto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pedro
 */
public interface SongService {
    
    List<Production> findAllProductions();
    
    List<Production> findProductionByCategory(Category category);
    
    Production findProductionById(Long id);

    void deleteProduction(Production p);
    
    Production saveProduction(ProductionSaveDto dto);
    
    Production updateProduction(ProductionUpdateDto dto);
    
    List<Sample> findAllSamples();
    
    List<Sample> findSamplesByCategory(Category category);
    
    Sample findSampleById(Long id);

    void deleteSample(Sample sample);
    
    Sample saveSample(SampleSaveDto dto);
    
    Sample updateSample(SampleUpdateDto dto);
}
