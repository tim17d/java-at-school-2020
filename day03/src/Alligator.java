public class Alligator extends Carnivore {

    public Alligator(String nick, int age) {
        this.name = "Аллигатор " + nick;
        this.age = age;
    }

    public void soundOk() {
        this.soundBad();
    }

    public void soundBad() {
        System.out.println("Клац-клац!");
    }
}
