package org.example.participants;

public class WhatsappParticipant extends Participant {


    private WhatsappParticipant(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public static WhatsappParticipant create(String name, String phone) {
        return new WhatsappParticipant(name, phone);
    }

    @Override
    public void alert(Participant sender, String message) {
        System.out.println(
                String.format("%s Tienes una nueva notificación: \n %s te envió un nuevo mensaje: %s\n\n", this.name, sender.getName(), message)
        );
    }
}
