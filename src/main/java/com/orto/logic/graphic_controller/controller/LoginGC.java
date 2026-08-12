package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.LoginController;
import com.orto.logic.graphic_controller.bean.LoginBean;
import com.orto.logic.graphic_controller.bean.exceptions.EmptyEmailException;
import com.orto.logic.graphic_controller.bean.exceptions.EmptyPasswordException;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.I18n;

public interface LoginGC {
    default void login() {
        LoginBean inputBean = getInput();

        try {
            inputBean.validate();
            (new LoginController()).login(inputBean.getEmail(), inputBean.getPassword(), inputBean.isRememberUser());
            GCFactoryProvider.getInstance().createHome();

        } catch (EmptyEmailException e) {
            showError(I18n.t("ERROR_LOGIN_EMPTYEMAIL"), e);
        } catch (EmptyPasswordException e) {
            showError(I18n.t("ERROR_LOGIN_EMPTYPASSWORD"), e);
        } catch (ConnectionException e) {
            showError(I18n.t("ERROR_LOGIN_CONNECTION"), e);
            GCFactoryProvider.getInstance().createHome();
        } catch (WrongPasswordException e) {
            showError(I18n.t("ERROR_LOGIN_WRONGPASSWORD"), e);
        } catch (WrongEmailException e) {
            showError(I18n.t("ERROR_LOGIN_WRONGEMAIL"), e);
        }
    }

    LoginBean getInput();

    default void signup() {
        //not implementing signup
    }

    void showError(String message, Exception e);
}
