package com.br.gov.sp.fatec.RepositorioDoBem.Controller.Service;

import com.br.gov.sp.fatec.RepositorioDoBem.Model.Domain.Alimento;
import com.br.gov.sp.fatec.RepositorioDoBem.Model.Repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public ResponseDTO saveAlimento(Alimento alimento) {
        ResponseDTO res = new ResponseDTO();
        
        Alimento savedAlimento = alimentoRepository.save(alimento);
        
        if (savedAlimento != null) {
            res.setResponseData(savedAlimento);
            res.setResponseBoolean(true);
        } else {
            res.setResponseBoolean(false);
        }
        
        return res;
    }

    public Alimento getAlimento(String alimentoId) {
        return alimentoRepository.findById(alimentoId)
                .orElseThrow(() -> new RuntimeException("Alimento não encontrado com id: " + alimentoId));
    }

    public Alimento updateAlimento(Alimento alimento, String alimentoId) {
        alimento.setAlimentoId(alimentoId);
        return alimentoRepository.save(alimento);
    }
    
    public void deleteAlimento(String alimentoId) {
        alimentoRepository.deleteById(alimentoId);
    }

    public List<Alimento> getAllAlimentos(){
        return alimentoRepository.findAll();
    }
}
