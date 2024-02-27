package org.example.DAOTests;

import org.example.DAO.Impl.TaskDAOImpl;
import org.example.DAO.TaskDAO;
import org.example.Models.Task;
import org.example.Utils.HibernateUtil;
import org.example.utilities.MockConstants;
import org.example.utilities.MockUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TaskDAOImplTest {
    private TaskDAO taskDAO = new TaskDAOImpl();
    private List<Task> randomTaskList = MockUtils.generateRandomTasksList();

    @AfterAll
    public static void closeHiber() {
        HibernateUtil.close();
    }

    @Test
    public void testSave() {
        randomTaskList.forEach(taskDAO::save);
        List<Integer> idList = randomTaskList.stream()
                .map(Task::getId)
                .collect(Collectors.toList());
        assertIterableEquals(randomTaskList,
                idList.stream()
                        .map(p -> taskDAO.get(p))
                        .collect(Collectors.toList()));
    }

    @Test
    void testUpdate() {
        Task task = MockUtils.generateSingleTask(3);
        taskDAO.save(task);
        assert task != null;
        task.setDescription(MockConstants.TEST_DESCRIPTION);
        taskDAO.update(task);
        String actual = taskDAO.get(task.getId()).getDescription();

        assertEquals(MockConstants.TEST_DESCRIPTION, actual);
    }

    @Test
    void testDelete() {
        Task task = MockUtils.generateSingleTask(3);
        taskDAO.save(task);
        assert task != null;
        int id = task.getId();
        taskDAO.deleteById(id);
        Task actual = taskDAO.get(id);

        assertNull(actual);
    }


}
