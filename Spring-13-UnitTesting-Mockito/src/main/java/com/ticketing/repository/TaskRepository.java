package com.ticketing.repository;

import com.ticketing.entity.Project;
import com.ticketing.entity.Task;
import com.ticketing.entity.User;
import com.ticketing.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT count(t) FROM Task t WHERE t.project.projectCode = ?1 AND t.taskStatus <> 'COMPLETE' ")
    int totalNonCompletedTasks(String projectCode);

    @Query(value = "SELECT count(*) " +
            " FROM tasks t JOIN projects p on t.project_id=p.id " +
            " WHERE p.project_code = ?1 AND t.task_status = 'COMPLETE'", nativeQuery = true)
    int totalCompletedTasks(String projectCode);

    List<Task> findAllByProject(Project project);

    List<Task> findAllByTaskStatusIsNotAndAssignedEmployee(Status status, User user);

    List<Task> findAllByProjectAssignedManager(User manager);

    List<Task> findAllByTaskStatusAndAssignedEmployee(Status status, User user);

    List<Task> findAllByAssignedEmployee(User user);


}
