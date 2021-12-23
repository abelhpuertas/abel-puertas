package org.example;


import org.example.groups.WhatsappGroup;
import org.example.participants.WhatsappParticipant;

public class WhatsappGroupsApplication {
    public static void main(String[] args) {

        WhatsappGroup group = new WhatsappGroup();

        //filling group with some participants...
        WhatsappParticipant abel = WhatsappParticipant.create("Abel", "12345");
        WhatsappParticipant valeria = WhatsappParticipant.create("Valeria", "12345");
        WhatsappParticipant marcos = WhatsappParticipant.create("Marcos", "12345");
        group.addParticipant(abel);
        group.addParticipant(valeria);
        group.addParticipant(marcos);

        //send a message and alert participants!
        group.messageSent(valeria, "Hola! Cómo estan?");
    }
}
