import OpenCurrencyExercise.CurrencyLayerService;
import OpenCurrencyExercise.QuotesModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyApiExerciseTests {

    @Test
    public void ShouldReturnAllQuates()
    {
        CurrencyLayerService currencyLayerService = new CurrencyLayerService("980b4fe950b3d8d23a5a6eef697865af");
        ArrayList<QuotesModel> quotes = currencyLayerService.GetAllQuotes();
        assertNotNull(quotes);
        assertTrue(!quotes.stream().findAny().isEmpty());
    }

    @Test
    public void ShouldReturnAllQuatesNamesAndValues()
    {
        CurrencyLayerService currencyLayerService = new CurrencyLayerService("980b4fe950b3d8d23a5a6eef697865af");
        ArrayList<QuotesModel> quotes = currencyLayerService.GetAllQuotes();
        assertNotNull(quotes);
        for (QuotesModel quate:quotes
             ) {

            assertNotNull(quate.getQuatesName());
            assertNotNull(quate.getQuatesValue());
        }
    }
    @Test
    public void ShouldReturnUSDQuate()
    {
        CurrencyLayerService currencyLayerService = new CurrencyLayerService("980b4fe950b3d8d23a5a6eef697865af");
        String actualValue = currencyLayerService.GetCurrentQuate("USD");
        assertNotNull(actualValue);
    }
}
