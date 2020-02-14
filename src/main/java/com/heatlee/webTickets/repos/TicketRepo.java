package com.heatlee.webTickets.repos;

import com.heatlee.webTickets.model.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepo extends CrudRepository<Ticket, Long> {
    List<Ticket> findByGenre(String genre);

    List<Ticket> findByBeginsAt(String beginsAt);

    List<Ticket> findByDate(String date);

    List<Ticket> findByDuration(double duration);

    List<Ticket> findByRating(String rating);

    List<Ticket> findByName(String name);
}
