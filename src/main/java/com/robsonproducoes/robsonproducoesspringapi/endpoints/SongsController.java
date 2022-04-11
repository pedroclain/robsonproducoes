/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.endpoints;

import com.robsonproducoes.robsonproducoesspringapi.model.Category;
import com.robsonproducoes.robsonproducoesspringapi.model.Production;
import com.robsonproducoes.robsonproducoesspringapi.model.Sample;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleSaveDto;
import com.robsonproducoes.robsonproducoesspringapi.model.dto.SampleUpdateDto;
import com.robsonproducoes.robsonproducoesspringapi.repository.CategoryRepository;
import com.robsonproducoes.robsonproducoesspringapi.service.SongServiceImp;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */
@Controller
@RequestMapping("trabalhos")
@RequiredArgsConstructor
public class SongsController {
  
  private final SongServiceImp service;
  private final CategoryRepository categoryRepository;
  
  @RequestMapping
  @CrossOrigin(origins = "https://google.com")
  public String getAllJobs(Model model, @RequestParam(name = "category", required = false) String categoryParam) {
    List<Sample> samples;
    List<Production> productions;
    String categoryTitle;
    Category category;
    String bannerUrl;
    
    if (categoryParam == null) {
      samples = service.findAllSamples();
      productions = service.findAllProductions();
      categoryTitle = "Trabalhos";
      bannerUrl = "https://gmconline.com.br/wp-content/uploads/2021/06/microphone-3989881_1280-1.jpg";
    } else {
      category = categoryRepository.findByName(categoryParam.toLowerCase().trim())
              .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));
      samples = service.findSamplesByCategory(category);
      productions = service.findProductionByCategory(category);
      categoryTitle = category.getName();
      bannerUrl = category.getBannerUrl();
    }
    
    model.addAttribute("samples", samples);
    model.addAttribute("productions", productions);
    model.addAttribute("categoryName", categoryTitle);
    model.addAttribute("bannerUrl", bannerUrl);
    return "jobs";
  }
  
//  @GetMapping("/samples/{category}")
//  public ResponseEntity<?> getSamplesByCategory(@PathVariable Category category) {
//    return new ResponseEntity<>(service.findSamplesByCategory(category), HttpStatus.OK);
//  }
//  
//  @GetMapping("/samples/{id}")
//  public ResponseEntity<?> getSamplesByCategory(@PathVariable Long id) {
//    return new ResponseEntity<>(service.findSampleById(id), HttpStatus.OK);
//  }
//  
//  @PostMapping("/samples")
//  public ResponseEntity<?> postSample(@ModelAttribute SampleSaveDto dto) {
//    return new ResponseEntity<>(service.saveSample(dto), HttpStatus.CREATED);
//  }
//  
//  @PutMapping("/samples")
//  public ResponseEntity<?> putSample(@ModelAttribute SampleUpdateDto dto) {
//    return new ResponseEntity<>(service.updateSample(dto), HttpStatus.CREATED);
//  }
//  
//  @DeleteMapping("/samples/{id}")
//  public ResponseEntity<?> deleteSample(@PathVariable Long id) {
//    Sample sampleToDelete = service.findSampleById(id);
//    service.deleteSample(sampleToDelete);
//    return new ResponseEntity<>(HttpStatus.OK);
//  }
}
