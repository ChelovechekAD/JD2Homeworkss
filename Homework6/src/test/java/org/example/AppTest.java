package org.example;


import org.example.DAO.HibernatePersonDAO;
import org.example.DAO.HibernatePersonDAOImpl;
import org.example.DTO.PersonDTO;
import org.example.Utility.HibernateUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.MockConst.*;

public class AppTest {


    @Test
    public void save(){

        HibernatePersonDAO hibernatePersonDAO = new HibernatePersonDAOImpl();
        EntityManager entityManager = HibernateUtil.getEntityManager();

        List<PersonDTO> generatedList = MockUtil.createListPersons(MockConst.COUNT_OF_PERSON);
        List<PersonDTO> findList = generatedList.stream()
                .map(hibernatePersonDAO::save)
                .map(p->entityManager.find(PersonDTO.class, p.getId()))
                .collect(Collectors.toList());
        entityManager.close();

        IntStream.range(0, MockConst.COUNT_OF_PERSON)
                .forEach(i->{
                    PersonDTO genP = generatedList.get(i);
                    PersonDTO findP = findList.get(i);
                    assertNotNull(genP);
                    assertNotNull(findP);
                    assertEquals(genP, findP);
                });


    }

    @Test
    public void find(){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        HibernatePersonDAO hibernatePersonDAO = new HibernatePersonDAOImpl();

        List<PersonDTO> personDTOList = MockUtil.createListPersons(COUNT_OF_PERSON);

        entityManager.getTransaction().begin();
        personDTOList.forEach(entityManager::persist);
        entityManager.getTransaction().commit();


        List<PersonDTO> filteredDTOListByAge = personDTOList.stream()
                .filter(p->p.getAge() > AGE_CONDITION)
                .sorted(Comparator.comparing(PersonDTO::getDateTimeCreate))
                .collect(Collectors.toList());

        List<PersonDTO> findFilteredDTOListByAge = hibernatePersonDAO.findByColumn(BY_AGE, AGE_CONDITION, BY_DATE_TIME_CREATE);

        assertEquals(filteredDTOListByAge.size(), findFilteredDTOListByAge.size());
        assertEquals(filteredDTOListByAge.get(0).getDateTimeCreate(), findFilteredDTOListByAge.get(0).getDateTimeCreate());


        List<PersonDTO> filteredDTOListBySalary = personDTOList.stream()
                .filter(personDTO -> personDTO.getSalary() > SALARY_CONDITION)
                .sorted(Comparator.comparing(PersonDTO::getAge))
                .collect(Collectors.toList());

        List<PersonDTO> findFilteredDTOListBySalary = hibernatePersonDAO.findByColumn(BY_SALARY, SALARY_CONDITION, BY_AGE);

        assertEquals(filteredDTOListBySalary.size(), findFilteredDTOListBySalary.size());
        assertEquals(filteredDTOListBySalary.get(0).getAge(), findFilteredDTOListBySalary.get(0).getAge());

    }
}
