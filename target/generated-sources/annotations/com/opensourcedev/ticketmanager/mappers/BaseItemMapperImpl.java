package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.BaseItemDto;
import com.opensourcedev.ticketmanager.model.items.BaseItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-20T18:47:56+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class BaseItemMapperImpl implements BaseItemMapper {

    @Override
    public BaseItemDto baseItemToBaseItemDto(BaseItem baseItem) {
        if ( baseItem == null ) {
            return null;
        }

        BaseItemDto baseItemDto = new BaseItemDto();

        baseItemDto.setItemStatus( baseItem.getItemStatus() );
        baseItemDto.setCreatedAt( baseItem.getCreatedAt() );
        baseItemDto.setUpdatedAt( baseItem.getUpdatedAt() );
        baseItemDto.setClosedAt( baseItem.getClosedAt() );
        baseItemDto.setIncidentSolver( baseItem.getIncidentSolver() );
        baseItemDto.setUser( baseItem.getUser() );

        return baseItemDto;
    }

    @Override
    public BaseItem baseItemDtoToBaseItem(BaseItemDto baseItemDto) {
        if ( baseItemDto == null ) {
            return null;
        }

        BaseItem baseItem = new BaseItem();

        baseItem.setItemStatus( baseItemDto.getItemStatus() );
        baseItem.setCreatedAt( baseItemDto.getCreatedAt() );
        baseItem.setUpdatedAt( baseItemDto.getUpdatedAt() );
        baseItem.setClosedAt( baseItemDto.getClosedAt() );
        baseItem.setIncidentSolver( baseItemDto.getIncidentSolver() );
        baseItem.setUser( baseItemDto.getUser() );

        return baseItem;
    }
}
