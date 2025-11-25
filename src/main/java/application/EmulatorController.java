package application;

import central_processing_unit.CPU;
import central_processing_unit.Flag;
import javafx.scene.control.*;
import memory.cells.WordCell;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import memory.registers.Register32;
import memory.registers.StatusRegister;
import assemble.language.IncorrectFormatException;
import assemble.language.Parser;

import java.util.ArrayList;
import java.util.List;

public class EmulatorController {
    @FXML
    public TextArea codeTextArea;
    @FXML
    public Button loadIntoMemoryButton;
    @FXML
    public ListView<WordCell> memoryListView;
    @FXML
    public ToggleButton supervisorToggleButton;
    @FXML
    public Button startButton;
    @FXML
    public Button nextButton;
    @FXML
    public Button resetButton;
    @FXML
    public ToggleButton trapToggleButton;
    @FXML
    public ListView<Register32> intRegsListView;
    @FXML
    public ListView<Register32> floatRegsListView;
    @FXML
    public ListView<Register32> programCounterListView;
    @FXML
    public ListView<StatusRegister> statusListView;

    private CPU cpu;
    private Parser parser;
    private boolean isProgramEnd;

    @FXML
    void initialize() {
        isProgramEnd = false;
        parser = new Parser();
        cpu = new CPU();
        memoryListView.setItems(FXCollections.observableList(cpu.memory.asWordList()));
        intRegsListView.setItems(FXCollections.observableList(cpu.intRegs));
        floatRegsListView.setItems(FXCollections.observableList(cpu.floatRegs));
        programCounterListView.setItems(FXCollections.observableList(new ArrayList<>(){{add(cpu.programCounter);}}));
        statusListView.setItems(FXCollections.observableList(new ArrayList<>(){{add(cpu.statusReg);}}));
        nextButton.setDisable(true);
        resetButton.setDisable(true);
        startButton.setDisable(true);
        trapToggleButton.setSelected(cpu.statusReg.getFlagStatus(Flag.TRAP));
        supervisorToggleButton.setSelected(cpu.statusReg.getFlagStatus(Flag.SUPERVISOR));

        // TODO: проверку на количество инчтрукций
        loadIntoMemoryButton.setOnAction(actionEvent -> {
            String[] instructions = codeTextArea.getText().split("\n");

            List<Integer> instructionsData = new ArrayList<>();

            try {
                for (var instruction : instructions) {
                    if (!instruction.isEmpty())
                        instructionsData.add(parser.parse(instruction));
                }

                for (int i = 0; i < instructionsData.size(); ++i)
                    memoryListView.getItems().get(i).setValue(instructionsData.get(i));

            } catch (IncorrectFormatException e) {
                showAlert(e.getMessage());
            }

            startButton.setDisable(instructionsData.size() == 0);
            refreshAll();
        });

        startButton.setOnAction(actionEvent -> {
            try {
                startButton.setDisable(true);
                loadIntoMemoryButton.setDisable(true);
                automaticExecution();
            } catch (EmulationAbortException e) {
                showAlert(e.getMessage());
                cpu.clear();
                nextButton.setDisable(true);
                resetButton.setDisable(false);
                isProgramEnd = true;
            }
            refreshAll();
        });

        nextButton.setOnAction(actionEvent -> {
            try {
                if (cpu.statusReg.getFlagStatus(Flag.TRAP) && !isProgramEnd) {
                    isProgramEnd = cpu.nextInstruction();
                    resetButton.setDisable(!isProgramEnd);
                    nextButton.setDisable(isProgramEnd);
                } else {
                    automaticExecution();
                }
            } catch (EmulationAbortException e) {
                showAlert(e.getMessage());
                cpu.clear();
                nextButton.setDisable(true);
                resetButton.setDisable(false);
                isProgramEnd = true;
            }
            refreshAll();
        });

        resetButton.setOnAction(actionEvent -> {
            cpu.clear();
            nextButton.setDisable(true);
            resetButton.setDisable(true);
            loadIntoMemoryButton.setDisable(false);
            trapToggleButton.setSelected(cpu.statusReg.getFlagStatus(Flag.TRAP));
            supervisorToggleButton.setSelected(cpu.statusReg.getFlagStatus(Flag.SUPERVISOR));
            isProgramEnd = false;
            refreshAll();
        });

        trapToggleButton.setOnAction(actionEvent -> {
            cpu.statusReg.invertFlagStatus(Flag.TRAP);
            refreshAll();
        });

        supervisorToggleButton.setOnAction(actionEvent -> {
            cpu.statusReg.invertFlagStatus(Flag.SUPERVISOR);
            refreshAll();
        });
    }

    private void automaticExecution() throws EmulationAbortException {
        trapToggleButton.setDisable(true);
        supervisorToggleButton.setDisable(true);
        nextButton.setDisable(true);

        while (!cpu.statusReg.getFlagStatus(Flag.TRAP) && !isProgramEnd) {
            isProgramEnd = cpu.nextInstruction();
            resetButton.setDisable(!isProgramEnd);
        }

        nextButton.setDisable(isProgramEnd);
        trapToggleButton.setDisable(false);
        supervisorToggleButton.setDisable(false);
    }

    private void showAlert(String alertInfo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(alertInfo);
        alert.showAndWait();
    }

    private void refreshAll() {
        memoryListView.refresh();
        intRegsListView.refresh();
        floatRegsListView.refresh();
        programCounterListView.refresh();
        statusListView.refresh();
    }
}