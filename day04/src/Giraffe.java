public class Giraffe extends Herbivore {

    public Giraffe(String nick, int age) {
        this.name = "Жираф " + nick;
        this.age = age;
        this.suitableDim = Dimension.EXTRA_LARGE;
    }

    public void soundOk() {
        System.out.println("Хрум-хрум");
    }

    public void soundBad() {
        this.soundOk();
    }


}
