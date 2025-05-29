package com.tfg.appAlquileres.mappers;

import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.models.Herramienta;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-29T08:41:21+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class HerramientaMapperImpl implements HerramientaMapper {

    @Override
    public Herramienta toEntity(HerramientaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Herramienta herramienta = new Herramienta();

        herramienta.setCategoria( dto.categoria() );
        herramienta.setDescripcion( dto.descripcion() );
        herramienta.setDisponible( dto.disponible() );
        herramienta.setId( dto.id() );
        herramienta.setImagenUrl( dto.imagenUrl() );
        herramienta.setNombre( dto.nombre() );
        herramienta.setPrecioDia( dto.precioDia() );

        return herramienta;
    }

    @Override
    public HerramientaDTO toDto(Herramienta herramienta) {
        if ( herramienta == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String descripcion = null;
        BigDecimal precioDia = null;
        boolean disponible = false;
        String categoria = null;
        String imagenUrl = null;

        id = herramienta.getId();
        nombre = herramienta.getNombre();
        descripcion = herramienta.getDescripcion();
        precioDia = herramienta.getPrecioDia();
        disponible = herramienta.isDisponible();
        categoria = herramienta.getCategoria();
        imagenUrl = herramienta.getImagenUrl();

        HerramientaDTO herramientaDTO = new HerramientaDTO( id, nombre, descripcion, precioDia, disponible, categoria, imagenUrl );

        return herramientaDTO;
    }
}
