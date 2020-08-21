public class Main {

    public static void main(String[] args) {

        //Новый зоопарк
        Zoo zoo = new Zoo("\"WhatTheZoo?!\"");
        System.out.println();

        //Завозим животных
        Panda panda = new Panda("Энди", 1);
        Giraffe giraffe1 = new Giraffe("Гари", 3);
        Giraffe giraffe2 = new Giraffe("Ники", 3);
        Lemur lemur = new Lemur("Тимми", 10);
        Duck duck = new Duck("Дашутка", 2);

        Tiger tiger = new Tiger("Иннокентий", 5);
        Wolf wolf = new Wolf("Степан", 15);
        Alligator alligator = new Alligator("Алли", 0);

//        //Достаем коробки с какой-то пищей
//        Food[] boxOfFood1 = Food.giveBoxOfFood();
//        Food[] boxOfFood2 = Food.giveBoxOfFood();
//
//        //Кормим разной едой
//        giraffe1.eat(boxOfFood1[3]);
//        tiger.eat(boxOfFood2[0]);
//        alligator.eat(boxOfFood1[4]);
//        lemur.eat(boxOfFood2[1]);
//        System.out.println();

        //Создаем клетки
        Cage<Carnivore> cage1 = new Cage<>(2, zoo);
        Cage<Herbivore> cage2 = new Cage<>(5, zoo);
        Cage<Panda> cage3 = new Cage<>(1, zoo);
        Cage<Wolf> cage4 = new Cage<>(3, zoo);
        System.out.println();

        //Клетка для хищников
        cage1.addAnimal(tiger);
        //cage1.addAnimal(giraffe1); - ожидаемая ошибка
        cage1.getAnimals();
        cage1.feedAnimal(tiger, Food.randomFood());
        System.out.println();

        //Клетка для травоядных
        cage2.addAnimal(lemur);
        //cage2.addAnimal(wolf); - ожидаемая ошибка
        //cage2.feedAnimal(tiger, Food.randomFood()); - ожидаемая ошибка
        cage2.addAnimal(panda);
        cage2.addAnimal(duck);
        cage2.getAnimals();
        cage2.feedAnimal(panda, Food.randomFood());
        cage2.feedAnimal(duck, new PlantFood.Grass());
        cage2.feedAnimal(duck, new MeatFood.LiveProtein());
        System.out.println();

        //Клетка для панд
        cage3.addAnimal(panda);
        //cage3.addAnimal(giraffe2); - ожидаемая ошибка
        cage3.getAnimals();

        //Клетка для волков
        //cage4.addAnimal(alligator); - ожидаемая ошибка
        cage4.addAnimal(wolf);
        cage4.getAnimals();
        System.out.println();

        //Взаимодействуем с животными через интерфейсы
        tiger.call();
        tiger.touch();
        tiger.soundOk();
        tiger.soundBad();
        System.out.println();

        alligator.call();
        //alligator.touch(); - ожидаемая ошибка
        alligator.soundOk();
        alligator.soundBad();
        System.out.println();

        duck.call();
        duck.touch();
        duck.soundOk();
        duck.soundBad();

    }
}
