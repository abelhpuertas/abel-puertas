package org.example.participants;

public abstract class Participant {

    protected String name;
    protected String phone;


    public String getName() {
        return this.name;
    }


    public String getPhone() {
        return this.phone;
    }

    public abstract void alert(Participant sender, String message);
}
