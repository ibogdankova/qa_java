
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LionTest {

    /**
     * Проверяет, что метод getFood() возвращает корректный список еды для льва,
     * соответствующий рациону хищника
     */

    @Test
    void testGetFood() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predator);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    void getKittensShouldReturnZeroForMaleLion() throws Exception {
        Predator mockPredator = Mockito.mock(Predator.class);
        Lion lion = new Lion("Самец", mockPredator);
        int result = lion.getKittens();
        assertEquals(0, result, "Для самца льва должно возвращаться 0 котят");
        if (mockPredator instanceof Feline) {
            Mockito.verify((Feline) mockPredator, Mockito.never()).getKittens();
        }
    }
    

    /*
     * Проверяет, что конструктор Lion выбрасывает исключение
     * при передаче невалидного значения пола
     */

    @Test
    void testInvalidSex() {
        Predator predator = Mockito.mock(Predator.class);
        assertThrows(Exception.class, () -> new Lion("Неизвестный", predator));
    }
}