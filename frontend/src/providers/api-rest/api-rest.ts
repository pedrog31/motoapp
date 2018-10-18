import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {AuthProvider} from '../auth/auth';
import {User} from 'firebase';
import {UserModel} from '../../models/user.model';


/*
  Generated class for the ApiRestProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class ApiRestProvider {

  apiUrl = 'http://192.168.1.15:8090/';

  constructor(public http: HttpClient, public authProvider: AuthProvider) {
    console.log('Hello ApiRestProvider Provider');
  }

  getPublicTrips() {
    return new Promise(resolve => {
      this.http.get(this.apiUrl + 'trips/public').subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

  getUser(uid: string){
    return new Promise(resolve => {
      this.http.get(this.apiUrl+'users/'+uid).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

  addTrip(data) {
    return new Promise((resolve, reject) => {
      this.http.post(this.apiUrl + 'trips', data)
        .subscribe(res => {
          resolve(res);
        }, (err) => {
          reject(err);
        });
    });
  }

  addUser(data: UserModel) {
    return new Promise((resolve, reject) => {
      this.http.post(this.apiUrl + 'users/' + data._uid, data)
        .subscribe(res => {
          resolve(res);
        }, (err) => {
          reject(err);
        });
    });
  }

  searchMotos(query: string) {
    return new Promise(resolve => {
      this.http.get(this.apiUrl + '/motorcycles/' + query).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
