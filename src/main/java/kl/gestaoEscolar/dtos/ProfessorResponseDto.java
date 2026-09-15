package kl.gestaoEscolar.dtos;
import kl.gestaoEscolar.enums.Perfil;

public record ProfessorResponseDto(
    //na resposta da API para o cliente é necessário ter id para que o cliente saiva que o id de tal registro
    //pertence a tal usuário, pois quando há uma resposta, o dados da requisição já passou pela entidade
    //que é a responsável por gerar um ID(@GeneratedValue) para cada registro.

    Long id,
    String nome,
    String email,
    Perfil perfil
) { }


