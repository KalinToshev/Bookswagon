package com.softuni.bookswagon.service.book;

import com.softuni.bookswagon.model.dto.AddNewBookEntityDto;
import com.softuni.bookswagon.model.entity.BookEntity;
import com.softuni.bookswagon.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBook(AddNewBookEntityDto addNewBookEntityDto) {
        BookEntity bookEntity = new BookEntity();

        modelMapper.map(addNewBookEntityDto, bookEntity);

        this.bookRepository.save(bookEntity);
    }
}
