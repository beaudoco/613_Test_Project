package com.example.myapplication;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import org.parceler.Parcel;

@Parcel
public class LoggedInUser {

    //Google user
    private GoogleSignInAccount account;
    //The user that is being created
    private FirebaseUser currentUser;
    private boolean flag = true;
    private String mutinyFirstName;
    private String mutinyEmail;
    public static LoggedInUser single_instance = null;

    public void setAccount(GoogleSignInAccount account) { this.account = account;}
    public void setUser(FirebaseUser currentUser) {this.currentUser = currentUser;}
    public void setFlag(boolean flag) { this.flag = flag;}
    public void setMutinyFirstName(String firstName) {this.mutinyFirstName = firstName;}
    public void setMutinyEmail(String mutinyEmail) {this.mutinyEmail = mutinyEmail;}

    public GoogleSignInAccount getAccount() { return account;}
    public String getFirstName() {return account.getDisplayName();}
    public FirebaseUser getUser() {return currentUser;}
    public String getMutinyFirstName() {return mutinyFirstName;}
    public String getMutinyEmail() {return mutinyEmail;}
    public boolean getFlag() {return flag;}

    public static LoggedInUser getInstance() {
        if(single_instance == null) {
            single_instance = new LoggedInUser();
        }
        return single_instance;
    }
}
