import {Component, OnInit} from '@angular/core';
import {UserModel} from "../../models/user.model";
import {ApiRestProvider} from "../../providers/api-rest/api-rest";
import {AuthProvider} from "../../providers/auth/auth";
import {NavController, NavParams} from "ionic-angular";
import {ProfilePage} from "../../pages/profile/profile";

@Component({
  selector: 'profile-card',
  templateUrl: 'profile-card.html'
})
export class ProfileCardComponent implements OnInit {

  user: UserModel;

  constructor(private apiRestProvider: ApiRestProvider,
              private authProvider: AuthProvider,
              private navCtrl: NavController,
              private navParams: NavParams) {
  }

  ngOnInit(): void {
    this.authProvider.getCurrentUser().then(user => {
      this.user = user;
      this.apiRestProvider.getUser(this.user._uid).then(user => {
        this.user = (user as UserModel);
      });
    });
  }

  openProfile() {
    this.navParams.data = this.user;
    this.navCtrl.push(ProfilePage, this.navParams).then(ref =>{
      console.log(ref);
    }, reason => {
      console.log(reason);
    })
  }
}
