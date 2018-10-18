import {UserMotorcycleModel} from './usermotorcycle.model';

export class UserModel {
  _uid: string;
  name: string;
  lastName: string;
  email: string;
  cellphone: string;
  uriPhoto: string;
  birthdate: Date;
  userName: string;
  level: number;
  motorcycle: UserMotorcycleModel[];
  friends: string[];
}
