public class Wolf extends Carnivore {

    public Wolf(String nick, int age) {
        this.name = "Волк " + nick;
        this.age = age;
    }

    public void soundOk() {
        soundBad();
    }

    public void soundBad() {
        System.out.println("Грррр..");
    }

}
