package com.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryModel {
    private Long countryId;
    private String countryCode;
    private String countryName;
}
