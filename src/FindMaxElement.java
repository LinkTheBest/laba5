import java.util.ArrayDeque;

public class FindMaxElement {

    public ArrayDeque<SpaceMarine> findMax(ArrayDeque<SpaceMarine> input_deque){
        Object max_obj = null;
        int max_id = 0;
        for(SpaceMarine spc: input_deque){
            if (spc.getId() > max_id){
                max_obj = spc;
                max_id = spc.getId();
            }

        }
        return input_deque;
    }
}
