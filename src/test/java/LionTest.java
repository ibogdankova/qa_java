
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LionTest {

    @Test
    void testGetFood() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predator);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    void testGetKittens() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testInvalidSex() {
        Predator predator = Mockito.mock(Predator.class);
        assertThrows(Exception.class, () -> new Lion("Неизвестный", predator));
    }
}