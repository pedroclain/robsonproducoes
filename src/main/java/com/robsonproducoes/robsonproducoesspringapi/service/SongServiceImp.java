/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.service;

import com.robsonproducoes.robsonproducoesspringapi.model.Category;
import com.robsonproducoes.robsonproducoesspringapi.model.Production;
import com.robsonproducoes.robsonproducoesspringapi.model.Sample;
import com.robsonproducoes.robsonproducoesspringapi.model.Sample;
import com.robsonproducoes.robsonproducoesspringapi.model.Song;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.ProductionSaveDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.ProductionUpdateDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleSaveDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleUpdateDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleSaveDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleUpdateDto;
import com.robsonproducoes.robsonproducoesspringapi.repository.ProductionRepository;
import com.robsonproducoes.robsonproducoesspringapi.repository.SampleRepository;
import com.robsonproducoes.robsonproducoesspringapi.repository.SampleRepository;
import com.robsonproducoes.robsonproducoesspringapi.service.interfaces.SongService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
@RequiredArgsConstructor
public class SongServiceImp implements SongService {
  private final SampleRepository sampleRepository;
  private final ProductionRepository productionRepository;

  @Override
  public List<Sample> findAllSamples() {
    return sampleRepository.findAll();
  }

  @Override
  public List<Sample> findSamplesByCategory(Category category) {
    return sampleRepository.findByCategory(category);
  }

  @Override
  public Sample findSampleById(Long id) {
     return sampleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Sample with id '%s' not exists.", id)));
  }

  @Override
  @Transactional
  public void deleteSample(Sample p) {
    sampleRepository.delete(p);
  }

  @Override
  @Transactional
  public Sample saveSample(SampleSaveDto dto) {    
    Sample sample = Sample.builder()
            .autorName(dto.getAutorName())
            .category(dto.getCategory())
            .fileName(dto.getFileName())
            .fileUrl(dto.getFileUrl())
            .lyrics(dto.getLyrics())
            .priority(dto.getPriority())
            .songName(dto.getSongName())
            .build();
    return sampleRepository.save(sample);
  }

  @Override
  @Transactional
  public Sample updateSample(SampleUpdateDto dto) {
    
    Sample sample = Sample.builder()
            .autorName(dto.getAutorName())
            .category(dto.getCategory())
            .fileName(dto.getFileName())
            .fileUrl(dto.getFileUrl())
            .lyrics(dto.getLyrics())
            .priority(dto.getPriority())
            .songName(dto.getSongName())
            .build();
    sample.setId(dto.getId());
    
    sampleRepository.delete(sample);
    return sampleRepository.save(sample);
  }
  
  @Override
  public List<Production> findAllProductions() {
    return productionRepository.findAll();
  }

  @Override
  public List<Production> findProductionByCategory(Category category) {
    return productionRepository.findByCategory(category);
  }

  @Override
  public Production findProductionById(Long id) {
     return productionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Production with id '%s' not exists.", id)));
  }

  @Override
  @Transactional
  public void deleteProduction(Production p) {
    productionRepository.delete(p);
  }

  @Override
  @Transactional
  public Production saveProduction(ProductionSaveDto dto) {    
    Production production = Production.builder()
            .autorName(dto.getAutorName())
            .category(dto.getCategory())
            .fileName(dto.getFileName())
            .fileUrl(dto.getFileUrl())
            .lyrics(dto.getLyrics())
            .priority(dto.getPriority())
            .songName(dto.getSongName())
            .build();
    return productionRepository.save(production);
  }

  @Override
  @Transactional
  public Production updateProduction(ProductionUpdateDto dto) {    
    Production production = Production.builder()
            .autorName(dto.getAutorName())
            .category(dto.getCategory())
            .fileName(dto.getFileName())
            .fileUrl(dto.getFileUrl())
            .lyrics(dto.getLyrics())
            .priority(dto.getPriority())
            .songName(dto.getSongName())
            .build();
    production.setId(dto.getId());
    
    productionRepository.delete(production);
    return productionRepository.save(production);    
  }

}
