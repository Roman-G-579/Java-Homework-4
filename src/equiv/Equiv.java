package equiv;

import java.util.*;

public class Equiv<E> {

    private List<Set<E>> listOfSets = new ArrayList<>();

    public void add(E e1, E e2) {
        int e1Found = -1;
        int e2Found = -1;

        //if the list of sets is empty, create two new sets from the current elements
        if (listOfSets.size() == 0) {
            listOfSets.add(new HashSet<>());
            listOfSets.get(0).add(e1);
            listOfSets.add(new HashSet<>());
            listOfSets.get(1).add(e2);
        }

        //search the existing sets for the given elements
        for (int i = 0; i < listOfSets.size(); i++) {
            if (listOfSets.get(i).contains(e1)) {
                e1Found = i;
            }
            if (listOfSets.get(i).contains(e2)) {
                e2Found = i;
            }
        }
        //if both elements are new to the arraylist
        if (e1Found == -1 && e2Found == -1) {
            listOfSets.add(new HashSet<>(Arrays.asList(e1, e2)));
            return;
        }

        //if the second element is found but the first is not
        if (e1Found == -1) {
            listOfSets.get(e2Found).add(e1);
        }
        //if the first element is found but the second is not
        if (e2Found == -1) {
            listOfSets.get(e1Found).add(e2);
        }
        //if the indices of the elements are found and different,
        //adds one set to the other and removes the unnecessary set.
        if (e1Found != e2Found && (e1Found != -1 && e2Found != -1)) {
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
        return e1.equals(e2);
    }
}
