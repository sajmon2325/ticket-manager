package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.BaseItemDto;
import com.opensourcedev.ticketmanager.model.items.BaseItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseItemMapper {

    BaseItemDto baseItemToBaseItemDto(final BaseItem baseItem);
    BaseItem baseItemDtoToBaseItem(final BaseItemDto baseItemDto);
}
