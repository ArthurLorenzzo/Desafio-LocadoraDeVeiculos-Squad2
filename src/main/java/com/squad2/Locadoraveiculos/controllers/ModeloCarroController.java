package com.squad2.Locadoraveiculos.controllers;

import com.squad2.Locadoraveiculos.dtos.modeloCarroDto.CriarModeloCarroDto;
import com.squad2.Locadoraveiculos.dtos.motoristaDto.CriarMotoristaDto;
import com.squad2.Locadoraveiculos.dtos.motoristaDto.LerMotoristaDto;
import com.squad2.Locadoraveiculos.services.ModeloCarroService;
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

@Controller
@RequestMapping("/api/modelos-carros")
@Tag(name = "Model", description = "Endpoints for Managing Models")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroService modeloCarroService;


    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adds a new Model",
            description = "Adds a new Model by passing in a JSON or XML representation of the model!",
            tags = {"Model"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CriarMotoristaDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> cadastrarModeloCarro(@RequestBody CriarModeloCarroDto modeloDto){
        return  modeloCarroService.criarModeloCarro(modeloDto);
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds all Models", description = "Finds all Models",
            tags = {"Model"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = LerMotoristaDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public  ResponseEntity<?> retornarTodosOsModelosCarro(){
        return  modeloCarroService.retornarTodosOsModelosCarro();
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds a Model", description = "Finds a Model",
            tags = {"Model"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LerMotoristaDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public  ResponseEntity<?> retornarModelosCarroPorId(@PathVariable(value = "id") Long id){
        var modeloRetornado = modeloCarroService.retornarModeloCarroPorid(id);
        return  ResponseEntity.status(HttpStatus.CREATED).body(modeloRetornado);
    }

}
