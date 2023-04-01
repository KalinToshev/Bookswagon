package com.softuni.bookswagon.service.book;

import com.softuni.bookswagon.model.dto.AddNewBookEntityDto;
import com.softuni.bookswagon.model.dto.BookInfoForAdminDTO;
import com.softuni.bookswagon.model.dto.BookSummaryDTO;
import com.softuni.bookswagon.model.dto.FullBookInfoDTO;
import com.softuni.bookswagon.model.entity.BookEntity;
import com.softuni.bookswagon.repository.BookRepository;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<BookSummaryDTO> getAllBooksSummary() {
        return this.bookRepository.findAll().stream()
                .map(bookEntity -> {
                    BookSummaryDTO bookSummaryDTO = new BookSummaryDTO();
                    modelMapper.map(bookEntity, bookSummaryDTO);
                    return bookSummaryDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public FullBookInfoDTO findFullBookInfoByBookId(Long id) {
        Optional<BookEntity> book = this.bookRepository.findById(id);

        if (book.isEmpty()) throw new IllegalArgumentException("Book with id " + id + " is not found!");

        FullBookInfoDTO fullBookInfoDTO = new FullBookInfoDTO();

        modelMapper.map(book.get(), fullBookInfoDTO);

        return fullBookInfoDTO;
    }

    @Override
    public List<BookInfoForAdminDTO> findAllBooksAndMapForAdminPanel() {
        return this.bookRepository.findAll()
                .stream()
                .map(bookEntity -> {
                    BookInfoForAdminDTO bookInfoForAdminDTO = new BookInfoForAdminDTO();
                    modelMapper.map(bookEntity, bookInfoForAdminDTO);
                    return bookInfoForAdminDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
