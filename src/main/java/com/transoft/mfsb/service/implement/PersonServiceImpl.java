package com.transoft.mfsb.service.implement;


import com.transoft.mfsb.domain.Person;
import com.transoft.mfsb.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public List<Person> listPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Jose", 20));
        people.add(new Person(2, "Juan", 20));
        people.add(new Person(3, "Leo", 20));
        return people;
    }
}
