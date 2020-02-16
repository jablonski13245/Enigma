import Ciphers.Cipher;
import Ciphers.Impl.CesarCipher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Test extends Application {
    String resourcePath = "/Test.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourcePath));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600 , 600);
        stage.setTitle("Enigma");
        stage.setScene(scene);
        stage.show();
    }

}

