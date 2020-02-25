import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LowerRemover {

    public Deque<SpaceMarine> removeLowerElement(List<SpaceMarine> input_deque) {
        List<SpaceMarine> temp_list = input_deque;
        SpaceMarine last_added_element = temp_list.get(input_deque.size() - 1);
        for (SpaceMarine spc : temp_list) {
            if (spc.getId() < last_added_element.getId()) {
                temp_list.remove(spc);
            }
        }
        Deque<SpaceMarine> temp_deque = new ArrayDeque<>(temp_list);
        return temp_deque;
    }

}
