package OpenCurrencyExercise;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.net.http.HttpResponse;

public interface ICurrencyLayerApi {

    @GET("/api/live")
    Call<ResponseBody> getAllQuates(@Query("access_key") String accessKey);
}
