package com.inscricao.curso.service;

import com.inscricao.curso.dto.request.InscricaoRequestDto;
import com.inscricao.curso.dto.response.InscricaoResponseDto;

import java.util.List;

public interface InscricaoService {
    InscricaoResponseDto findById(Long id);
    List<InscricaoResponseDto> findAll();
    InscricaoResponseDto register(InscricaoRequestDto inscricaoDto);
    InscricaoResponseDto update(Long id, InscricaoRequestDto inscricaoDto);
    String delete(Long id);
}
