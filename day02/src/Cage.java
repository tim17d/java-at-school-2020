import java.sql.SQLOutput;

public class Cage {

    public int number;
    private int totalSpaces, freeSpaces;
    private boolean isHerbivoreFriendly = true;

    public Cage(int size, Zoo zoo) {
        zoo.totalCages++;
        this.number = zoo.totalCages;
        this.totalSpaces = this.freeSpaces = size;
        System.out.println("Клетка № " + this.number + " готова");
    }

    private String getType() {
        String type;
        if (this.isHerbivoreFriendly) {
            type = "[травоядные]";
        } else {
            type = "[хищники]";
        }
        return type;
    }

    private void cageAnimal(Animal animal) {
        animal.isCaged = true;
        animal.cageNum = this.number;
        this.freeSpaces -= 1;
        System.out.println(animal.name + " теперь в клетке № " + this.number + getType());
    }

    public void addAnimal(Animal animal) {
        if (animal.isCaged) {
            System.out.println(animal.name + " уже находится в другой клетке");
        } else {
            if (this.freeSpaces < 1) {
                System.out.println("Больше нет места в клетке № " + this.number);
            } else {
                if (this.freeSpaces == this.totalSpaces) {
                    if (animal instanceof Carnivore) {
                        isHerbivoreFriendly = false;
                    }
                    cageAnimal(animal);
                } else {
                    if (isHerbivoreFriendly & animal instanceof Herbivore) {
                        cageAnimal(animal);
                    } else {
                        if (!isHerbivoreFriendly & animal instanceof Carnivore) {
                            cageAnimal(animal);
                        } else {
                            System.out.println("Нельзя сажать хищников и травоядных вместе! " +
                                    "Животное: " + animal.name + animal.getType() + " Клетка № "
                                            + this.number + ":" + this.getType());
                        }
                    }
                }
            }
        }
    }

    public void touchCage() {
        if (this.freeSpaces == this.totalSpaces) {
            System.out.println(">>>Эта клетка еще не используется, посмотрите другие. Клетка № " + this.number);
        } else {
            if (this.isHerbivoreFriendly) {
                System.out.println(">>>Этих животных можно погладить или покормить. Клетка № " + this.number + this.getType());
            } else {
                System.out.println(">>>Это клетка с хищниками. Будьте осторожны! Клетка № " + this.number + this.getType());
            }
        }
    }

    public void feedAnimal(Herbivore animal, Food food) {
        if (animal.cageNum == this.number) {
            animal.eat(food);
            if (animal.successfulMeal) {
                System.out.println(animal.name + ": Спасибо, что покормили меня!");
            }
        } else {
                System.out.println(animal.name + " здесь не присутствует. Клетка № " + this.number);
        }
    }

    public void feedAnimal(Carnivore animal, Food food) {
        if (animal.cageNum == this.number) {
            System.out.println("ОПАСНО! Хищников не кормить!");
        } else {
            System.out.println(animal.name + " здесь не присутствует. Клетка № " + this.number);
        }
    }

}
