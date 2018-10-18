import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { AboutPage } from '../pages/about/about';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';
import { LoginPage } from '../pages/login/login';
import { RegisterPage } from '../pages/register/register';
import { NewTripPage } from '../pages/new-trip/new-trip';
import { AngularFireModule } from '@angular/fire';
import { AngularFireAuth } from '@angular/fire/auth';
import { firebaseConfig } from '../config';


import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';


import { ApiRestProvider } from '../providers/api-rest/api-rest';
import { RoutesPage } from '../pages/routes/routes';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AuthService } from '../services/auth.service';
import { AuthProvider } from '../providers/auth/auth';
import { GooglePlus } from '@ionic-native/google-plus';
import { ChallengesPage } from '../pages/challenges/challenges';
import { ExplorePage } from '../pages/explore/explore';
import { FriendsPage } from '../pages/friends/friends';
import { SplashPage } from '../pages/splash/splash';
import {ComponentsModule} from "../components/components.module";
import {ProfilePage} from "../pages/profile/profile";
import { AgmCoreModule } from '@agm/core';


import { Network } from '@ionic-native/network';
import { Geolocation } from '@ionic-native/geolocation';
import {MapsAPILoader} from '@agm/core';


@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    LoginPage,
    RegisterPage,
    NewTripPage,
    RoutesPage,
    NewTripPage,
    ChallengesPage,
    ExplorePage,
    FriendsPage,
    SplashPage,
    ProfilePage
  ],
  imports: [
    BrowserModule,
    ComponentsModule,
    IonicModule.forRoot(MyApp),
    HttpClientModule,
    AngularFireModule.initializeApp(firebaseConfig.fire),
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyDXykc7Ht5qZd2B_kYwEEMhjlgyRFvRQWE",
      libraries: ["places"]
  })
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    LoginPage,
    RegisterPage,
    NewTripPage,
    RoutesPage,
    NewTripPage,
    ChallengesPage,
    ExplorePage,
    FriendsPage,
    SplashPage,
    ProfilePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    ApiRestProvider,
    HttpClient,
    AngularFireAuth,
    AuthService,
    AuthProvider,
    GooglePlus,
    Network,
    Geolocation,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
