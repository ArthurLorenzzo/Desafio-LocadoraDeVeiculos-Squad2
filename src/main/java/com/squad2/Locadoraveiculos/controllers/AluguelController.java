package com.squad2.Locadoraveiculos.controllers;


import com.squad2.Locadoraveiculos.dtos.AluguelDto;
import com.squad2.Locadoraveiculos.dtos.MotoristaDto;
import com.squad2.Locadoraveiculos.services.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@Controller
@RequestMapping("/api/alugueis")
@Tag(name = "Rent", description = "Endpoints for Managing Rents")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adds a new Rent",
            description = "Adds a new Rent by passing in a JSON or XML representation of the rent!",
            tags = {"Rent"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AluguelDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public AluguelDto cadastrarAluguel (@RequestBody AluguelDto aluguelDto) {

        return aluguelService.criarAluguel(aluguelDto);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds a Rent", description = "Finds a Rent",
            tags = {"Rent"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AluguelDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public AluguelDto buscarAluguelById (@PathVariable(value = "id") Long id) {

        return aluguelService.retornarAlugueisById(id);

    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
            @Operation(summary = "Finds all Rents", description = "Finds all Rents",
            tags = {"Rent"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = AluguelDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<AluguelDto>> buscarTodosAlugueis () {

        List<AluguelDto> listaAluguelDto = aluguelService.retornarTodosAlugueis();
        return ResponseEntity.ok(listaAluguelDto);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Rent",
            description = "Deletes a Rent by passing in a JSON or XML representation of the rent!",
            tags = {"Rent"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletarAlugueis (@PathVariable(value = "id") Long id) {

        aluguelService.deletarAluguel(id);
        return ResponseEntity.noContent().build();

    }

}
