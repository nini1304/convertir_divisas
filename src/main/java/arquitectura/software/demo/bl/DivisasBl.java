package arquitectura.software.demo.bl;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DivisasBl {
    public void convert() throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://v6.exchangerate-api.com/v6/26a1cc4fdf14bd24fff3d3f4/pair/USD/EUR/1000")
               // .addHeader("","")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());



    }



}
