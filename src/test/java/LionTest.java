
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LionTest {

    /**
     * Проверяет, что метод getFood() возвращает корректный список еды для льва
     */

    @Test
    void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(feline).eatMeat();
    }

    /**
     * Проверяет, что метод getKittens() делегирует вызов объекту Feline
     */

    @Test
    void getKittensShouldDelegateToFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самка", feline);
        int result = lion.getKittens();
        assertEquals(2, result);
        verify(feline).getKittens();
    }

    /**
     * Проверяет, что конструктор Lion выбрасывает исключени при передаче невалидного значения пола
     */

    @Test
    void testInvalidSex() {
        Feline feline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Неизвестный", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    /**
     * Проверяет, что метод doesHaveMane() возвращает true для самцов
     */

    @Test
    void doesHaveManeShouldReturnTrueForMale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    /**
     * Проверяет, что метод doesHaveMane() возвращает false для самок
     */

    @Test
    void doesHaveManeShouldReturnFalseForFemale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }
}