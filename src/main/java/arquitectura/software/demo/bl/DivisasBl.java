package arquitectura.software.demo.bl;

import arquitectura.software.demo.dto.DivisasDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class DivisasBl {

        public DivisasDto convert(String from, String to, BigDecimal amount) throws IOException {
            if(amount.compareTo(BigDecimal.ZERO) <= 0){
                throw new IllegalArgumentException("The change amount must be greater than 0 or equal to 0");
            }
            OkHttpClient client = new OkHttpClient().newBuilder().build();

            Request request = new Request.Builder()
                    .url("https://api.apilayer.com/exchangerates_data/convert?from=" + from + "&to=" + to + "&amount=" + amount)
                    .addHeader("apikey", "bOv9VzwtvbtNuPhxLT3oZ5Xat8qE8ufB")

                    .build();
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            System.out.println(result);

            ObjectMapper mapper = new ObjectMapper();
            DivisasDto divisasDto= mapper.readValue(result, DivisasDto.class);
            return divisasDto;
        }







}
