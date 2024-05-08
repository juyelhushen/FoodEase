import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-carousel-item',
  standalone: true,
  imports: [],
  templateUrl: './carousel-item.component.html',
  styleUrl: './carousel-item.component.scss'
})
export class CarouselItemComponent {

  @Input() image!:string;
  @Input() name!:string;

  
}
