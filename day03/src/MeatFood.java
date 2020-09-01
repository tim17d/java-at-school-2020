public abstract class MeatFood extends Food {

    public static class RawMeat extends MeatFood {
        public RawMeat() {
             this.name = "[сырое мясо]";
        }
    }

    public static class DoneMeat extends MeatFood {
        public DoneMeat() {
            this.name = "[приготовленное мясо]";
        }
    }

    public static class LiveProtein extends MeatFood {
        public LiveProtein() {
            this.name = "[живой протеин (рыба/насекомые/грызуны)]";
        }
    }

}
