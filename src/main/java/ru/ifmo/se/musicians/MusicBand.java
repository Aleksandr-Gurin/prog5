package ru.ifmo.se.musicians;


import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class MusicBand implements Comparable<MusicBand>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int numberOfParticipants; //Значение поля должно быть больше 0
    private java.util.Date establishmentDate; //Поле может быть null
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null
    public MusicBand(){};
    private static Integer last = 1;

    {
        id=last;
        last++;
        creationDate = new Date();
    }
    public MusicBand(String name, Coordinates coordinates, int numberOfParticipants, java.util.Date establishmentDate,MusicGenre genre, Person frontMan) {
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.frontMan = frontMan;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public Integer getId() {
        return id;
    }

    public java.util.Date getEstablishmentDate() {
        return establishmentDate;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public Person getFrontMan() {
        return frontMan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public void setFrontMan(Person frontMan) {
        this.frontMan = frontMan;
    }

    public static void setLast(Integer last) {
        MusicBand.last = last;
    }

    @Override
    public String toString(){
        return "Класс: " + getClass().getName() + ", id = " + getId() + ", coordinates = " + getCoordinates() + ", creationDate = " + getCreationDate() + ", NumberOfParticipants = " + getNumberOfParticipants() + ", EstablishmentDate = " + getEstablishmentDate() + ", genre = " + getGenre() +", frontman" + getFrontMan() + ", name =" + getName();
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, coordinates, creationDate, numberOfParticipants, establishmentDate, genre, frontMan);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicBand testClass = (MusicBand) o;
        return id == testClass.id &&
                Objects.equals(creationDate, testClass.creationDate) &&
                Objects.equals(genre, testClass.genre) &&
                Objects.equals(creationDate, testClass.creationDate) &&
                Objects.equals(numberOfParticipants, testClass.numberOfParticipants) &&
                Objects.equals(name, testClass.name);
    }

    @Override
    public int compareTo(MusicBand musicBand){
        if (musicBand == null){
            return 1;
        }
        else {
            return this.hashCode() - hashCode();
        }
    }
}
