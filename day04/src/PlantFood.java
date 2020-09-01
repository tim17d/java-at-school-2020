public abstract class PlantFood extends Food {

    public static class Grass extends PlantFood {
        public Grass() {
            this.name = "[зелень]";
        }
    }

    public static class CompoundFeed extends PlantFood {
        public CompoundFeed() {
            this.name = "[комбикорм]";
        }
    }

    public static class Fruit extends PlantFood {
        public Fruit() {
            this.name = "[фрукты]";
        }
    }

}
