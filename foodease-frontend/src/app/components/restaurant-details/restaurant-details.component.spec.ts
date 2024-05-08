import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantDetailsComponent } from './restaurant-details.component';

describe('RestaurantDetailsComponent', () => {
  let component: RestaurantDetailsComponent;
  let fixture: ComponentFixture<RestaurantDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RestaurantDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RestaurantDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
