package ru.netology.Tournament.domain;
public class NotFoundException extends RuntimeException{
    public NotFoundException(String playerName) {
        super("Игрок с именем " + playerName + " не найден");
    }
}
