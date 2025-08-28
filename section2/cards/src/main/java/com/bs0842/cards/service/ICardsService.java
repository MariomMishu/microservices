package com.bs0842.cards.service;

import com.bs0842.cards.dto.CardsDto;

public interface ICardsService {
    void createCard(String mobileNumber);
    CardsDto fetchCard(String mobileNumber);
    boolean updateCard(CardsDto customerDto);
    boolean deleteCard(String mobileNumber);
}
