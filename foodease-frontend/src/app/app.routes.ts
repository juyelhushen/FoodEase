import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RestaurantDetailsComponent } from './components/restaurant-details/restaurant-details.component';
import { CartComponent } from './components/cart/cart.component';

export const routes: Routes = [
  {
    path: '',
    component: RestaurantDetailsComponent,
  },
  // {
  //   path: 'dashboard',
  //   loadChildren: () =>
  //     import('./components/dashboard/dashboard-routing.module').then(
  //       (m) => m.DashboardRoutingModule
  //     ),
  // },
];
