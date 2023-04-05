package com.softuni.bookswagon.service.book;

import com.softuni.bookswagon.model.dto.AddNewBookEntityDto;
import com.softuni.bookswagon.model.dto.BookInfoForAdminDTO;
import com.softuni.bookswagon.model.dto.BookSummaryDTO;
import com.softuni.bookswagon.model.dto.FullBookInfoDTO;
import com.softuni.bookswagon.model.entity.BookEntity;
import com.softuni.bookswagon.model.entity.UserEntity;
import com.softuni.bookswagon.repository.BookRepository;
import com.softuni.bookswagon.service.user.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, UserService userService, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.userService = userService;
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
    public List<BookSummaryDTO> getAllSavedBooksOfUser(String username) {
        UserEntity user = this.userService.getUserEntityByUsername(username);

        return user.getReadBooks().stream().map(book -> {
            BookSummaryDTO bookSummaryDTO = new BookSummaryDTO();
            modelMapper.map(book, bookSummaryDTO);
            return bookSummaryDTO;
        }).collect(Collectors.toList());
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

    @Transactional
    @Override
    public void deleteBookById(Long id) {
        BookEntity book = findBookById(id);

        for (UserEntity user : book.getUsers()) {
            user.getReadBooks().remove(book);
        }

        this.bookRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addBookToUserRepo(Long bookId, String username) {
        BookEntity book = this.bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book with id " + bookId + " was not found!"));

        UserEntity userEntity = this.userService.getUserEntityByUsername(username);

        userEntity.addBook(book);
    }

    @Override
    public BookEntity findBookById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("A book with id " + id + " was not found!"));
    }
}
