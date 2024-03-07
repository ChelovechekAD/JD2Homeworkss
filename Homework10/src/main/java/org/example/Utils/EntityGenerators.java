package org.example.Utils;

import org.example.Models.Address;
import org.example.Models.HomeTask;
import org.example.Models.Task;
import org.example.Models.WorkTask;

import java.util.function.Supplier;

import static org.example.Utils.Constants.*;

public class EntityGenerators {


    public static Supplier<HomeTask> generateHomeTask() {
        return () -> {
            HomeTask homeTask = new HomeTask();
            homeTask.setDescription(LIST_OF_DESCRIPTIONS[RANDOM.nextInt(LIST_OF_DESCRIPTIONS.length)]);
            homeTask.setName(TASK_TEXT + RANDOM.nextInt(TASK_NUMBER_BOUND));
            homeTask.setAddress(getHomeAddress());
            return homeTask;
        };


    }

    public static Supplier<WorkTask> generateWorkTask() {
        return () -> {
            WorkTask workTask = new WorkTask();
            workTask.setName(TASK_TEXT + RANDOM.nextInt(TASK_NUMBER_BOUND));
            workTask.setDescription(LIST_OF_DESCRIPTIONS[RANDOM.nextInt(LIST_OF_DESCRIPTIONS.length)]);
            workTask.setCost(RANDOM.nextInt(MAX_COST_BOUND - MIN_COST_BOUND) + MIN_COST_BOUND + ((double) Math.round(RANDOM.nextFloat() * TWO_NUMBER_AFTER_DOT_EXTRACTOR_VALUE) / TWO_NUMBER_AFTER_DOT_EXTRACTOR_VALUE));
            return workTask;
        };
    }

    public static Supplier<Task> generateTask() {
        return () -> {
            Task task = new WorkTask();
            task.setName(TASK_TEXT + RANDOM.nextInt(TASK_NUMBER_BOUND));
            task.setDescription(LIST_OF_DESCRIPTIONS[RANDOM.nextInt(LIST_OF_DESCRIPTIONS.length)]);
            return task;
        };
    }

    private static Address getHomeAddress() {
        return new Address(STREET_TEXT, TOWN_TEXT);
    }


}
