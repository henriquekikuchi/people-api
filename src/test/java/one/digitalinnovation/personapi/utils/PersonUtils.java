package one.digitalinnovation.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

public class PersonUtils {

    private static final String FIRST_NAME = "Henrique";
    private static final String LAST_NAME = "Melo Kikuchi";
    private static final String CPF_NUMBER = "414.452.455-10";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1995,12,19);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("19-12-1995")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }
    
    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();

    }
}
