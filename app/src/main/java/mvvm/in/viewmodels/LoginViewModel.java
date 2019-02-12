package mvvm.in.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import mvvm.in.BR;
import mvvm.in.model.User;

public class LoginViewModel extends BaseObservable {
    private User user;
    @NonNull
    private String successMessage = "Login was successful";
    @NonNull
    private String errorMessage = "Email or Password not valid";

    @Nullable
    @Bindable
    public String toastMessage = null;


    @Nullable
    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel() {
        user = new User("", "");
    }

    public void afterEmailTextChanged(@NonNull CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(@NonNull CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        if (user.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
}
