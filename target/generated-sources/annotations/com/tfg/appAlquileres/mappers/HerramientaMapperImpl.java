package com.tfg.appAlquileres.mappers;

import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.models.Herramienta;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-01T09:55:50+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class HerramientaMapperImpl implements HerramientaMapper {

    @Override
    public Herramienta toEntity(HerramientaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Herramienta herramienta = new Herramienta();

        herramienta.setId( dto.id() );
        herramienta.setNombre( dto.nombre() );
        herramienta.setDescripcion( dto.descripcion() );
        herramienta.setPrecioDia( dto.precioDia() );
        herramienta.setDisponible( dto.disponible() );
        herramienta.setCategoria( dto.categoria() );
        herramienta.setImagenUrl( dto.imagenUrl() );

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
