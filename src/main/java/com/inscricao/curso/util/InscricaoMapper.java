package com.inscricao.curso.util;

import com.inscricao.curso.dto.request.InscricaoRequestDto;
import com.inscricao.curso.dto.response.InscricaoResponseDto;
import com.inscricao.curso.entity.Inscricao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InscricaoMapper {

    public Inscricao toInscricao(InscricaoRequestDto inscricaoDto){
        // funcao vai pegar a entidade(classe que representa a tabela no banco)
        // Inscricao e converter em dto(uma classe simples com apenas as informações necessárias)
        return Inscricao.builder()
                .nome(inscricaoDto.getNome())
                .endereco(inscricaoDto.getEndereco())
                .rg(inscricaoDto.getRg())
                .cpf(inscricaoDto.getCpf())
                .build();
    }
    public InscricaoResponseDto toInscricaoDto(Inscricao inscricao){
        //função vai pegar o Dto e converter em entidade
        return new InscricaoResponseDto(inscricao);
    }

    public List<InscricaoResponseDto> toPessoaDto(List<Inscricao> pessoaList){
        //função converte uma lista de pessoas Entidade para uma lista de pessoa Dto
        return pessoaList.stream().map(InscricaoResponseDto::new).collect(Collectors.toList());
    }

    public void updateInscricaoData(Inscricao inscricao, InscricaoRequestDto inscricaoDto){

        inscricao.setNome(inscricaoDto.getNome());
        inscricao.setEndereco(inscricaoDto.getEndereco());
        inscricao.setRg(inscricaoDto.getRg());
        inscricao.setCpf(inscricaoDto.getCpf());

    }
}

