package controllers;

import Ciphers.Cipher;
import Ciphers.Impl.CesarCipher;

import file.utils.FileTool;
import file.utils.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage mainStage;
    @FXML
    public TextArea inputTextArea;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String encode = cesarCipher.encode(userText);
            inputTextArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            Cipher cesarCipher = new CesarCipher();
            String decode = cesarCipher.decode(userText);
            inputTextArea.setText(decode);
        }
    }

    @FXML
    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file","*.crpt"),
                new FileChooser.ExtensionFilter("text file","*.txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if (fileToSave != null){
            String absolutePath = fileToSave.getAbsolutePath();
            FileTool.writeTextAreaContentToFile(absolutePath,inputTextArea.getText());
        }
    }
    @FXML
    public void fileToLoad(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file","*.crpt"),
                new FileChooser.ExtensionFilter("text file","*.txt")
        );

        File loadedFile = fileChooser.showOpenDialog(null);
        String absolutePath = loadedFile.getAbsolutePath();
        String fileContent = FileTool.getFileContent(absolutePath);
        inputTextArea.setText(fileContent);

    }
    }

