package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Integer> serials;

    private ArrayList<Instrument> instrumentsList = new ArrayList<>();

    public void add(Instrument i) {
        Instrument.serialNum++;
        instrumentsList.add(i);
    }

    public Instrument get(int serial) {
        return serial > Instrument.serialNum ? null : instrumentsList.get(serial);
    }

    public List<Integer> allSerials() {
        serials = new ArrayList<>(instrumentsList.size());

        for (int i = 0; i < instrumentsList.size(); i++) {
            serials.add(i);
        }
        return serials;
    }

    public List<Integer> guitarsOfType(Type t) {// FIXME: 08/05/2021
        List<Integer> serialsOfType = new ArrayList<>();

        return serialsOfType;
    }

    public void sell(int serial) throws MusicShopException { // FIXME: 08/05/2021 
        for (int i = 0; i < instrumentsList.size(); i++) {
            if (instrumentsList.get(i).getSerial() == serial) {
                instrumentsList.remove(i);
            }
        }
        throw new MusicShopException("The instrument is not available");
    }

    public int sellAll(int[] serials) {// FIXME: 08/05/2021 
        for (int i = 0; i < serials.length; i++) {
            try {
                sell(i);
            } catch (MusicShopException e) {
                i++;
            }
        }
        return instrumentsList.size();
    }
}

