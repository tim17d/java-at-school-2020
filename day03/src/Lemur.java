public class Lemur extends Herbivore {

    public Lemur(String nick, int age) {
        this.name = "Лемур " + nick;
        this.age = age;
    }

    public void soundOk() {
        System.out.println("Ук-у");
    }

    public void soundBad() {
        System.out.println("УА-УА-УА-УУУ-У-УУ-УК-УК!!!!");
    }
}
