package com.softuni.bookswagon.util;

public final class BookValidationMessages {
    public static final String TITLE_SIZE = "The title must be between 2 and 100 characters long.";

    public static final String TITLE_NOT_BLANK = "Title is required and must not contain only whitespace.";

    public static final String AUTHOR_SIZE = "The author field must be between 2 and 100 characters long.";

    public static final String AUTHOR_NOT_BLANK = "Author is required and must not contain only whitespace.";

    public static final String DESCRIPTION_SIZE = "The description field should be between 50 and 500 characters long.";

    public static final String DESCRIPTION_NOT_BLANK = "Description is required and must not contain only whitespace.";

    public static final String PUBLISH_DATE_NOT_NULL = "Publish date should not be null.";

    public static final String PUBLISH_DATE_PAST_OR_PRESENT = "The publish date should be the date from the past or present.";

    public static final String ISBN_SIZE = "The ISBN field must be between 10 and 13 characters long.";

    public static final String ISBN_NOT_BLANK = "ISBN is required and must not contain only whitespace.";

    public static final String LANGUAGE_SIZE = "The language field should be between 3 and 30 characters long.";

    public static final String LANGUAGE_NOT_BLANK = "Language is required and must not contain only whitespace.";

    public static final String PAGES_NOT_NULL = "Please enter a value for the number of pages.";

    public static final String PAGES_POSITIVE = "The page number should be a positive number.";

    public static final String BOOK_IMAGE_URL_URL = "Sorry, the image URL you entered is not recognized. Please enter a valid URL to continue.";

    public static final String BOOK_IMAGE_URL_NOT_BLANK = "Book image URL is required and must not contain only whitespace.";
}
