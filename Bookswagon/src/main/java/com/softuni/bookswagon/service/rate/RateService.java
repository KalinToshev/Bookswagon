package com.softuni.bookswagon.service.rate;

import com.softuni.bookswagon.model.dto.AddRateDTO;
import com.softuni.bookswagon.model.dto.ShowRateDTO;

import java.util.List;

public interface RateService {
    void addRate(AddRateDTO addRateDTO);

    List<ShowRateDTO> getAllRatesForBook(Long id);

    void deleteRatesByBookId(Long id);
}
