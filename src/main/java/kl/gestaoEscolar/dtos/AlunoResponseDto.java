package kl.gestaoEscolar.dtos;

import kl.gestaoEscolar.enums.Perfil;

public record AlunoResponseDto(
        Long id,
        String nome,
        String email,
        Perfil perfil
) { }
