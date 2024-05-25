package com.jj.godLife.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_grade")
public class Grade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("grade_no")
    private Integer gradeNo;

    @JsonProperty("grade_name")
    private String gradeName;
}
