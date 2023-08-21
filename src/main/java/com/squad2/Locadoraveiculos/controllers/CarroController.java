package com.squad2.Locadoraveiculos.controllers;

import com.squad2.Locadoraveiculos.dtos.carroDtos.CarroDto;
import com.squad2.Locadoraveiculos.dtos.carroDtos.LerCarroDto;
import com.squad2.Locadoraveiculos.services.CarroService;
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

@Controller
@RequestMapping("/api/carros")
@Tag(name = "Car", description = "Endpoints for Managing Cars")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adds a new Car",
            description = "Adds a new Car by passing in a JSON or XML representation of the car!",
            tags = {"Car"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CarroDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<CarroDto> cadastrarCarro (@RequestBody CarroDto carroDTO){
        var carroCriado = carroService.criarCarro(carroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroCriado);
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds all Cars", description = "Finds all Cars",
            tags = {"Car"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CarroDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<List<LerCarroDto>> retornarCarros (){
        var listaDeCarros = carroService.retornarTodosOsCarros();
        return ResponseEntity.status(HttpStatus.OK).body(listaDeCarros);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds a Car", description = "Finds a Car",
            tags = {"Car"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CarroDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<LerCarroDto> retornarCarroPorId (@PathVariable(value = "id") Long id){
        var carroRetornado = carroService.retornarCarroPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(carroRetornado);

    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletes a Car",
            description = "Deletes a Car by passing in a JSON or XML representation of the car!",
            tags = {"Car"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletarCarroPorId (@PathVariable(value = "id") Long id){
        carroService.deletarCarro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
