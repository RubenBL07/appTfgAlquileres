package com.tfg.appAlquileres.mappers;

import com.tfg.appAlquileres.dtos.ClienteDTO;
import com.tfg.appAlquileres.dtos.HerramientaDTO;
import com.tfg.appAlquileres.dtos.ReservaDTO;
import com.tfg.appAlquileres.enums.EstadoReserva;
import com.tfg.appAlquileres.models.Cliente;
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
    date = "2025-05-29T20:05:49+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO toDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String email = null;
        String password = null;
        String direccion = null;
        BigDecimal saldo = null;
        List<ReservaDTO> reservas = null;

        id = cliente.getId();
        nombre = cliente.getNombre();
        email = cliente.getEmail();
        password = cliente.getPassword();
        direccion = cliente.getDireccion();
        saldo = cliente.getSaldo();
        reservas = reservaListToReservaDTOList( cliente.getReservas() );

        ClienteDTO clienteDTO = new ClienteDTO( id, nombre, email, password, direccion, saldo, reservas );

        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> toDtoList(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toDto( cliente ) );
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

    protected ReservaDTO reservaToReservaDTO(Reserva reserva) {
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

    protected List<ReservaDTO> reservaListToReservaDTOList(List<Reserva> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservaDTO> list1 = new ArrayList<ReservaDTO>( list.size() );
        for ( Reserva reserva : list ) {
            list1.add( reservaToReservaDTO( reserva ) );
        }

        return list1;
    }
}
