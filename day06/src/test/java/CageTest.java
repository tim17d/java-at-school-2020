import org.junit.jupiter.api.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CageTest {

    final Logger LOG = LoggerFactory.getLogger(CageTest.class);

    static int size;
    static Dimension smallDim;
    static Zoo mZoo;
    Animal smallAnimal1, smallAnimal2;
    Cage<Animal> smallCage;

    @BeforeAll
    public static void initCageParams() {
        size = 1;
        smallDim = Dimension.SMALL;
        mZoo = mock(Zoo.class);
    }

    @BeforeEach
    public void setup() {
        int age = 1;
        String animalNick1 = "Маленький зверь 1";
        String animalNick2 = "Маленький зверь 2";
        smallAnimal1 = mock(Lemur.class, withSettings().useConstructor(animalNick1, age));
        smallAnimal2 = mock(Lemur.class, withSettings().useConstructor(animalNick2, age));
        smallAnimal1.name = animalNick1;
        smallAnimal2.name = animalNick2;
        smallCage = new Cage<>(size, smallDim.toString(), mZoo);
    }

    @DisplayName("Совместимость клетки и животного одной категории")
    @Test
    public void shouldCheckIsCompatibilityActual() {
        assertSame(smallAnimal1.suitableDim, smallCage.dim);
        LOG.info("Клетка размера {} и животное размера {} совместимы", smallAnimal1.suitableDim.toString(), smallCage.dim.toString());
    }

    @DisplayName("Наличие животного в клетке после добавления")
    @Test
    public void shouldFindAddedAnimal() {
        smallCage.addAnimal(smallAnimal1);
        assertTrue(smallCage.cageContents.containsValue(smallAnimal1));
    }

    @DisplayName("Невозможность повторного добавления уже запертого в клетку животного")
    @Test
    public void shouldDeclineCagedAnimalAddition() {
        Map values1, values2;
        smallCage.addAnimal(smallAnimal1);
        values1 = smallCage.cageContents;
        smallCage.addAnimal(smallAnimal1);
        values2 = smallCage.cageContents;
        assertEquals(values1, values2);
    }

    @DisplayName("Невозможность добавить животного в заполненную клетку")
    @Test
    public void shouldStopAnimalAdditionIfFull() {
        Map values1, values2;
        smallCage.addAnimal(smallAnimal1);
        values1 = smallCage.cageContents;
        smallCage.addAnimal(smallAnimal2);
        values2 = smallCage.cageContents;
        assertEquals(values1, values2);
    }

}
