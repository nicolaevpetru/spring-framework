package com.ticketing.mapper;

import com.ticketing.dto.TaskDTO;
import com.ticketing.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Task convertToEntity(TaskDTO dto) {
        return modelMapper.map(dto, Task.class);
    }

    public TaskDTO convertToDto(Task entity) {
        return modelMapper.map(entity, TaskDTO.class);
    }
}
