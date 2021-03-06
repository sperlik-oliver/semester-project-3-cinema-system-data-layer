package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.DTO.TicketDTO;
import crud.packages.model.Entities.Employee;
import crud.packages.model.Entities.Play;
import crud.packages.model.Entities.Ticket;
import crud.packages.repository.EmployeeRepository;
import crud.packages.repository.PlayRepository;
import crud.packages.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    PlayRepository playRepository;
    @Autowired
    EmployeeRepository employeeRepository;




    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets () {
        return ResponseEntity.ok().body(ticketRepository.findAll());
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicket (@PathVariable(value = "id") Long ticketId) throws ResourceNotFoundException {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow( () -> new ResourceNotFoundException("Ticket not found for this id :: " + ticketId));
        return ResponseEntity.ok().body(ticket);
    }

    @PostMapping("/ticket/create")
    public ResponseEntity<Ticket> createTicket (@Valid @RequestBody TicketDTO ticketDTO) throws ResourceNotFoundException {
        Play play = playRepository.findById(ticketDTO.getPlayId())
                .orElseThrow( () -> new ResourceNotFoundException("Play not found for this id :: " + ticketDTO.getPlayId()));
        Employee employee = employeeRepository.findById(ticketDTO.getEmployeeId())
                .orElse(null);
        Ticket ticket = new Ticket();
        ticket.setColumn(ticketDTO.getColumn());
        ticket.setRow(ticketDTO.getRow());
        ticket.setPlay(play);
        ticket.setEmployee(employee);
        ticketRepository.save(ticket);
        return ResponseEntity.ok().body(ticket);
    }

    @PutMapping("/ticket/edit/{id}")
    public ResponseEntity<Ticket> editTicket (@PathVariable(value = "id") Long ticketId, @Valid @RequestBody TicketDTO ticketDetails) throws ResourceNotFoundException {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow ( () -> new ResourceNotFoundException("Ticket not found for this id :: " + ticketId));
        Employee employee = employeeRepository.findById(ticketDetails.getEmployeeId())
                .orElse(null);
        Play play = playRepository.findById(ticketDetails.getPlayId())
                .orElse(null);
        ticket.setRow(ticketDetails.getRow());
        ticket.setColumn(ticketDetails.getColumn());
        ticket.setPlay(play);
        ticket.setEmployee(employee);
        final Ticket updatedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok().body(updatedTicket);
    }

    @DeleteMapping("/ticket/delete/{id}")
    public ResponseEntity<Boolean> deleteTicket (@PathVariable(value = "id") Long ticketId) throws ResourceNotFoundException {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow( () -> new ResourceNotFoundException("Ticket not found for this id :: " + ticketId));
        ticketRepository.delete(ticket);
        return ResponseEntity.ok().body(true);
    }
    
}
