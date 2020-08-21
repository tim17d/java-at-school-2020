public class Tiger extends Carnivore implements Touch {

    public Tiger(String nick, int age) {
        this.name = "Тигр " + nick;
        this.age = age;
    }

    @Override
    public void call() {
        System.out.println("Вы подозвали " + this.name + ". Он дрессирован :)");
    }

    public void touch() {
        System.out.println(this.name + " мурчит, потому что не голоден. Гладьте только под присмотром!");
    }

    public void soundOk() {
        System.out.println("Муррр...");
    }

    public void soundBad() {
        System.out.println("АРРРРРРРРЫ!!!");
    }
}
