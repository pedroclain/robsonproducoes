/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author pedro
 */
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Production extends Song {
  
  @ManyToOne
  @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "production_category_fk"))
  protected Category category;
  
  @Builder
  public Production(String songName, String autorName, String lyrics, Category category, String fileUrl, String fileName, Integer priority) {
    super(songName, autorName, fileName);
    this.category = category;
  }
}
