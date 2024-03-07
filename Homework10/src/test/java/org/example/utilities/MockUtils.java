package org.example.utilities;

import org.example.Models.HomeTask;
import org.example.Models.Task;
import org.example.Utils.EntityGenerators;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.utilities.MockConstants.*;

public class MockUtils {

    public static List<Task> generateTasksList(String type) {
        switch (type) {
            case TASK_TYPE:
                return generate(EntityGenerators.generateTask());
            case HOME_TASK_TYPE:
                return generate(EntityGenerators.generateHomeTask());
            case WORK_TASK_TYPE:
                return generate(EntityGenerators.generateWorkTask());
        }
        return null;
    }

    public static List<Task> generateRandomTasksList() {
        return IntStream.range(0, COUNT_OF_TASK_RANDOM_GEN)
                .mapToObj(i -> generateSingleTask(RANDOM.nextInt(3) + 1))
                .collect(Collectors.toList());

    }

    private static List<Task> generate(Supplier<? extends Task> method) {
        return IntStream.range(0, COUNT_OF_TASK_PER_REQUEST)
                .mapToObj(i -> method.get())
                .collect(Collectors.toList());
    }

    public static Task generateSingleTask(int type_value) {
        HomeTask test = null;
        switch (type_value) {
            case 1:
                return EntityGenerators.generateTask().get();
            case 2:
                test = EntityGenerators.generateHomeTask().get(); // --
            case 3:
                return EntityGenerators.generateWorkTask().get();
        }
        return test;
    }


}
