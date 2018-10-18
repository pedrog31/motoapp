import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams, ModalController} from 'ionic-angular';
import {UserModel} from "../../models/user.model";
import {NewMotorcycleComponent} from "../../components/new-motorcycle/new-motorcycle";

/**
 * Generated class for the ProfilePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-profile',
  templateUrl: 'profile.html',
})
export class ProfilePage {
  user: UserModel;

  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public modalController: ModalController) {
  }

  ionViewDidLoad() {
    this.user = this.navParams.data;
    console.log(this.user);
  }

  addNewMoto() {
    let modal = this.modalController.create(NewMotorcycleComponent);
    modal.present();
  }
}
