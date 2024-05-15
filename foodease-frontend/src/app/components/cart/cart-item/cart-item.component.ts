import { Component } from '@angular/core';
import { MaterialModule } from '../../../shared/material-module';

@Component({
  selector: 'app-cart-item',
  standalone: true,
  imports: [MaterialModule],
  templateUrl: './cart-item.component.html',
  styleUrl: './cart-item.component.scss'
})
export class CartItemComponent {

}
