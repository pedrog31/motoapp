import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AuthProvider } from '../../providers/auth/auth';
import { ApiRestProvider } from '../../providers/api-rest/api-rest';
import { UserModel } from '../../models/user.model';
import { TabsPage } from '../tabs/tabs';
import { RegisterPage } from '../register/register';
import { LoginPage } from '../login/login';

/**
 * Generated class for the SplashPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-splash',
  templateUrl: 'splash.html',
})
export class SplashPage {

  constructor(public navCtrl: NavController, 
              public navParams: NavParams,
              public authProvider: AuthProvider,
              public apiRestProvider: ApiRestProvider) {
    this.authProvider.getCurrentUser()
    .then((res) => {
      this.directionPage(res);
    }, (err) => {
      navCtrl.push(LoginPage);
    });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SplashPage');
  }

  directionPage(res: UserModel){
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
  }

}
