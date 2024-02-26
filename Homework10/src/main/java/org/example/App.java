package org.example;

import org.example.DAO.TaskDAO;
import org.example.DAO.Impl.TaskDAOImpl;
import org.example.Models.HomeTask;
import org.example.Models.Task;
import org.example.Models.WorkTask;
import org.example.Utils.Constants;
import org.example.Utils.EntityGenerators;
import org.example.Utils.HibernateUtil;
import org.example.Utils.Printer;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {

        TaskDAO taskDAO = new TaskDAOImpl();

        List<?> homeTaskList = generateListOfTask(Constants.COUNT_OF_TASK_GENERATE, EntityGenerators.generateHomeTask());
        List<Task> outputHomeTaskList = homeTaskList.stream()
                .map(p -> taskDAO.save((HomeTask) p))
                .collect(Collectors.toList());
        Printer.print("List of home tasks.", outputHomeTaskList);


        List<?> workTaskList = generateListOfTask(Constants.COUNT_OF_TASK_GENERATE, EntityGenerators.generateWorkTask());
        List<Task> outputWorkTaskList = workTaskList.stream()
                .map(p -> taskDAO.save((WorkTask) p))
                .collect(Collectors.toList());
        Printer.print("List of work tasks.", outputWorkTaskList);

        //homeTaskDAO.deleteById(1, HomeTask.class);
        //homeTaskDAO.deleteById(6, HomeTask.class);
        taskDAO.getAllByFieldValue("city", "address", "Minsk", HomeTask.class).forEach(System.out::println);

        taskDAO.getAllByFieldValue("cost", null, "12304.2", WorkTask.class).forEach(System.out::println);

        taskDAO.deleteAllByFieldValue("cost", null, "12304.2", WorkTask.class);
        taskDAO.getAllByFieldValue("cost", null, "12304.2", WorkTask.class).forEach(System.out::println);


        HibernateUtil.close();
    }

    public static List<? extends Task> generateListOfTask(int count, Supplier<? extends Task> method) {
        return IntStream.range(0, count)
                .mapToObj(i -> method.get())
                .collect(Collectors.toList());
    }

}
