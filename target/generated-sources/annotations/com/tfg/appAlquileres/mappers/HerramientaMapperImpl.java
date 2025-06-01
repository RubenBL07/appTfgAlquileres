package com.tfg.appAlquileres.mappers;

import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.models.Herramienta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-01T12:51:28+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class HerramientaMapperImpl implements HerramientaMapper {

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
        boolean activa = false;

        id = herramienta.getId();
        nombre = herramienta.getNombre();
        descripcion = herramienta.getDescripcion();
        precioDia = herramienta.getPrecioDia();
        disponible = herramienta.isDisponible();
        categoria = herramienta.getCategoria();
        imagenUrl = herramienta.getImagenUrl();
        if ( herramienta.getActiva() != null ) {
            activa = herramienta.getActiva();
        }

        HerramientaDTO herramientaDTO = new HerramientaDTO( id, nombre, descripcion, precioDia, disponible, categoria, imagenUrl, activa );

        return herramientaDTO;
    }

    @Override
    public List<HerramientaDTO> toDtoList(List<Herramienta> herramientas) {
        if ( herramientas == null ) {
            return null;
        }

        List<HerramientaDTO> list = new ArrayList<HerramientaDTO>( herramientas.size() );
        for ( Herramienta herramienta : herramientas ) {
            list.add( toDto( herramienta ) );
        }

        return list;
    }
}
