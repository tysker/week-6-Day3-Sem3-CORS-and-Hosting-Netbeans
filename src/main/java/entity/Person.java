/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author oerte
 */
public class Person {

    private Integer id;
    private String name;
    private String birthPlace;
    private int age;

    public Person(Integer id, String name, String birthPlace, int age) {
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.age = age;
    }

    public Person(String name, String birthPlace, int age) {
        this.name = name;
        this.birthPlace = birthPlace;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
