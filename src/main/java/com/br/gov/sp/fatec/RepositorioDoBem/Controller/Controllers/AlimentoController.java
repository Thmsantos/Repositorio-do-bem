package com.br.gov.sp.fatec.RepositorioDoBem.Controller.Controllers;

import com.br.gov.sp.fatec.RepositorioDoBem.Controller.Service.ResponseDTO;
import com.br.gov.sp.fatec.RepositorioDoBem.Model.Domain.Alimento;
import com.br.gov.sp.fatec.RepositorioDoBem.Controller.Service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @PostMapping("/saveAlimento")
    public ResponseEntity<ResponseDTO> saveAlimento(@RequestBody Alimento alimento) {
        ResponseDTO response = alimentoService.saveAlimento(alimento);
        
        if (response.getResponseBoolean()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(400).body(response); 
        }
    }

    @GetMapping("/getAlimento/{alimentoId}")
    public Alimento getAlimento(@PathVariable String alimentoId) {
            return alimentoService.getAlimento(alimentoId);
    }

    @GetMapping("/oi")
    public String getString() {
            return "oi";
    }

    @PutMapping("/updateAlimento/{alimentoId}")
    public Alimento updateAlimento(@RequestBody Alimento alimento, @PathVariable String alimentoId) {
        return alimentoService.updateAlimento(alimento, alimentoId);
    }

    @DeleteMapping("/deleteAlimento/{alimentoId}")
    public ResponseEntity<String> deleteAlimento(@PathVariable String alimentoId){
        alimentoService.deleteAlimento(alimentoId);
        return ResponseEntity.ok("Alimento Deletado com sucesso");
    }

    @GetMapping("/getAllAlimentos")
    public List<Alimento> getAllAlimentos(){
        return alimentoService.getAllAlimentos();
    }



}
