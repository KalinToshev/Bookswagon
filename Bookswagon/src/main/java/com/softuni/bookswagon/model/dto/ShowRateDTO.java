package com.softuni.bookswagon.model.dto;

import com.softuni.bookswagon.model.enums.RateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowRateDTO {
    private RateEnum rateEnum;

    private String authorUsername;

    private Long bookId;
}
