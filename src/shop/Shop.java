package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private ArrayList<Instrument> instrumentsList = new ArrayList<>();
    private List<Integer> serials = new ArrayList<>();
    private int guitarCounter;

    public void add(Instrument i) {
        instrumentsList.add(i);
        if (i instanceof Guitar) {
            guitarCounter++;
        }
    }

    public Instrument get(int serial) {
        return serial > Instrument.serialNum ? null : instrumentsList.get(serial);
    }

    public List<Integer> allSerials() {
        for (Instrument instrument : instrumentsList) {
            serials.add(instrument.getSerial());
        }
        return serials;
    }

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

    public void sell(int serial) throws MusicShopException {

        for (Instrument instrument : instrumentsList) {
            if (instrument.getSerial() == serial) {
                if (instrumentsList.get(serial) instanceof Guitar) {
                    if (guitarCounter == 1) {
                        throw new MusicShopException("Last guitar, cannot sell it");
                    }
                    guitarCounter--;
                }
                instrumentsList.remove(serial);
                return;
            }
        }
        throw new MusicShopException("Instrument does not exist");
    }

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

