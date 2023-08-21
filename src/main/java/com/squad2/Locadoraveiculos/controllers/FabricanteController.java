package com.squad2.Locadoraveiculos.controllers;

import com.squad2.Locadoraveiculos.dtos.fabricanteDto.CriarFabricanteDto;
import com.squad2.Locadoraveiculos.dtos.motoristaDto.MotoristaDto;
import com.squad2.Locadoraveiculos.models.Fabricante;
import com.squad2.Locadoraveiculos.services.FabricanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/fabricantes")
@Tag(name = "Producer", description = "Endpoints for Managing Producers")
public class FabricanteController {
    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adds a new Producer",
            description = "Adds a new Producer by passing in a JSON or XML representation of the producer!",
            tags = {"Producer"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = MotoristaDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Fabricante>  cadastrar (@RequestBody CriarFabricanteDto fabricanteDto){ return fabricanteService.criarFabricante(fabricanteDto);}

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds all Producers", description = "Finds all Producers",
            tags = {"Producer"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = MotoristaDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<List<Fabricante>> retornar () {
       return fabricanteService.retornar();
   }

   @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds a Producer", description = "Finds a Producer",
            tags = {"Producer"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = MotoristaDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity <?> retornarPorId (@PathVariable Long id){
       return fabricanteService.retornarPorId(id);
   }

   @DeleteMapping("/{id}")
   @Operation(summary = "Deletes a Producer",
           description = "Deletes a Producer by passing in a JSON or XML representation of the producer!",
           tags = {"Producer"},
           responses = {
                   @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                   @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                   @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                   @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                   @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
           }
   )
    public ResponseEntity<?> deletePorId(@PathVariable Long id){
        return fabricanteService.deletarPorId(id);
   }
}
