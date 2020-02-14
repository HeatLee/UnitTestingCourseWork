package com.heatlee.webTickets.controller;

import com.heatlee.webTickets.exception.NullStringDataException;
import com.heatlee.webTickets.model.entity.Ticket;
import com.heatlee.webTickets.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {
    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping("/catalog")
    public String main(
            @RequestParam(required = false, defaultValue="") String filter,
            @RequestParam(required = false, defaultValue="") String deleteTag,
            Model model
    ) {
        Iterable<Ticket> tickets;

        if (deleteTag != null && !deleteTag.isEmpty()) {
            if (deleteTag.equals("all")) {
                ticketRepo.deleteAll();
            } else {
                Iterable<Ticket> rem = ticketRepo.findByName(deleteTag);
                for (Ticket t : rem) {
                    ticketRepo.delete(t);
                }
            }
        }

        tickets = ticketRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            tickets = ticketRepo.findByName(filter);
        }

        model.addAttribute("tickets", tickets);
        model.addAttribute("filter", filter);
        return "catalog";
    }

    @PostMapping("/catalog")
    public String add(
            @RequestParam String name,
            @RequestParam String genre,
            @RequestParam String rating,
            @RequestParam String duration,
            @RequestParam String beginsAt,
            @RequestParam String date,
            Model model
    ) {

        Ticket ticket = new Ticket();
        boolean flag = false;
        try {
            if (
            ticket.setDate(date) &
            ticket.setBeginsAt(beginsAt)&
            ticket.setDuration(duration) &
            ticket.setGenre(genre) &
            ticket.setRating(rating) &
            ticket.setName(name)
            ) {
                flag = true;
            }
        } catch (NullStringDataException e) {
            model.addAttribute("exception", e.getMessage());
            ticket = null;
        }


        if (flag) {
            ticketRepo.save(ticket);
            model.addAttribute("addMessage", "New ticket was added.");
        } else {
            model.addAttribute("addMessage", "Data is invalid. New ticket wasn't added.");
            ticket = null;
        }
        model.addAttribute("tickets", ticketRepo.findAll());
        return "catalog";
    }
}
