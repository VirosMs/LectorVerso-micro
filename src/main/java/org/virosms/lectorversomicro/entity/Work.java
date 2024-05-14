package org.virosms.lectorversomicro.entity;

import lombok.Data;

@Data
public class Work {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String language;
    private String description;
    private String coverImage;
}
