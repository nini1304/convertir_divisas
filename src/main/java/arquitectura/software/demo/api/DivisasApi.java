package arquitectura.software.demo.api;

import arquitectura.software.demo.bl.DivisasBl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController

@RequestMapping("/api/v1/diviapi")
public class DivisasApi {
    private DivisasBl divisasBl;

    public DivisasApi(DivisasBl divisasBl) {
        this.divisasBl = divisasBl;
    }

    @GetMapping ("/convertion")
    public String convertion(@RequestHeader Map<String, String> headers)throws Exception{

        divisasBl.convert();

        return "hola";
    }



}
