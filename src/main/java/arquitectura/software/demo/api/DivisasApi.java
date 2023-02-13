package arquitectura.software.demo.api;

import arquitectura.software.demo.bl.DivisasBl;
import arquitectura.software.demo.dto.DivisasDto;
import arquitectura.software.demo.dto.DivisasRespDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<DivisasRespDto<DivisasDto>> obtain(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) throws Exception {
        DivisasDto divisasDto = divisasBl.convert(from, to, amount);
        DivisasRespDto<DivisasDto> responseDto = new DivisasRespDto<DivisasDto>(true, "Success", divisasDto);
        return ResponseEntity.ok(responseDto);
    }



}
