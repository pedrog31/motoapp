import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GooglePlus } from '@ionic-native/google-plus';
import { environment } from '../../environments/environment';
import firebase from 'firebase';
import { AlertController } from 'ionic-angular';
import { UserModel } from '../../models/user.model'
import { Platform } from 'ionic-angular';
import { AngularFireAuth } from '@angular/fire/auth';


/*
  Generated class for the AuthProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class AuthProvider {
  public provider: firebase.auth.PhoneAuthProvider;

  constructor(public http: HttpClient, private googlePlus: GooglePlus, 
              public alertCtrl:AlertController, 
              public platform: Platform, 
              public afAuth: AngularFireAuth,) {
    
    console.log('Hello AuthProvider Provider');
  }



  smsLogin(phoneNumber: string, recaptchaVerifier:firebase.auth.RecaptchaVerifier){
    this.provider = new firebase.auth.PhoneAuthProvider();
    this.provider.verifyPhoneNumber(phoneNumber, recaptchaVerifier)
      .then(function(verificationId) {
        var verificationCode = window.prompt("Ingrese el código de verificación");
        return firebase.auth.PhoneAuthProvider.credential(verificationId,
            verificationCode);
      })
      .then(function(phoneCredential) {
        return firebase.auth().signInWithCredential(phoneCredential);
      });
  }

  doGoogleLogin(){
    return new Promise<UserModel>((resolve, reject) => {
      let userModel = new UserModel();
      if (this.platform.is('cordova')) {
        this.googlePlus.login({
          'scopes': '', // optional, space-separated list of scopes, If not included or empty, defaults to `profile` and `email`.
          'webClientId': environment.googleWebClientId, // optional clientId of your Web application from Credentials settings of your project - On Android, this MUST be included to get an idToken. On iOS, it is not required.
          'offline': true
        }).then((response) => {
          const googleCredential = firebase.auth.GoogleAuthProvider.credential(response.idToken);
          firebase.auth().setPersistence(firebase.auth.Auth.Persistence.LOCAL)
          .then(function() {
            firebase.auth().signInWithCredential(googleCredential)
          .then((user) => {
            userModel.name=user.displayName;
            userModel.email=user.email;
            userModel._uid=user.uid;
            userModel.cellphone=user.phoneNumber;
            userModel.uriPhoto=user.photoURL;
            return resolve(userModel);
          });
          })
          .catch(function(error) {
            var errorCode = error.code;
            var errorMessage = error.message;
          });
          
        },(err) => {
          reject(err);
        });
      }
      else{
        this.afAuth.auth
        .signInWithPopup(new firebase.auth.GoogleAuthProvider())
        .then((user) => {
          userModel.name=user.user.displayName;
          userModel.email=user.user.email;
          userModel._uid=user.user.uid;
          userModel.cellphone=user.user.phoneNumber;
          userModel.uriPhoto=user.user.photoURL;
          return resolve(userModel);
        })
      }
    })
  }


  getCurrentUser(){
    return new Promise<any>((resolve, reject) => {
      firebase.auth().onAuthStateChanged(function(user){
        let userModel = new UserModel();
        if (user) {
            userModel.name = user.displayName;
            userModel.email =user.email;
            userModel.uriPhoto = user.photoURL;
            userModel.cellphone = user.phoneNumber;
            userModel._uid = user.uid;
            return resolve(userModel);
        } else {
          reject('No userName logged in');
        }
      })
    })
  }


  logOut(){
    firebase.auth().signOut().then(function() {
      console.log('fin');
    }, function(error) {

      console.log(error);

    });
  }

}
