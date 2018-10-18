import { Component } from '@angular/core';

import { AboutPage } from '../about/about';
import { ContactPage } from '../contact/contact';
import { HomePage } from '../home/home';
import { RoutesPage } from '../routes/routes';
import { FriendsPage } from '../friends/friends';
import { ExplorePage } from '../explore/explore';
import { ChallengesPage } from '../challenges/challenges';

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  routesRoot = RoutesPage;
  friendsRoot = FriendsPage;
  homeRoot = HomePage;
  exploreRoot = ExplorePage;
  challengesRoot = ChallengesPage;

  constructor() {

  }
}
