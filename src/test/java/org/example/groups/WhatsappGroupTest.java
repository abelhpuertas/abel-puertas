package org.example.groups;


import org.example.participants.WhatsappParticipant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WhatsappGroupTest {

    private WhatsappGroup whatsappGroup;


    @Before
    public void setup() {
        whatsappGroup = new WhatsappGroup();
    }

    @Test
    public void addingParticipantShouldAddTheNewOneToTheList() {
        Integer oldAmountOfParticipants = this.whatsappGroup.getParticipants().size();

        this.whatsappGroup.addParticipant(WhatsappParticipant.create("Abel", "1234567890"));

        assertEquals(oldAmountOfParticipants + 1, this.whatsappGroup.getParticipants().size());
    }

    @Test
    public void removingParticipantShouldEliminateFromTheList() {

        WhatsappParticipant WhatsappParticipantToBeDeleted = WhatsappParticipant.create("Abel", "1234567890");

        this.whatsappGroup.addParticipant(WhatsappParticipantToBeDeleted);
        Integer oldAmountOfContacts = this.whatsappGroup.getParticipants().size();

        this.whatsappGroup.removeParticipant(WhatsappParticipantToBeDeleted);

        assertEquals(oldAmountOfContacts - 1, this.whatsappGroup.getParticipants().size());
    }

    @Test
    public void gettingParticipantsShouldReturnTheCompleteList() {
        WhatsappParticipant abel = WhatsappParticipant.create("Abel", "1234567890");
        WhatsappParticipant marcos = WhatsappParticipant.create("Marcos", "0987654321");
        WhatsappParticipant valeria = WhatsappParticipant.create("Valeria", "1123581321");

        this.whatsappGroup.addParticipant(abel);
        this.whatsappGroup.addParticipant(marcos);
        this.whatsappGroup.addParticipant(valeria);

        assertEquals(3, this.whatsappGroup.getParticipants().size());

    }

    @Test
    public void sendingMessageShouldAlertToAllParticipantsButTheSender() {

        WhatsappParticipant abel = mock(WhatsappParticipant.class);
        WhatsappParticipant marcos = mock(WhatsappParticipant.class);
        WhatsappParticipant valeria = mock(WhatsappParticipant.class);

        this.whatsappGroup.addParticipant(abel);
        this.whatsappGroup.addParticipant(marcos);
        this.whatsappGroup.addParticipant(valeria);

        String message = "Hola buen día. Los pongo en contacto para que se conozcan.";

        this.whatsappGroup.messageSent(valeria, message);

        verify(abel, times(1)).alert(eq(valeria), eq(message));
        verify(marcos, times(1)).alert(eq(valeria), eq(message));
        verify(valeria, times(0)).alert(any(WhatsappParticipant.class), anyString());
    }
}
