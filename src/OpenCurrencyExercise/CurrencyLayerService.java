package OpenCurrencyExercise;

import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class CurrencyLayerService implements ICurrencyLayerService{

    private ICurrencyLayerApi currencyLayerApi;
    private Retrofit retrofit;
    private String accessKey;

    public CurrencyLayerService(String accessKey)
    {
        this.accessKey = accessKey;
        this.retrofit = new Retrofit.Builder()
            .baseUrl("http://api.currencylayer.com")
            .build();
        this.currencyLayerApi = retrofit.create(ICurrencyLayerApi.class);
    }

    public String GetCurrentQuate(String quoteName)
    {
        var quate = GetAllQuotes().stream().filter(x->x.getQuatesName().contains(quoteName)).findFirst().get();
        System.out.println(quate.getQuatesValue());
        return quate.getQuatesValue();
    }
    @Override
    public ArrayList<QuotesModel> GetAllQuotes() {
        Call<ResponseBody> response = currencyLayerApi.getAllQuates(accessKey);
        ArrayList<QuotesModel> allQuates = new ArrayList<>();
        try {
            String responseBody = response.execute().body().string();
            JSONObject json = new JSONObject(responseBody);
            JSONObject quotes = json.getJSONObject("quotes");
            for (String key : quotes.keySet()
                 ) {
                allQuates.add(new QuotesModel(key, quotes.get(key).toString()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allQuates;
    }
}
