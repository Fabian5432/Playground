import OpenCurrencyExercise.CurrencyLayerService;
import OpenCurrencyExercise.QuotesModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyApiExerciseTests {

    @Test
    public void ShouldReturnAllQuates()
    {
        CurrencyLayerService Sut = new CurrencyLayerService("980b4fe950b3d8d23a5a6eef697865af");
        ArrayList<QuotesModel> quotes =  Sut.GetAllQuotes();
        assertNotNull(quotes);
        assertTrue(!quotes.stream().findAny().isEmpty());
    }
}
