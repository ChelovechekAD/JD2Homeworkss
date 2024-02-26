package org.example.utilities;

import org.example.Models.Address;
import org.example.Models.HomeTask;
import org.example.Models.Task;
import org.example.Utils.Constants;
import org.example.Utils.EntityGenerators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.Utils.Constants.*;
import static org.example.Utils.Constants.TOWN_TEXT;
import static org.example.utilities.MockConstants.*;
import static org.example.utilities.MockConstants.LIST_OF_DESCRIPTIONS;

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
        Random random = new Random();
        return IntStream.range(0, COUNT_OF_TASK_RANDOM_GEN)
                .mapToObj(i -> generateSingleTask(random.nextInt(3) + 1))
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
