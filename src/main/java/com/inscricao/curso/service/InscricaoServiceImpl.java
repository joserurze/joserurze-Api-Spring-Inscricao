package com.inscricao.curso.service;

import com.inscricao.curso.dto.request.InscricaoRequestDto;
import com.inscricao.curso.dto.response.InscricaoResponseDto;
import com.inscricao.curso.entity.Inscricao;
import com.inscricao.curso.repository.InscricaoRepository;
import com.inscricao.curso.util.InscricaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class InscricaoServiceImpl implements InscricaoService {


    private final InscricaoRepository inscricaoRepository;

    private final InscricaoMapper inscricaoMapper;
    @Override
    public InscricaoResponseDto findById(Long id) {

        return inscricaoMapper.toInscricaoDto(returnInscricao(id));
    }
    @Override
    public List<InscricaoResponseDto> findAll() {

        return inscricaoMapper.toPessoaDto(inscricaoRepository.findAll());
    }

    @Override
    public InscricaoResponseDto register(InscricaoRequestDto inscricaoDto) {
        Inscricao inscricao = inscricaoMapper.toInscricao(inscricaoDto);
        return inscricaoMapper.toInscricaoDto(inscricaoRepository.save(inscricao));
    }

    @Override
    public InscricaoResponseDto update(Long id, InscricaoRequestDto inscricaoDto) {
        Inscricao inscricao = returnInscricao(id);
        inscricaoMapper.updateInscricaoData(inscricao, inscricaoDto);

        return inscricaoMapper.toInscricaoDto(inscricaoRepository.save(inscricao));
    }

    @Override
    public String delete(Long id) {
        inscricaoRepository.deleteById(id);
        return "Inscrição id: "+id+" excluida.";
    }

    private Inscricao returnInscricao(Long id){
        return inscricaoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Inscrição não encontrada na base de dados"));
    }
}
