package arquitectura.software.demo.exceptions;

import arquitectura.software.demo.dto.DivisasRespDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Exceptions {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DivisasRespDto> zeroException(IllegalArgumentException e) {
        DivisasRespDto responseDto = new DivisasRespDto(false, null, e.getMessage());
        return ResponseEntity.badRequest().body(responseDto);
    }
}
