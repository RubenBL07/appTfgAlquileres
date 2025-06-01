package com.tfg.appAlquileres.mappers;

import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.dtos.ReservaDTO;
import com.tfg.appAlquileres.enums.EstadoReserva;
import com.tfg.appAlquileres.models.Herramienta;
import com.tfg.appAlquileres.models.Reserva;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-01T09:55:50+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public ReservaDTO toDto(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        Long id = null;
        LocalDateTime fechaInicio = null;
        LocalDateTime fechaFin = null;
        BigDecimal precioTotal = null;
        EstadoReserva estado = null;
        HerramientaDTO herramienta = null;

        id = reserva.getId();
        fechaInicio = reserva.getFechaInicio();
        fechaFin = reserva.getFechaFin();
        precioTotal = reserva.getPrecioTotal();
        estado = reserva.getEstado();
        herramienta = herramientaToHerramientaDTO( reserva.getHerramienta() );

        ReservaDTO reservaDTO = new ReservaDTO( id, fechaInicio, fechaFin, precioTotal, estado, herramienta );

        return reservaDTO;
    }

    @Override
    public List<ReservaDTO> toDtoList(List<Reserva> reservas) {
        if ( reservas == null ) {
            return null;
        }

        List<ReservaDTO> list = new ArrayList<ReservaDTO>( reservas.size() );
        for ( Reserva reserva : reservas ) {
            list.add( toDto( reserva ) );
        }

        return list;
    }

    protected HerramientaDTO herramientaToHerramientaDTO(Herramienta herramienta) {
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
