package com.squad2.Locadoraveiculos.controllers;

import com.squad2.Locadoraveiculos.dtos.FuncionarioDto;
import com.squad2.Locadoraveiculos.dtos.MotoristaDto;
import com.squad2.Locadoraveiculos.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adds a new Driver",
            description = "Adds a new Driver by passing in a JSON or XML representation of the driver!",
            tags = {"Driver"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = FuncionarioDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<FuncionarioDto> cadastrarFuncionario(@RequestBody FuncionarioDto funcionario){
        var funcionarioCadastrado = funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCadastrado);
    }






}
