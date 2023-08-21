package com.squad2.Locadoraveiculos.controllers;

import com.squad2.Locadoraveiculos.dtos.acessorioDto.CriarAcessorioDto;
import com.squad2.Locadoraveiculos.dtos.motoristaDto.CriarMotoristaDto;
import com.squad2.Locadoraveiculos.dtos.motoristaDto.LerMotoristaDto;
import com.squad2.Locadoraveiculos.models.Acessorio;
import com.squad2.Locadoraveiculos.services.AcessorioService;
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
@RequestMapping("api/acessorios")
@Tag(name = "Accessory", description = "Endpoints for Managing Accessories")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adds a new Accessory",
            description = "Adds a new Accessory by passing in a JSON or XML representation of the accessory!",
            tags = {"Accessory"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CriarMotoristaDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Acessorio> criar (@RequestBody CriarAcessorioDto acessorioDto) { return acessorioService.criarAcessorio(acessorioDto); }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds all Accessories", description = "Finds all Accessories",
            tags = {"Accessory"},
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
            })
    public ResponseEntity<List<Acessorio>> retornarTodos () { return acessorioService.retornarTodos(); }


    @GetMapping(value = "{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Finds a Accessory", description = "Finds a Accessory",
            tags = {"Accessory"},
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
    public ResponseEntity<?>  retornarPorId (@PathVariable Long id) { return acessorioService.retornaPorId(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Accessory",
            description = "Deletes a Accessory by passing in a JSON or XML representation of the acessory!",
            tags = {"Accessory"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletarPorId (@PathVariable Long id) { return acessorioService.deletarPorId(id); }

}
