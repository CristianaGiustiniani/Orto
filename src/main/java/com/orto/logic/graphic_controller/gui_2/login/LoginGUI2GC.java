package com.orto.logic.graphic_controller.gui_2.login;

import com.orto.logic.controller.bean.LoginBean;
import com.orto.logic.controller.bean.exceptions.EmptyEmailException;
import com.orto.logic.controller.bean.exceptions.EmptyPasswordException;
import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.graphic_controller.LoginGC;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class LoginGUI2GC extends GUIGC implements LoginGC {
    //FXML ELEMENTS
    @FXML private Button buttonLogin;
    @FXML private CheckBox checkboxRememberMe;
    @FXML private Label labelError;
    @FXML private PasswordField inputPassword;
    @FXML private TextField inputEmail;
    @FXML private Text textPassword;
    @FXML private Text textEmail;
    @FXML private Text textSubtitle;
    @FXML private Text textTitle;

    //CONSTRUCTOR
    public LoginGUI2GC() {
        super("/views/views2/form/Login.fxml");

        Parent background = loadBackground();
        Parent login = this.load();
        ((BorderPane) background).setCenter(login);
        root = background;

        setupTexts();

        Configuration.getInstance().getStage().setScene(new Scene(root));
    }

    //INPUT METHODS
    @FXML private void onClickButtonLogin() {
        labelError.setVisible(false);
        login();
    }

    @FXML private void onClickButtonSignUp() {
        labelError.setVisible(false);
        signup();
    }

    public LoginBean getInput() {
        LoginBean bean = new LoginBean();
        bean.setEmail(inputEmail.getText());
        bean.setPassword(inputPassword.getText());
        bean.setRememberUser(checkboxRememberMe.isSelected());
        return bean;
    }

    //OUTPUT METHODS
    protected void setupTexts() {
        buttonLogin.setText(I18n.t("GUI_LOGIN_VIEW_LOGIN"));
        checkboxRememberMe.setText(I18n.t("GUI_LOGIN_VIEW_REMEMBERME"));
        textEmail.setText(I18n.t("GUI_LOGIN_VIEW_EMAIL"));
        textPassword.setText(I18n.t("GUI_LOGIN_VIEW_PASSWORD"));
        textSubtitle.setText(I18n.t("GUI_LOGIN_VIEW_SUBTITLE_LOGIN"));
        textTitle.setText(I18n.t("GUI_LOGIN_VIEW_TITLE_LOGIN"));
    }

    public void showError(String message, Exception e) {
        if (e instanceof ConnectionException) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(message);
            alert.showAndWait();
        } else if (e instanceof WrongPasswordException || e instanceof WrongEmailException || e instanceof EmptyEmailException || e instanceof EmptyPasswordException) {
            labelError.setVisible(true);
            labelError.setText(message);
        } else {
            labelError.setVisible(true);
            labelError.setText(message);
        }
    }
}
