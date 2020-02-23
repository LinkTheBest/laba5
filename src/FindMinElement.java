import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class FindMinElement {

    public Deque<SpaceMarine> makeDecision(List<SpaceMarine> input_deque) {
        List<SpaceMarine> temp_list = input_deque;
        SpaceMarine new_object = temp_list.get(input_deque.size() - 1);
        SpaceMarine temp_object = null;
        temp_list.remove(input_deque.size() - 1);
        int max_id = 9999;
        for (SpaceMarine spc : temp_list) {
            if (spc.getId() < max_id) {
                max_id = spc.getId();
                temp_object = spc;
            }
        }
        try {
            if (temp_object.getId() > new_object.getId()) {
                input_deque.add(new_object);
                System.out.println("Объект был добавлен");
            } else {
                System.out.println("Объект не был добавлен");
            }
        } catch (Exception e) {
        }
        Deque<SpaceMarine> temp_deque = new ArrayDeque<>(temp_list);
        return temp_deque;
    }
}

