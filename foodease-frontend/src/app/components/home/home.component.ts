import { Component } from '@angular/core';
import { NavbarComponent } from '../../layout/navbar/navbar.component';
import { Food } from '../../shared/models/food';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { CarouselItemComponent } from '../carousel-item/carousel-item.component';
import { RestaurantCardComponent } from '../restaurant-card/restaurant-card.component';
import { Restuarant } from '../../shared/models/restuarant';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    NavbarComponent,
    SlickCarouselModule,
    CarouselItemComponent,
    RestaurantCardComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  status: string = 'Openned';
  resName : string = 'Star Bucks';
  // resBar = [1, 1, 1, 1, 1, 1, 1, 1];

  slideConfig = {
    Infinity: true,
    speed: 500,
    slidesToShow: 5,
    slidesToScroll: 1,
    dots: false,
    autoplay: true,
    autoplaySpeed: 2000,
    arrows: false,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3
        }
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2
        }
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1
        }
      }
    ]
  };


  resCard : Restuarant[] = [
    {
      name:'MC Donalds',
      image : '../../../assets/restaurants/mcdonalds.jpg'
    },
    {
      name:'Chers',
      image : '../../../assets/restaurants/Chers.jpg'
    },
    {
      name:'Food Court',
      image : '../../../assets/restaurants/FoodCourt.jpg'
    },
    {
      name:'KFC',
      image : '../../../assets/restaurants/kfc.jpg'
    },
    {
      name:'MKC',
      image : '../../../assets/restaurants/MKC.jpg'
    },
    {
      name:'Trattoria',
      image : '../../../assets/restaurants/Trattoria.jpg'
    },
    {
      name:'Penniyes Dinner',
      image : '../../../assets/restaurants/PenniyesDinner.jpg'
    },
    {
      name:'American Pan Pizza',
      image:'../../../assets/restaurants/AmericanPanPizza.jpg'
    }
  ]

  foodSlides: Food[] = [
    {
      image: '../../../assets/foods/burger.jpg',
      name: 'Burger',
    },
    {
      image: '../../../assets/foods/Dosa.jpg',
      name: 'Dosa',
    },
    {
      image: '../../../assets/foods/Idli.jpg',
      name: 'Idli',
    },
    {
      image: '../../../assets/foods/Noddles.jpg',
      name: 'Noddles',
    },
    {
      image: '../../../assets/foods/Pasta.jpg',
      name: 'Pasta',
    },
    {
      image: '../../../assets/foods/pizza.jpg',
      name: 'Pizza',
    },
    {
      image: '../../../assets/foods/Sandwich.jpg',
      name: 'Sandwich',
    },
    {
      image: '../../../assets/foods/Veg Biriyani.jpg',
      name: 'Veg Biriyani',
    },
  ];

  slickInit(e: any) {
    console.log('slick initialized');
  }

  breakpoint(e: any) {
    console.log('breakpoint');
  }

  afterChange(e: any) {
    console.log('afterChange');
  }

  beforeChange(e: any) {
    console.log('beforeChange');
  }
}
