/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.model.dto;

import com.robsonproducoes.robsonproducoesspringapi.model.Category;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author pedro
 */
@MappedSuperclass
@Getter
@Setter
@ToString
public class SampleSaveDto {
  private String songName;
  private String autorName;
  private String lyrics;
  private Category category;
  private Integer priority;
  private String fileUrl;
  private String fileName;
}