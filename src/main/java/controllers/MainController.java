package controllers;

import Ciphers.Cipher;
import Ciphers.Impl.VigenereCipher;
import factories.impl.CipherFactory;
import file.utils.FileTool;
import file.utils.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static factories.impl.CipherFactory.*;

public class MainController implements Initializable {
    @FXML
    public TextArea inputTextArea;

    @FXML
    ChoiceBox<String> cipherChoiceBox;

    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods = FXCollections.observableArrayList(CESAR, ROOT13, VIGENERE);
    private CipherFactory cipherFactory = new CipherFactory();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cipherChoiceBox.setItems(possibleCipherMethods);
        cipherChoiceBox.setValue(CESAR);
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("Please choose key and remember it.");
                inputDialog.setContentText("Key: ");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
                    return;
                }

            }
            String encode = cipher.encode(userText);
            inputTextArea.setText(encode);

        }
    }

    @FXML
    public void triggerDecoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setContentText("Key: ");
                inputDialog.setHeaderText("If you know the key, write it here.");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
                    return;
                }
            }
            String decode = cipher.decode(userText);
            inputTextArea.setText(decode);
        }
    }

    @FXML
    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if (fileToSave != null) {
            String absolutePath = fileToSave.getAbsolutePath();
            FileTool.writeTextAreaContentToFile(absolutePath, inputTextArea.getText());
        }
    }

    @FXML
    public void fileToLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );

        File loadedFile = fileChooser.showOpenDialog(null);
        String absolutePath = loadedFile.getAbsolutePath();
        String fileContent = FileTool.getFileContent(absolutePath);
        inputTextArea.setText(fileContent);

    }
}

