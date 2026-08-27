package com.orto.logic.controller.mapper;

import java.util.List;

public interface Mapper <E, B> {
    B toBean (E entity);
    E toEntity(B bean);
    default List<B> toBeans(List<E> entities) {
        return entities.stream().map(this::toBean).toList();
    }
    default List<E> toEntities(List<B> beans) {
        return beans.stream().map(this::toEntity).toList();
    }
}
