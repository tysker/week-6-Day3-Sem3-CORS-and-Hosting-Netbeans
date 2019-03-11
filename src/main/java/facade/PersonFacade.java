/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class PersonFacade {

    private List<Person> personList = new ArrayList();

    public PersonFacade() {
        personList.add(new Person(1, "Klaus", "Köln", 25));
        personList.add(new Person(2, "Nikolai", "Copenhagen", 23));
        personList.add(new Person(3, "Morten", "Brondby", 30));
        personList.add(new Person(4, "Rasmus", "Holbaek", 28));
        personList.add(new Person(5, "Jörg", "Böblingen", 42));
        personList.add(new Person(6, "Patrick", "Holbæk", 13));

    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person) {
        this.personList.add(person);
    }

    public Person getPersonById(int id) {
        return personList.get(id);
    }

    public Person deletePersonById(int id) {
        return personList.remove(id);
    }

    public int maxId() {
        // Get the highest id from the persons list 
        int max = 0;
        for (Person person : personList) {
            if (person.getId() > max) {
                max = person.getId();
            }
        }
        return max;
    }

}
