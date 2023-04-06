package com.softuni.bookswagon.service.rate;

import com.softuni.bookswagon.model.dto.AddRateDTO;
import com.softuni.bookswagon.model.dto.ShowRateDTO;
import com.softuni.bookswagon.model.entity.RateEntity;
import com.softuni.bookswagon.repository.BookRepository;
import com.softuni.bookswagon.repository.RateRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public RateServiceImpl(RateRepository rateRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.rateRepository = rateRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addRate(AddRateDTO addRateDTO) {
        RateEntity rateEntity = new RateEntity();

        rateEntity.setRate(addRateDTO.getRate());
        rateEntity.setAuthorUsername(addRateDTO.getAuthorUsername());
        rateEntity.setBook(this.bookRepository.findById(addRateDTO.getBookId()).orElseThrow(() -> new IllegalArgumentException("Book with ID " + addRateDTO.getBookId() + " is not found!")));

        this.rateRepository.save(rateEntity);
    }

    @Override
    public List<ShowRateDTO> getAllRatesForBook(Long id) {
        return this.rateRepository.findAll()
                .stream()
                .map(rateEntity -> {
                    ShowRateDTO showRateDTO = new ShowRateDTO();
                    modelMapper.map(rateEntity, showRateDTO);
                    return showRateDTO;
                })
                .filter(showRateDTO -> showRateDTO.getBookId().equals(id))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteRatesByBookId(Long id) {
        this.rateRepository.deleteByBook_Id(id);
    }
}
