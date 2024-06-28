import { Component } from '@angular/core';
import { MaterialModule } from '../../shared/material-module';
import { link } from 'fs';
import { DashboardRoutingModule } from './dashboard-routing.module';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [MaterialModule, DashboardRoutingModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
})
export class DashboardComponent {
  showFiller = true;

  menuItem = [
    { item: 'Order', icon: 'shopping_basket', link: 'orders' },
    { item: 'Favorites', icon: 'favorite', link: 'favorites' },
    { item: 'Address', icon: 'add_location', link: 'address' },
    { item: 'Payments', icon: 'payment', link: 'payments' },
    { item: 'Notification', icon: 'notifications', link: 'notification' },
    { item: 'Evnts', icon: 'events', link: 'events' },
    { item: 'Logout', icon: 'exit_to_app', link: 'logout' },
  ];
}
