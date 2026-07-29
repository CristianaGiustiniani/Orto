package com.orto.logic.view_controller.ui.gui_1.login;

import com.orto.logic.controller.LoginController;
import com.orto.logic.controller.SignUpController;
import com.orto.logic.utils.I18n;
import com.orto.logic.view_controller.bean.LoginBean;
import com.orto.logic.view_controller.bean.exceptions.InvalidStringException;

import com.orto.logic.view_controller.ui.GUIView;
import com.orto.logic.view_controller.ui.LoginView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class LoginGUI1View extends GUIView implements LoginView {
    //CONTROLLER
    LoginController controller = new LoginController();

    //JAVAFX GRAPHIC ELEMENTS
    @FXML private Button buttonLogin;
    @FXML private Button buttonSignUp;
    @FXML private CheckBox checkboxRememberMeLogin;
    @FXML private CheckBox checkboxRememberMeSignUp;
    @FXML private Label labelError;
    @FXML private PasswordField inputPasswordLogin;
    @FXML private PasswordField inputPasswordSignUp;
    @FXML private TextField inputUsernameLogin;
    @FXML private TextField inputUsernameSignUp;
    @FXML private Text textEmailSignUp;
    @FXML private Text textOr;
    @FXML private Text textPasswordLogin;
    @FXML private Text textPasswordSignUp;
    @FXML private Text textSubtitleSignUp;
    @FXML private Text textSubtitleLogin;
    @FXML private Text textTitleLogin;
    @FXML private Text textTitleSignUp;
    @FXML private Text textUsernameLogin;
    @FXML private Text textUsernameSignUp;

    //CONSTRUCTOR
    public LoginGUI1View() {
        super("views/views1/Login.fxml");
        setupTexts();
    }

    //JAVAFX ACTIONS-EVENTS
    @FXML private void onClickButtonLogin() {
        logIn();
    }

    @FXML private void onClickButtonSignUp() {
        signUp();
    }

    @Override
    protected Parent create() {
        return null;
    }

    @Override
    protected boolean hasHeader() {
        return false;
    }

    //SETUP
    protected void setupTexts() {
        buttonLogin.setText(I18n.t("GUI_LOGIN_VIEW_LOGIN"));
        buttonSignUp.setText(I18n.t("GUI_LOGIN_VIEW_SIGNUP"));
        checkboxRememberMeLogin.setText(I18n.t("GUI_LOGIN_VIEW_REMEMBERME_LOGIN"));
        checkboxRememberMeSignUp.setText(I18n.t("GUI_LOGIN_VIEW_REMEMBERME_SIGNUP"));
        textEmailSignUp.setText(I18n.t("GUI_LOGIN_VIEW_EMAIL_SIGNUP"));
        textOr.setText(I18n.t("GUI_LOGIN_VIEW_OR"));
        textPasswordLogin.setText(I18n.t("GUI_LOGIN_VIEW_PASSWORD_LOGIN"));
        textPasswordSignUp.setText(I18n.t("GUI_LOGIN_VIEW_PASSWORD_SIGNUP"));
        textSubtitleSignUp.setText(I18n.t("GUI_LOGIN_VIEW_SUBTITLE_SIGNUP"));
        textSubtitleLogin.setText(I18n.t("GUI_LOGIN_VIEW_SUBTITLE_LOGIN"));
        textTitleLogin.setText(I18n.t("GUI_LOGIN_VIEW_TITLE_LOGIN"));
        textTitleSignUp.setText(I18n.t("GUI_LOGIN_VIEW_TITLE_SIGNUP"));
        textUsernameLogin.setText(I18n.t("GUI_LOGIN_VIEW_USERNAME_LOGIN"));
        textUsernameSignUp.setText(I18n.t("GUI_LOGIN_VIEW_USERNAME_SIGNUP"));
    }

    protected void showError() {
    }

    //METHODS
    private void logIn() {
        try{
            LoginBean bean = new LoginBean();
            bean.setUsername(inputUsernameLogin.getText());
            bean.setPassword(inputPasswordLogin.getText());
            bean.setRememberUser(checkboxRememberMeLogin.isSelected());

            controller.logIn(bean);
        } catch (InvalidStringException e) {
            //todo: show error label
        } catch (Exception e) {
            //todo: show error label
        }
    }

    private void signUp() {
        try{
            LoginBean bean = new LoginBean();
            bean.setUsername(inputUsernameLogin.getText());
            bean.setPassword(inputPasswordLogin.getText());
            bean.setRememberUser(checkboxRememberMeLogin.isSelected());

            SignUpController controller = new SignUpController();
            controller.signUp(bean);
        } catch (InvalidStringException e) {
            //todo: show error label
        } catch (Exception e) {
            //todo: show error label
        }
    }
}
