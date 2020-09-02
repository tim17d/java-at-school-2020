import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EatingTest {

    Animal carnivore, herbivore;
    Food plant, meat;

    @BeforeEach
    public void setup() {
        carnivore = spy(Carnivore.class);
        herbivore = spy(Herbivore.class);
        plant = mock(PlantFood.class);
        meat = mock(MeatFood.class);
    }

    @DisplayName("Хищник не может есть растения")
    @Test
    public void shouldThrowWFEForCarnivore() {
        assertThrows(WrongFoodException.class, () -> carnivore.eat(plant));
    }

    @DisplayName("Хищник может есть мясо")
    @Test
    public void shouldNotThrowWFEForCarnivore() {
        assertDoesNotThrow(() -> carnivore.eat(meat));
    }

    @DisplayName("Травоядное не может есть мясо")
    @Test
    public void shouldThrowWFEForHerbivore() {
        assertThrows(WrongFoodException.class, () -> herbivore.eat(meat));
    }

    @DisplayName("Травоядное может есть растения")
    @Test
    public void shouldNotThrowWFEForHerbivore() {
        assertDoesNotThrow(() -> herbivore.eat(plant));
    }

}
