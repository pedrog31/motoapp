import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Platform } from 'ionic-angular';
import { RegisterPage } from '../register/register';
import { AuthService } from '../../services/auth.service';
import { TabsPage } from '../tabs/tabs';
import { AuthProvider } from '../../providers/auth/auth';

import firebase from 'firebase';
import { ApiRestProvider } from '../../providers/api-rest/api-rest';
import { UserModel } from '../../models/user.model';

/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {
  public user: UserModel;
  public recaptchaVerifier: firebase.auth.RecaptchaVerifier;
  errorMessage: string = '';

  constructor(public navCtrl: NavController,
    public navParams: NavParams,
    public platform: Platform,
    public auth: AuthService,
    public authProvider: AuthProvider,
    public apiRestProvider: ApiRestProvider ) {

  
  }

  ionViewDidLoad() {
    this.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('recaptcha-container');
  }

  ionViewCanEnter(){
    
  }


  signIn(phoneNumber: number) {
    this.navCtrl.push(RegisterPage);

  }

  tryGoogleLogin(){
    this.authProvider.doGoogleLogin()
    .then((res) => {
      this.apiRestProvider.getUser(res._uid)
      .then(data=> {
         if(data){
          this.navCtrl.push(TabsPage);
         }else{
          this.navCtrl.push(RegisterPage, {
            user: res
          });
         }
      })
    }, (err) => {
      this.errorMessage = err.message;
    });
  }

    smsLogin(phoneNum: string){
      this.authProvider.smsLogin('+57'+phoneNum, this.recaptchaVerifier)
      
  }

 


}


