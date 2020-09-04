public class Duck extends Herbivore {

    public Duck(String nick, int age) {
        this.name = "Утка " + nick;
        this.age = age;
        this.suitableDim = Dimension.SMALL;
    }

    public void call() {
        System.out.println("Эти утки никого не слушают! Даже " + this.name);
    }

    public void touch() {
        this.soundBad();
    }

    public void soundOk() {
        this.soundBad();
    }

    public void soundBad() {
        System.out.println("КРЯ-КРЯК!");
    }

}
