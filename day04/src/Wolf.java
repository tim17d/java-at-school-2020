public class Wolf extends Carnivore {

    public Wolf(String nick, int age) {
        this.name = "Волк " + nick;
        this.age = age;
        this.suitableDim = Dimension.MEDIUM;
    }

    public void soundOk() {
        soundBad();
    }

    public void soundBad() {
        System.out.println("Грррр..");
    }

}
