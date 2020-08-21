import java.util.HashMap;
import java.util.Map;

public class Cage<Type extends Animal> {
    public int number;
    private int freeSpaces;
    private Map<String, Type> cageContents;

    public Cage(int size, Zoo zoo) {
        this.cageContents = new HashMap<>();
        zoo.incCagesQuantity();
        this.number = zoo.getCagesQuantity();
        this.freeSpaces = size;
        System.out.println("Клетка № " + this.number + " готова");
    }

    public void addAnimal(Type animal) {
        if (animal.isCaged) {
            if (this.cageContents.containsValue(animal)) {
                System.out.println(animal.name + " уже находится в этой клетке");
            } else {
                System.out.println(animal.name + " уже находится в другой клетке");
            }
            return;
        }
        if (this.freeSpaces < 1) {
            System.out.println("Больше нет места в клетке № " + this.number);
            return;
        }
        this.cageContents.put(animal.name, animal);
        animal.isCaged = true;
        this.freeSpaces -=1;
        System.out.println(animal.name + " теперь в клетке № " + this.number);
    }

    public void getAnimals() {
        if (this.cageContents.isEmpty()) {
            System.out.println("В КЛЕТКЕ № " + this.number + " СЕЙЧАС ПУСТО");
        } else {
            System.out.print("В КЛЕТКЕ № " + this.number + " НАХОДЯТСЯ: |");
            for (Map.Entry entry : this.cageContents.entrySet()) {
                System.out.print(" " + entry.getKey() + " |");
            }
        }
        System.out.println();
    }

    public void feedAnimal(Type animal, Food food) {
        if (this.cageContents.containsKey(animal.name)) {
            animal.eat(food);
            if (animal.successfulMeal) {
                System.out.println(animal.name + ": Спасибо, что покормили меня!");
            }
        } else {
            System.out.println(animal.name + " здесь не присутствует. Клетка № " + this.number);
        }
    }

}
