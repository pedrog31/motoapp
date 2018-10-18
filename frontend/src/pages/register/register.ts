import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { TabsPage } from '../tabs/tabs';
import { UserModel } from '../../models/user.model'
import { AuthProvider } from '../../providers/auth/auth';
import firebase from 'firebase';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { ApiRestProvider } from '../../providers/api-rest/api-rest';

/**
 * Generated class for the RegisterPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-register',
  templateUrl: 'register.html',
})
export class RegisterPage {
  user: UserModel = new UserModel();
  formRegister: FormGroup;
  constructor(public navCtrl: NavController, public navParams: NavParams, public authProvider: AuthProvider, private fb: FormBuilder, public apiRestProvider: ApiRestProvider ) {
    this.user = navParams.get('user');
    this.createForm();
    console.log(this.user);
  }

  ionViewDidLoad() {
    
  }
  

  completeSignUp(){
    this.user.name=this.formRegister.get('name').value;
    this.user.userName= this.formRegister.get('user').value;
    this.user.birthdate=this.formRegister.get('birthday').value;
    this.user.cellphone=this.formRegister.get('phone').value;
    
    console.log(this.user);
    this.apiRestProvider.addUser(this.user).then((res: any) =>{
      this.navCtrl.push(TabsPage);
    }, error =>{
      console.log(error);
    });
    
  }



  createForm(){
    this.formRegister = this.fb.group({
      name: [this.user.name, Validators.required],
      user: [undefined, Validators.required],
      email: [this.user.email, Validators.required],
      phone: [this.user.cellphone, Validators.required],
      city: [undefined, Validators.required],
      birthday: [undefined, Validators.required]
    })
  }

}
