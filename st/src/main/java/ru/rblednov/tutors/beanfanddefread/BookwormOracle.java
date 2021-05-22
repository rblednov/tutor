package ru.rblednov.tutors.beanfanddefread;

public class BookwormOracle implements Oracle {
    private Enciclopedia enciclopedia;

    @Override
    public String defineMeaningOfLife() {
        return "-->  defineMeaningOfLife  <--";
    }

    public void setEnciclopedia(Enciclopedia enciclopedia) {
        this.enciclopedia = enciclopedia;
    }

}
