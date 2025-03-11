package io.github.orionlibs.simulator.arduino.core;

public class DigitalPin
{
    private final int pinNumber;
    private PinMode mode;
    private boolean value;


    public DigitalPin(int pinNumber)
    {
        this.pinNumber = pinNumber;
        this.mode = PinMode.INPUT;
        this.value = false;
    }


    public void setMode(PinMode mode)
    {
        this.mode = mode;
        if(mode == PinMode.INPUT_PULLUP)
        {
            this.value = true;
        }
        else if(mode == PinMode.INPUT)
        {
            this.value = false;
        }
    }


    public void writeValue(boolean value)
    {
        if(mode == PinMode.OUTPUT)
        {
            this.value = value;
        }
        else
        {
            throw new IllegalStateException("Cannot write to pin " + pinNumber + " as it is not configured as OUTPUT");
        }
    }


    public boolean readValue()
    {
        if(mode == PinMode.INPUT || mode == PinMode.INPUT_PULLUP)
        {
            return value;
        }
        else
        {
            throw new IllegalStateException("Cannot read from pin " + pinNumber + " as it is not configured as INPUT or INPUT_PULLUP");
        }
    }


    public void simulateInput(boolean value)
    {
        if(mode == PinMode.INPUT || mode == PinMode.INPUT_PULLUP)
        {
            this.value = value;
        }
        else
        {
            throw new IllegalStateException("Cannot simulate input on pin " + pinNumber + " as it is not configured as INPUT or INPUT_PULLUP");
        }
    }


    @Override
    public String toString()
    {
        return new StringBuilder().append("DigitalPin{pinNumber=")
                        .append(pinNumber)
                        .append(", mode=")
                        .append(mode)
                        .append(", value=")
                        .append((value ? "HIGH" : "LOW"))
                        .append("}")
                        .toString();
    }


    public int getPinNumber()
    {
        return pinNumber;
    }


    public PinMode getMode()
    {
        return mode;
    }
}
