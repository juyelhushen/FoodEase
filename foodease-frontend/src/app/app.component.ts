import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { MaterialModule } from './shared/material-module';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { RestaurantDetailsModule } from './components/restaurant-details/restaurant-details.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    NavbarComponent,
    FooterComponent,
    MaterialModule,
    SlickCarouselModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'foodease-frontend';

  isSpecial: boolean = true;
}
