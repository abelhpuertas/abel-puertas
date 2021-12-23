package org.example.groups;

import org.example.participants.Participant;

import java.util.ArrayList;
import java.util.List;

public class WhatsappGroup implements ChattingGroup {
    private List<Participant> participants = new ArrayList<>();

    @Override
    /**
     * Adds a participant to the group.
     *
     * @param participant
     */
    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }

    @Override
    public void removeParticipant(Participant participant) {
        this.participants.remove(participant);
    }

    @Override
    public void messageSent(Participant whoSent, String message) {
        this.participants.stream().forEach(whatsappParticipant -> {
            if (whatsappParticipant != whoSent) {
                whatsappParticipant.alert(whoSent, message);
            }
        });
    }

    @Override
    public List<Participant> getParticipants() {
        return this.participants;
    }
}
