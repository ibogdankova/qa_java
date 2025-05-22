import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Параметризованные тесты для проверки поведения львов в зависимости от пола
 */
public class LionParamTest {


    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveMane_shouldReturnCorrectValueBasedOnSex(String sex, boolean expectedHasMane) throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedHasMane, lion.doesHaveMane(),
                String.format("Для пола '%s' наличие гривы должно быть %s", sex, expectedHasMane));
    }
}
