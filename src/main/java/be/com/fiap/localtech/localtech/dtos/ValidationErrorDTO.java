package be.com.fiap.localtech.localtech.dtos;

import java.util.List;

public record ValidationErrorDTO(List<String> errors, int status) {

}
