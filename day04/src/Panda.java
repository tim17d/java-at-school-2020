public class Panda extends Herbivore {

    public Panda(String nick, int age) {
        this.name = "Панда " + nick;
        this.age = age;
        this.suitableDim = Dimension.LARGE;
    }

    public void soundOk() {
        System.out.println("Уф-уф");
    }

    public void soundBad() {
        this.soundOk();
    }

}
