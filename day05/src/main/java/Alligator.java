public class Alligator extends Carnivore {

    public Alligator(String nick, int age) {
        this.name = "Аллигатор " + nick;
        this.age = age;
        this.suitableDim = Dimension.EXTRA_LARGE;
    }

    public void soundOk() {
        this.soundBad();
    }

    public void soundBad() {
        System.out.println("Клац-клац!");
    }
}
