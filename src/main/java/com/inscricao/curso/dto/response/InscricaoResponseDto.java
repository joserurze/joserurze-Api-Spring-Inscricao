package com.inscricao.curso.dto.response;

import com.inscricao.curso.entity.Inscricao;
import lombok.Getter;

@Getter
public class InscricaoResponseDto {

    private long id;
    private String nome;
    private String endereco;
    private String rg;
    private String cpf;

    public InscricaoResponseDto(Inscricao inscricao) {
        this.id = inscricao.getId();
        this.nome = inscricao.getNome();
        this.endereco = inscricao.getEndereco();
        this.rg = inscricao.getRg();
        this.cpf = inscricao.getCpf();
    }
}
