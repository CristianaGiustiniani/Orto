package com.orto.logic.graphic_controller.controller.gui_1.login;

import com.orto.logic.utils.I18n;
import com.orto.logic.graphic_controller.bean.LoginBean;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.orto.logic.graphic_controller.controller.GUIView;
import com.orto.logic.graphic_controller.controller.LoginView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class LoginGUI1View extends GUIView implements LoginView {
    //JAVAFX GRAPHIC ELEMENTS
    @FXML private Button buttonLogin;
    @FXML private Button buttonSignUp;
    @FXML private CheckBox checkboxRememberMe;
    @FXML private Label labelError;
    @FXML private PasswordField inputPassword;
    @FXML private TextField inputEmail;
    @FXML private Text textPassword;
    @FXML private Text textEmail;
    @FXML private Text textOr;
    @FXML private Text textSubtitle;
    @FXML private Text textTitle;

    //CONSTRUCTOR
    public LoginGUI1View() {
        super("views/views1/Login.fxml");
    }

    //INPUT METHODS
    @FXML private void onClickButtonLogin() {
        LoginBean inputBean = getInput();

        try {
            inputBean.validate();
        } catch (InvalidStringException e) {
            showError(e.getMessage());
        }

        login(inputBean.getEmail(), BCrypt.hashpw(inputBean.getPassword(), BCrypt.gensalt()));
    }

    @FXML private void onClickButtonSignUp() {
        signup();
    }

    protected LoginBean getInput() {
        try{
            LoginBean bean = new LoginBean();
            bean.setPassword(inputPassword.getText());
            bean.setRememberUser(checkboxRememberMe.isSelected());
            return bean;
        } catch (InvalidStringException e) {
            //todo: show error label
        }
        return null;
    }

    //OUTPUT METHODS
    protected void setupTexts() {
        buttonLogin.setText(I18n.t("GUI_LOGIN_VIEW_LOGIN"));
        buttonSignUp.setText(I18n.t("GUI_LOGIN_VIEW_SIGNUP"));
        checkboxRememberMe.setText(I18n.t("GUI_LOGIN_VIEW_REMEMBERME"));
        textEmail.setText(I18n.t("GUI_LOGIN_VIEW_EMAIL"));
        textOr.setText(I18n.t("GUI_LOGIN_VIEW_OR"));
        textPassword.setText(I18n.t("GUI_LOGIN_VIEW_PASSWORD"));
        textSubtitle.setText(I18n.t("GUI_LOGIN_VIEW_SUBTITLE_LOGIN"));
        textTitle.setText(I18n.t("GUI_LOGIN_VIEW_TITLE_LOGIN"));
    }

    public void showError(String message) {
        labelError.setText(message);
    }
}
