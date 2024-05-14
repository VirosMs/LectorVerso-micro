package org.virosms.lectorversomicro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Table(name = "drivers")
public class Chapters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "capitulo_id")
    @JsonProperty("CapituloId")
    private Long id;


    @Column(name = "obra_id", unique = true) 
    @JsonProperty("ObraId")
    private Long idWork;
   


    private String title;
    private String content;
    private int number;
    private String language;
    private LocalDateTime creationDate;
}
