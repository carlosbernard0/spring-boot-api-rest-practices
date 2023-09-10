package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.MedicoEntity;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new MedicoEntity(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedicos::new);
    }
    //PAGINACAO size= page=
    //ORDENACAO sort=nome
}
