package apiCEP;

import okhttp3.Address;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CEPService {
    @GET("81260000/json/")
    Call<Address> getFullAddress();
}
