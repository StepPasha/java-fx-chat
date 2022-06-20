package ru.gb.javafxchat.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.gb.javafxchat.Command;

import java.io.IOException;

public class ChatClientApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatClientApplication.class.getResource("client-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Chat client");
        stage.setScene(scene);
        stage.show();

        ChatController controller = fxmlLoader.getController();
        stage.setOnCloseRequest(event -> controller.getClient().sendMessage(Command.END));
    }

    public static void main(String[] args) {
        launch();
    }
}