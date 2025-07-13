package com.eazybytes.cards.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MetaData
{
    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
