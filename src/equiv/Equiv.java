package equiv;

import java.util.*;

public class Equiv<E> {

    private List<Set<E>> listOfSets = new ArrayList<>();

    public void add(E e1, E e2) {
        int e1Found = -1;
        int e2Found = -1;

        if (listOfSets.size() == 0) {
            listOfSets.add(new HashSet<>());
            listOfSets.get(0).add(e1);
            listOfSets.add(new HashSet<>());
            listOfSets.get(1).add(e2);
        }

        for (int i = 0; i < listOfSets.size(); i++) {
            if (listOfSets.get(i).contains(e1)) {
                e1Found = i;
            }
            if (listOfSets.get(i).contains(e2)) {
                e2Found = i;
            }
        }
        if (e1Found == -1 && e2Found == -1) {
            listOfSets.add(new HashSet<>(Arrays.asList(e1, e2)));
        }

        if (e1Found == -1) {
            listOfSets.add(new HashSet<>(Collections.singletonList(e1)));
        }
        if (e2Found == -1) {
            listOfSets.add(new HashSet<>(Collections.singletonList(e2)));
        }
        if (e1Found != e2Found) {
            listOfSets.get(e1Found).addAll(listOfSets.get(e2Found));
            listOfSets.remove(listOfSets.get(e2Found));
        }
    }

    public boolean are(E e1, E e2) {
        for (Set<E> listOfSet : listOfSets) {
            if (listOfSet.contains(e1) && listOfSet.contains(e2)) {
                return true;
            }
        }
        return false;
    }
}
