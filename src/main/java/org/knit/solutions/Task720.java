package org.knit.solutions;
import org.knit.TaskDescription;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.knit.solutions.lab7.config.AppConfig;
import org.knit.solutions.lab7.service.PasswordService;
import org.knit.solutions.lab7.security.MasterPasswordHolder;

import java.util.List;
import java.util.Scanner;

@TaskDescription(taskNumber = 720, taskDescription = "7.20 in-place модификация массива")
public class Task720 implements Solution {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите мастер-пароль: ");
        char[] masterPassword = System.console() != null
                ? System.console().readPassword()
                : scanner.nextLine().toCharArray();

        MasterPasswordHolder holder = new MasterPasswordHolder(masterPassword);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(MasterPasswordHolder.class, () -> holder);
        context.register(AppConfig.class);
        context.refresh();

        PasswordService service = context.getBean(PasswordService.class);

        // Очистка мастер-пароля при завершении
        Runtime.getRuntime().addShutdownHook(new Thread(holder::clear));

        try {
            service.load();
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }


        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(" ", 2);
            String cmd = parts[0];

            try {
                switch (cmd) {
                    case "add":
                        try {
                            System.out.print("Сайт: ");
                            String site = scanner.nextLine();
                            System.out.print("Логин: ");
                            String login = scanner.nextLine();
                            System.out.print("Пароль: ");
                            String pass = scanner.nextLine();
                            service.add(site, login, pass);
                            System.out.println("Добавлено.");
                        } catch (Exception e) {
                            System.out.println("Ошибка при добавлении: " + e.getMessage());
                        }
                        break;

                    case "list":
                        List<String> entries = service.list();
                        entries.forEach(System.out::println);
                        break;
                    case "copy":
                        try {
                            if (parts.length < 2) {
                                System.out.println("Укажите сайт.");
                                break;
                            }
                            if (service.copyToClipboard(parts[1]))
                                System.out.println("Скопировано в буфер.");
                            else
                                System.out.println("Сайт не найден.");
                        } catch (Exception e) {
                            System.out.println("Ошибка при копировании: " + e.getMessage());
                        }
                        break;
                    case "delete":
                        try {
                            if (parts.length < 2) {
                                System.out.println("Укажите сайт.");
                                break;
                            }
                            if (service.delete(parts[1]))
                                System.out.println("Удалено.");
                            else
                                System.out.println("Сайт не найден.");
                        } catch (Exception e) {
                            System.out.println("Ошибка при удалении: " + e.getMessage());
                        }
                        break;
                    case "exit":
                        context.close();
                        return;
                    default:
                        System.out.println("Неизвестная команда.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}

