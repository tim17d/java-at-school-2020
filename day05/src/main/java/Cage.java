import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cage<Type extends Animal> {

    protected final Logger LOG = LoggerFactory.getLogger(Cage.class);

    public int number;
    private int freeSpaces;
    private Map<String, Type> cageContents;
    private Dimension dim;

    public Cage(int size, String dimension, Zoo zoo) {
        this.dim = Dimension.valueOf(dimension);
        this.cageContents = new HashMap<>();
        zoo.incCagesQuantity();
        this.number = zoo.getCagesQuantity();
        this.freeSpaces = size;
        LOG.info("Клетка № {} готова", this.number);
    }

    public void addAnimal(Type animal) {
        if (animal.isCaged) {
            if (this.cageContents.containsValue(animal)) {
                LOG.error("{} уже находится в этой клетке", animal.name);
            } else {
                LOG.error("{} уже находится в другой клетке", animal.name);
            }
            return;
        }
        if (animal.suitableDim != this.dim) {
            LOG.error("Размер клетки № {} не удобен для {}!", this.number, animal.name);
            return;
        }
        if (this.freeSpaces < 1) {
            LOG.error("Больше нет места в клетке № {}", this.number);
            return;
        }
        this.cageContents.put(animal.name, animal);
        animal.isCaged = true;
        this.freeSpaces -=1;
        LOG.info("{} теперь в клетке № {}", animal.name, this.number);
    }

    public void getAnimals() {
        if (this.cageContents.isEmpty()) {
            LOG.info("В КЛЕТКЕ № {} СЕЙЧАС ПУСТО", this.number);
        } else {
            LOG.info("В КЛЕТКЕ № {} НАХОДЯТСЯ: {}", this.number, this.cageContents.keySet());
        }
    }

    public void feedAnimal(Type animal, Food food) {
        if (this.cageContents.containsKey(animal.name)) {
            animal.eat(food);
        } else {
            LOG.info("{} здесь не присутствует. Клетка № {}", animal.name, this.number);
        }
    }

}
