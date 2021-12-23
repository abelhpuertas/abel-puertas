package org.example.groups;

import org.example.participants.Participant;

import java.util.List;

public interface ChattingGroup {
    /**
     * Adds a participant to the group.
     *
     * @param participant
     */
    void addParticipant(Participant participant);

    /***
     * Removes participant from the group.
     * @param participant
     */
    void removeParticipant(Participant participant);

    /***
     * Indicates that a participant sent a message to the group. Alerts the rest of the participants
     * @param whoSent
     * @param message
     */
    void messageSent(Participant whoSent, String message);

    /***
     * Return the list of the participants.
     * @return
     */
    List<Participant> getParticipants();
}
