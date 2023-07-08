package br.com.tcc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "com")
public class AuthResponseDTO {

    private String tokenJwt;

    private List<String> roles = new ArrayList<>();

    private String message = "";
}
