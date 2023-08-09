package ru.project.IStudyEnglish.learning_module.controller.Validators;

public class ValidationLoginPassword{

    public void validation(String login,String password) throws Exception {
        if (login.equals("login") && password.equals("password")){
            //TODO created reality login/password
        }
        else {throw new Exception("перебор пароля, нас ломают, мы все умрем");}

    }
}
