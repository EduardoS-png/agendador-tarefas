package com.eduardo.agendadortarefas.business.mapper;

import com.eduardo.agendadortarefas.business.dto.TarefasDTO;
import com.eduardo.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
