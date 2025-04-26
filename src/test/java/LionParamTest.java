import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Параметризованный тест для проверки наличия гривы у львов */

public class LionParamTest {

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testDoesHaveMane(String sex) throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, predator);

        if ("Самец".equals(sex)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }
    }
}
