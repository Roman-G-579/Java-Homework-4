package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Instrument> instrumentsList = new ArrayList<>();
    private int guitarCounter;

    //adds the instrument to the end of the list
    public void add(Instrument i) {
        instrumentsList.add(i);
        if (i instanceof Guitar) {
            guitarCounter++;
        }
    }

    //returns the instrument with the given serial number
    public Instrument get(int serial) {
        for (Instrument instrument : instrumentsList) {
            if (instrument.getSerial() == serial) {
                return instrument;
            }
        }
        return null;
    }

    //returns all the serial numbers in the store
    public List<Integer> allSerials() {
        List<Integer> serials = new ArrayList<>();
        for (Instrument instrument : instrumentsList) {
            serials.add(instrument.getSerial());
        }
        return serials;
    }

    //returns all the serial numbers of the chosen guitar type
    public List<Integer> guitarsOfType(Type t) {
        List<Integer> serialsOfType = new ArrayList<>();
        for (Instrument instrument : instrumentsList) {
            if (instrument instanceof Guitar) {
                if (((Guitar) instrument).getType().equals(t)) {
                    serialsOfType.add(instrument.getSerial());
                }
            }
        }
        return serialsOfType;
    }

    //sells the instrument corresponding to the given serial number
    public void sell(int serial) throws MusicShopException {
        Instrument instrumentToRemove = null;
        for (Instrument instrument : instrumentsList) {
            if (instrument.getSerial() == serial) {
                if (instrument instanceof Guitar) {
                    if (guitarCounter == 1) {
                        throw new MusicShopException("Last guitar, cannot sell it");
                    }
                    guitarCounter--;
                }
                instrumentToRemove = instrument;
            }
        }
        if (instrumentToRemove != null) {
            instrumentsList.remove(instrumentToRemove);
        } else {
            throw new MusicShopException("Instrument does not exist");
        }
    }

    //sells the entire stock and prints the number of failed sales
    public int sellAll(int[] serials) {
        int failedSales = 0;
        for (int serial : serials) {
            try {
                sell(serial);
            } catch (MusicShopException e) {
                failedSales++;
            }
        }
        return failedSales;
    }
}

