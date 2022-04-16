package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private final TicketRepository repository = new TicketRepository();
    private final TicketManager manager = new TicketManager(repository);

    private final Ticket firstTicket = new Ticket(1, 100, "LED", "DME", 120);
    private final Ticket secondTicket = new Ticket(2, 600, "SCH", "MOI", 240);
    private final Ticket thirdTicket = new Ticket(3, 300, "DME", "LED", 125);
    private final Ticket forthTicket = new Ticket(4, 150, "VNZ", "LED", 180);
    private final Ticket fifthTicket = new Ticket(5, 700, "VNZ", "LED", 180);
    private final Ticket sixthTicket = new Ticket(6, 200, "SCH", "MOI", 240);

    @BeforeEach
    void add() {
        manager.add(firstTicket);
        manager.add(secondTicket);
        manager.add(thirdTicket);
        manager.add(forthTicket);
        manager.add(fifthTicket);
        manager.add(sixthTicket);
    }


    @Test
    void shouldTestNoTickets() {
        Ticket[] expect = new Ticket[0];
        Ticket[] actual = manager.findAllFromTo("NNA", "MOI");

        assertArrayEquals(expect, actual);
    }

    @Test
    void shouldFindOneTicket() {
        Ticket[] expect = new Ticket[]{thirdTicket};
        Ticket[] actual = manager.findAllFromTo("DME", "LED");

        assertArrayEquals(expect, actual);
    }

    @Test
    void shouldFindSeveralTicketsFromTo() {
        Ticket[] expect = new Ticket[]{sixthTicket, secondTicket};
        Ticket[] actual = manager.findAllFromTo("SCH", "MOI");

        assertArrayEquals(expect, actual);
    }

    @Test
    void shouldSortForPrice() {

        Ticket[] expect = new Ticket[]{firstTicket, forthTicket, sixthTicket, thirdTicket, secondTicket, fifthTicket};
        Ticket[] actual = new Ticket[]{firstTicket, secondTicket, thirdTicket, forthTicket, fifthTicket, sixthTicket};
        Arrays.sort(actual);

        assertArrayEquals(expect, actual);
    }


}