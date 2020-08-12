package todolist;

import java.util.InputMismatchException;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Map;
import java.util.stream.Collectors;

public class ToDoList {

    public String enterTask(String newTask) {
        Scanner keyboard = new Scanner(System.in);
        newTask = keyboard.nextLine();
        return newTask;
    }

    public static void main(String[] args) {

        Set<Task> toDoList = new LinkedHashSet<>();

        System.out.println("Priority: type 0 for LOW, 1 for NORMAL and 2 for HIGH");
        System.out.println("If you type a different number, priority'll be set as NORMAL");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your task");
        String answer = keyboard.nextLine();

        if (!(answer.equals("out"))) {
            while (!(answer.equals("out"))) {
                System.out.println("Priority");
                Task task;
                int priority = keyboard.nextInt();
                switch (priority) {
                    case 0:
                        task = new Task(answer, Task.PriorityLevel.LOW);
                        break;

                    case 1:
                        task = new Task(answer, Task.PriorityLevel.NORMAL);
                        break;

                    case 2:
                        task = new Task(answer, Task.PriorityLevel.HIGH);
                        break;

                    default:
                        task = new Task(answer, Task.PriorityLevel.NORMAL);
                }

                toDoList.add(task);
                System.out.println("Enter your task");
                answer = keyboard.next();

            }

            System.out.println();
            System.out.println("All your tasks");

            Iterator<Task> eachTask = toDoList.iterator();
            while (eachTask.hasNext()) {
                String tsk = eachTask.next().getTask();
                System.out.println(tsk);
            }

            System.out.println();
            System.out.println("Do you want to filter your tasks? (yes/no)");
            keyboard.next();
            try {
                answer = keyboard.nextLine();
                if (!(answer.equals("yes")) || !(answer.equals("no"))) {
                }
            } catch (InputMismatchException e) {
                System.out.println("Taype yes or no" + e.getMessage());
            }

            if (answer.equals("yes")) {
                System.out.println("Please, choose: LOW, NORMAL or HIGH");
                System.out.println("Use capital letters");

                answer = keyboard.nextLine();

                Stream<Task> streamTask;
                Map<Task.PriorityLevel, List<Task>> mapTask;

                switch (answer) {
                    case "LOW":
                        streamTask = toDoList.stream()
                                .filter(t -> t.getPriority().equals(Task.PriorityLevel.LOW));

                        mapTask = streamTask
                                .collect(Collectors.groupingBy(f -> f.getPriority()));

                        System.out.println();
                        System.out.println("Low Priority:");
                        System.out.println(mapTask);
                        break;

                    case "NORMAL":
                        streamTask = toDoList.stream()
                                .filter(t -> t.getPriority().equals(Task.PriorityLevel.NORMAL));

                        mapTask = streamTask
                                .collect(Collectors.groupingBy(f -> f.getPriority()));

                        System.out.println();
                        System.out.println("Normal Priority:");
                        System.out.println(mapTask);
                        break;

                    case "HIGH":
                        streamTask = toDoList.stream()
                                .filter(t -> t.getPriority().equals(Task.PriorityLevel.HIGH));

                        mapTask = streamTask
                                .collect(Collectors.groupingBy(f -> f.getPriority()));

                        System.out.println();
                        System.out.println("High Priority:");
                        System.out.println(mapTask);

                    default:
                        System.out.println("");
                }

            } else if (answer.equals("no")) {
                System.out.println("OK!");
            }
        } else if (answer.equals("out")) {
            System.out.println();
            System.out.println("Bye Bye!");

            keyboard.close();
        }
    }
}
