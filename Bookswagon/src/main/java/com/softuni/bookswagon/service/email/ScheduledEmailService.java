package com.softuni.bookswagon.service.email;

import com.softuni.bookswagon.model.entity.UserEntity;
import com.softuni.bookswagon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledEmailService {
    private final UserRepository userRepository;

    private final EmailSenderService emailSenderService;

    @Autowired
    public ScheduledEmailService(UserRepository userRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.emailSenderService = emailSenderService;
    }

    @Scheduled(cron = "0 30 17 * * *") // runs every day at 5:30 PM
    public void sendReminderEmails() {
        List<UserEntity> users = userRepository.findAll();
        for (UserEntity user : users) {
            String email = user.getEmail();
            String subject = "Reminder to write a book review";
            String body = "Dear " + user.getFirstName() + ",\n\nThis is a friendly reminder to write a review for the book(s) you've saved on our website. We appreciate your feedback and look forward to hearing your thoughts.\n\nBest regards,\nThe BooksWagon Team";
            emailSenderService.sendSimpleEmail(email, subject, body);
        }
    }
}
