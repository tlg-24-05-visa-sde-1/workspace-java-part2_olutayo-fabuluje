package com.entertainment;

import java.util.Objects;

public class Television {

    private String brand;
    private int volume;

    // Television HAS-A Tuner for all things related to the channel changing)
    private final Tuner tuner = new Tuner();


    public Television() {
        super();
    }

    public Television(String brand, int volume) {
        setBrand(brand);        // call to setters
        setVolume(volume);     // call to setters
    }


    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);   // delegate to the tuner
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode()  called");
        // whatever fields you use for .equals must be the same for hashcode
        // this is a poor hash function, because it easily yields "hash collisions"
        // a "hash collision" is when "different" objects happen to have the same hashcode (dumb luck)

        // this is a "scientifically correct" hash function, i.e.
        // it minimizes the probability of hash collisions
        return Objects.hashCode(getBrand()) + getVolume();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Television other = (Television) obj;
        return volume == other.volume && Objects.equals(this.getBrand(), other.brand);
    }

    /*    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // check that 'obj' is really referring to a Television object, then we proceed
        // if (obj instanceof Television) {  // IS-A check
        if (this.getClass() == obj.getClass()) {  // are we the EXACT SAME TYPE?
            // downcast 'obj' to more specific reference type Television, for getName(), getAge()
            Television other = (Television) obj;

            // do the checks: business equality is defined as brand, volume
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe check
            this.getVolume() == other.getVolume();                       // primitives can't be null
        }
        return result;

    }*/

    @Override
    public String toString() {
        return String.format("%s: brand=%s, volume-%s, currentChannel=%s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}
