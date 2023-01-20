package com.example.kursovaya_3_2023.exeption;

public class BadRequestException extends Throwable {
    public BadRequestException(String massage) {
        super(massage);
    }

}
