public class Lintz {
    private Ui ui;
    private Storage storage;
    private TaskList taskList;

    public Lintz() {
        ui = new Ui();
        storage = new Storage();
        taskList = new TaskList(storage.loadTasks());
    }

    public void run() {
        ui.greet();

        while (true) {
            String input = ui.readCommand();

            if (input.equalsIgnoreCase("bye")) {
                ui.exit();
                break;
            }

            try {
                Command command = Parser.parseCommand(input);
                command.execute(taskList, ui, storage); // Execute the command
            } catch (IllegalInputException e) {
                ui.displayError("Apologies Sir/Ma'am, might I trouble you to input your command again for clarification? Thank you Sir/Ma'am ;-D");
                ui.displayCorrectInputTemplate();
            } catch (IndexOutOfBoundsException e) {
                ui.displayError("Hi Sir/Ma'am, I've captured incomplete command, please be so kind to elaborate ;-)");
                ui.displayCorrectInputTemplate();
            }
        }
    }

    public static void main(String[] args) {
        new Lintz().run();
    }

}
