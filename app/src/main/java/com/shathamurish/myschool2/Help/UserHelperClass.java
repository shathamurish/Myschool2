package com.shathamurish.myschool2.Help;

public class UserHelperClass {
    String fullname, username, email, password,gender,phoneno,date,spinner;

    String id;



    public UserHelperClass(String fullname, String username, String email, String password, String gender, String phoneno, String date, String spinner) {
        this.fullname=fullname;
        this.username = username;
        this.email = email;
        this.phoneno = phoneno;
        this.password = password;
        this.gender = gender;
        this.date=date;
        this.spinner=spinner;
    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    //overrid constarcor

//    public UserHelperClass(String fullname, String username, String email, String password, String gender,String phoneno) {
//
//        this.fullname=fullname;
//        this.username = username;
//        this.email = email;
//         this.phoneno = phoneno;
//        this.password = password;
//        this.gender = gender;
////
//    }
//
//
//
//
//    public UserHelperClass(String fullname, String username, String email, String password, String gender, String phoneno) {
//        this.fullname = fullname;
//        this.username = username;
//        this.email = email;
//      // this.phoneno = phoneno;
//        this.password = password;
//        this.gender = gender;
////        this.date = date;
//        // this.spinner1 = spinner1;
//    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassowrd() {
        return password;
    }

    public void setPassowrd(String password) {
        this.password = password;
    }
//    public String getPhoneno() {
//        return phoneno;
//    }
//
//    public void setPhoneno(String phoneno) {
//        this.phoneno = phoneno;
//    }


    @Override
    public String toString() {
        return "UserHelperClass{" +
                "fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
