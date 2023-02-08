package com.mimi.service;


import com.mimi.config.Role;
import com.mimi.exception.UserNotFoundException;
import com.mimi.modele.Dog;
import com.mimi.modele.User;
import com.mimi.repository.DogRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DogServiceTest {

    @Mock
    private DogRepository dogRepository;
    @InjectMocks
    private DogService dogService;


    private Dog dog;
    private User user;

    @BeforeEach
    public void setup() {
        dog =Dog.builder()
                .dogId(1)
                .breed("caniche")
                .dogName("Pino")
                .sexe("male")
                .sterilization("oui")
                .user(user)
                .build();
    }


    @DisplayName("Should save dog")
    @Test
    public void testSaveDog(){
        //given - pre condition
        given(dogRepository.save(dog))
                .willReturn(dog);
        //when - behaviour to test
        Dog savedDog = dogRepository.save(dog);
        //then - verify the ouput
        assertThat(savedDog).isNotNull();
    }


    @DisplayName("Should return DogsList")
    @Test
    public void testGetAllDogs(){
        //given - pre condition
        Dog dog2 =dog =Dog.builder()
                .dogId(2)
                .breed("chihuahua")
                .dogName("Bob")
                .sexe("male")
                .sterilization("non")
                .user(user)
                .build();

        given(dogRepository.findAll()).willReturn(List.of(dog,dog2));
        //when - behaviour to test
        List<Dog> dogsList = dogRepository.findAll();
        System.out.println(dogsList);
        //then - verify the ouput
        assertThat(dogsList).isNotNull();
        assertThat(dogsList.size()).isEqualTo(2);
    }


}