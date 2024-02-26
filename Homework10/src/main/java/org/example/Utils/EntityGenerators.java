package org.example.Utils;

import org.example.Models.Address;
import org.example.Models.HomeTask;
import org.example.Models.Task;
import org.example.Models.WorkTask;

import java.util.Random;
import java.util.function.Supplier;

import static org.example.Utils.Constants.*;

public class EntityGenerators {

    private static final int TASK_NUMBER_BOUND = 10;
    private static final int TWO_NUMBER_AFTER_DOT_EXTRACTOR_VALUE = 100;
    private static final int MAX_COST_BOUND = 100000;
    private static final int MIN_COST_BOUND = 10000;

    public static Supplier<HomeTask> generateHomeTask() {
        return () -> {
            Random random = new Random();
            HomeTask homeTask = new HomeTask();
            homeTask.setDescription(LIST_OF_DESCRIPTIONS[random.nextInt(LIST_OF_DESCRIPTIONS.length)]);
            homeTask.setName(TASK_TEXT + random.nextInt(TASK_NUMBER_BOUND));
            homeTask.setAddress(getHomeAddress());
            return homeTask;
        };


    }

    public static Supplier<WorkTask> generateWorkTask() {
        return () -> {
            Random random = new Random();
            WorkTask workTask = new WorkTask();
            workTask.setName(TASK_TEXT + random.nextInt(TASK_NUMBER_BOUND));
            workTask.setDescription(LIST_OF_DESCRIPTIONS[random.nextInt(LIST_OF_DESCRIPTIONS.length)]);
            workTask.setCost(random.nextInt(MAX_COST_BOUND - MIN_COST_BOUND) + MIN_COST_BOUND + ((double) Math.round(random.nextFloat() * TWO_NUMBER_AFTER_DOT_EXTRACTOR_VALUE) / TWO_NUMBER_AFTER_DOT_EXTRACTOR_VALUE));
            return workTask;
        };
    }

    public static Supplier<Task> generateTask() {
        return () -> {
            Random random = new Random();
            Task task = new WorkTask();
            task.setName(TASK_TEXT + random.nextInt(TASK_NUMBER_BOUND));
            task.setDescription(LIST_OF_DESCRIPTIONS[random.nextInt(LIST_OF_DESCRIPTIONS.length)]);
            return task;
        };
    }

    private static Address getHomeAddress() {
        return new Address(STREET_TEXT, TOWN_TEXT);
    }


}
